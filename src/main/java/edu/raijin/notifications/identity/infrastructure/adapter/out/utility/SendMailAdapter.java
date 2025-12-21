package edu.raijin.notifications.identity.infrastructure.adapter.out.utility;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import java.io.File;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import edu.raijin.commons.util.annotation.Adapter;
import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.port.utility.SendConfirmationPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Adapter
@Component
@RequiredArgsConstructor
public class SendMailAdapter implements SendConfirmationPort {

    private final ITemplateEngine templateEngine;
    private final JavaMailSender mailSender;

    private void sendHtmlEmail(String companyName, String toEmail, String subject, String htmlContent,
            File... attachments) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        if (!isEmpty(attachments)) {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            Stream.of(attachments)
                    .map(FileSystemResource::new)
                    .forEach(file -> {
                        try {
                            messageHelper.addAttachment(file.getFilename(), file);
                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        message.setFrom(companyName);
        message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject(subject);
        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }

    private String render(String template, Map<String, Object> context) {
        Context ctx = new Context();
        ctx.setVariables(context);
        return templateEngine.process(template, ctx);
    }

    @Override
    public void sendConfirmation(User user) {
        String body = render("email/confirmation", Map.of("user", user, "code", user.getCode().toCharArray()));
        try {
            sendHtmlEmail("Raijin", user.getEmail(), "Código de Confirmación", body);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
