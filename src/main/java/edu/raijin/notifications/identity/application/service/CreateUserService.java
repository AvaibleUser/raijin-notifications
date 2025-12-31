package edu.raijin.notifications.identity.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.port.persistence.RegisterUserPort;
import edu.raijin.notifications.identity.domain.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final RegisterUserPort register;

    @Override
    @Transactional
    public UUID create(User user) {
        return register.register(user);
    }
}
