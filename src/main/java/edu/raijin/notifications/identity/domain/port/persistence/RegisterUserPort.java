package edu.raijin.notifications.identity.domain.port.persistence;

import java.util.UUID;

import edu.raijin.commons.util.annotation.Port;
import edu.raijin.notifications.identity.domain.model.User;

@Port
public interface RegisterUserPort {

    UUID register(User user);
}
