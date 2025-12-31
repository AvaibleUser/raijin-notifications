package edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.entity.UsersEntity;

@Repository
public interface JpaUserRepository extends JpaRepository<UsersEntity, UUID>, JpaSpecificationExecutor<UsersEntity> {

    Optional<UsersEntity> findById(UUID id);

    boolean existsById(UUID id);
}
