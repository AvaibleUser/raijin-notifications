package edu.raijin.notifications.identity.domain.usecase;

import java.util.UUID;

import edu.raijin.commons.util.annotation.UseCase;
import edu.raijin.notifications.identity.domain.model.User;

@UseCase
public interface CreateUserUseCase {

    UUID create(User user);
}
