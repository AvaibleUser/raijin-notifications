package edu.raijin.notifications.scrum.application.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.port.persistence.FindUserPort;
import edu.raijin.notifications.scrum.domain.model.Story;
import edu.raijin.notifications.scrum.domain.port.utility.SendStoryUpdatePort;
import edu.raijin.notifications.scrum.domain.usecase.SendStoryUpdateUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendStoryUpdateService implements SendStoryUpdateUseCase {

    private final SendStoryUpdatePort send;
    private final FindUserPort findUser;

    @Override
    public void sendStoryUpdate(Story story) {
        List<UUID> ids = List.of(story.getDeveloperId(), story.getProductOwnerId());
        List<User> users = findUser.findAll(ids);
        User actor = findUser.findById(story.getActorId()).get();
        Set.copyOf(users).forEach(user -> send.sendStoryUpdate(story, user, actor));
    }
}
