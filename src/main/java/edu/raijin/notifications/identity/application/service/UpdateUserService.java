package edu.raijin.notifications.identity.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.raijin.commons.util.exception.ValueNotFoundException;
import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.port.persistence.UpdateUserPort;
import edu.raijin.notifications.identity.domain.usecase.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final UpdateUserPort update;

    @Override
    @Transactional
    public User update(UUID userId, User user) {
        User toUpdate = update.findById(userId)
                .orElseThrow(() -> new ValueNotFoundException("El empleado no se encuentra registrado"));

        toUpdate.updateFrom(user);
        return update.update(toUpdate);
    }
}
