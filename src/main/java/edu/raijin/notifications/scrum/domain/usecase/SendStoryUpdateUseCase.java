package edu.raijin.notifications.scrum.domain.usecase;

import edu.raijin.commons.util.annotation.UseCase;
import edu.raijin.notifications.scrum.domain.model.Story;

@UseCase
public interface SendStoryUpdateUseCase {

    void sendStoryUpdate(Story story);
}
