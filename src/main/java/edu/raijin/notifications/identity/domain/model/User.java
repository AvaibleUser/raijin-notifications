package edu.raijin.notifications.identity.domain.model;

import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.lang3.ObjectUtils.firstNonNull;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Data
@With
@Builder
@Setter(NONE)
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class User {

    private UUID id;

    private String firstName;

    private String lastName;

    private String fullName;

    private String email;

    private String role;

    private String code;

    public void updateFrom(User updated) {
        this.firstName = firstNonNull(updated.firstName, firstName);
        this.lastName = firstNonNull(updated.lastName, lastName);
        this.role = firstNonNull(updated.role, role);
    }
}
