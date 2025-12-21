package edu.raijin.notifications.identity.domain.usecase;

import edu.raijin.commons.util.annotation.UseCase;
import edu.raijin.notifications.identity.domain.model.User;

@UseCase
public interface SendConfirmationUseCase {

    void sendConfirmation(User user);
}
