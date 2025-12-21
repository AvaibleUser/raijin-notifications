package edu.raijin.notifications.identity.application.service;

import org.springframework.stereotype.Service;

import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.port.utility.SendConfirmationPort;
import edu.raijin.notifications.identity.domain.usecase.SendConfirmationUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendConfirmationService implements SendConfirmationUseCase {

    private final SendConfirmationPort send;

    @Override
    public void sendConfirmation(User user) {
        send.sendConfirmation(user);
    }
}
