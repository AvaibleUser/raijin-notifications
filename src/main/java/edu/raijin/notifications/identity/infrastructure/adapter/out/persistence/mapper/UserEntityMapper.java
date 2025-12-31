package edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import edu.raijin.commons.util.annotation.Adapter;
import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.identity.infrastructure.adapter.out.persistence.entity.UsersEntity;

@Adapter
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    User toDomain(UsersEntity entity);

    @Mapping(target = "fullName", source = ".")
    UsersEntity toEntity(User domain);

    default String toFullName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
