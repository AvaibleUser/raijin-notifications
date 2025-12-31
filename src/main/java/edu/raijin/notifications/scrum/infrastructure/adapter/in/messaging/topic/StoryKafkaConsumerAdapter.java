package edu.raijin.notifications.scrum.infrastructure.adapter.in.messaging.topic;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_KEY;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import edu.raijin.commons.infrastructure.adapter.messaging.event.scrum.StoryEvent;
import edu.raijin.commons.util.annotation.Adapter;
import edu.raijin.notifications.scrum.domain.model.Story;
import edu.raijin.notifications.scrum.domain.usecase.SendStoryUpdateUseCase;
import edu.raijin.notifications.scrum.infrastructure.adapter.in.messaging.mapper.StoryEventMapper;
import lombok.RequiredArgsConstructor;

@Adapter
@Component
@RequiredArgsConstructor
public class StoryKafkaConsumerAdapter {

    private final SendStoryUpdateUseCase send;
    private final StoryEventMapper mapper;

    @KafkaListener(topics = "${kafka.topics.story-commands.topic}", properties = "${kafka.topics.story-commands.properties}", groupId = "notifications-service")
    public void consumeRegisteredStory(@Payload StoryEvent event, @Header(RECEIVED_KEY) String key) {
        Story Story = mapper.toDomain(event);
        send.sendStoryUpdate(Story);
    }
}