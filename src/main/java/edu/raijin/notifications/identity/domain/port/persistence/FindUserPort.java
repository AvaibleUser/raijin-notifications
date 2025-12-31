package edu.raijin.notifications.identity.domain.port.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.raijin.commons.util.annotation.Port;
import edu.raijin.notifications.identity.domain.model.User;

@Port
public interface FindUserPort {

    Optional<User> findById(UUID id);

    List<User> findAll(List<UUID> ids);
}
