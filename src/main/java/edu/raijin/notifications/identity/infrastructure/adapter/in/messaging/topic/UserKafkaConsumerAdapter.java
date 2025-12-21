package edu.raijin.notifications.identity.infrastructure.adapter.in.messaging.topic;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import edu.raijin.commons.infrastructure.adapter.messaging.event.identity.UserEvent;
import edu.raijin.commons.util.annotation.Adapter;
import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.usecase.SendConfirmationUseCase;
import edu.raijin.notifications.identity.infrastructure.adapter.in.messaging.mapper.UserEventMapper;
import lombok.RequiredArgsConstructor;

@Adapter
@Component
@RequiredArgsConstructor
public class UserKafkaConsumerAdapter {

    private final UserEventMapper mapper;
    private final SendConfirmationUseCase confirmUser;

    @KafkaListener(topics = "${kafka.topics.user-commands.topic}", id = "create", properties = "${kafka.topics.user-commands.default-value}")
    public void consumeRegisteredUser(UserEvent event) {
        User user = mapper.toDomain(event);
        confirmUser.sendConfirmation(user);
    }
}