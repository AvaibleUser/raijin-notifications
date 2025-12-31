package edu.raijin.notifications.scrum.infrastructure.adapter.in.messaging.mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import edu.raijin.commons.infrastructure.adapter.messaging.event.scrum.StoryEvent;
import edu.raijin.commons.util.annotation.Adapter;
import edu.raijin.notifications.scrum.domain.model.Story;

@Adapter
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StoryEventMapper {

    @Mapping(target = "actorId", source = "audit.actorId")
    @Mapping(target = "eventType", source = "audit.eventType")
    @Mapping(target = "occurredAt", source = "audit.occurredAt")
    Story toDomain(StoryEvent event);
}
