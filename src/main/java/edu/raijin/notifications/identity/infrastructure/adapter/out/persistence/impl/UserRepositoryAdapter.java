package edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import edu.raijin.commons.util.annotation.Adapter;
import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.domain.port.persistence.FindUserPort;
import edu.raijin.notifications.identity.domain.port.persistence.RegisterUserPort;
import edu.raijin.notifications.identity.domain.port.persistence.UpdateUserPort;
import edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.entity.UsersEntity;
import edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.mapper.UserEntityMapper;
import edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;

@Adapter
@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements RegisterUserPort, FindUserPort, UpdateUserPort {

    private final JpaUserRepository userRepository;
    private final UserEntityMapper mapper;

    @Override
    public UUID register(User user) {
        UsersEntity entity = mapper.toEntity(user);
        return userRepository.save(entity).getId();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<User> findAll(List<UUID> ids) {
        return userRepository.findAllById(ids)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public User update(User user) {
        UsersEntity entity = mapper.toEntity(user);
        return mapper.toDomain(userRepository.save(entity));
    }
}
