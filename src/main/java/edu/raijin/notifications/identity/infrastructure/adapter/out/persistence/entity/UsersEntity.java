package edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.entity;

import static lombok.AccessLevel.PRIVATE;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users", schema = "public")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class UsersEntity {

    @Id
    private UUID id;

    private String fullName;

    private String email;

    private String role;

    @UpdateTimestamp
    private Instant updatedAt;
}
