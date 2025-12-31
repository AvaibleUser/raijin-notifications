package edu.raijin.notifications.scrum.domain.model;

import static lombok.AccessLevel.PRIVATE;

import java.time.Instant;
import java.util.UUID;

import edu.raijin.commons.domain.type.StoryPriority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class Story {

    private UUID id;

    private Long stageId;

    private UUID projectId;

    private UUID sprintId;

    private UUID productOwnerId;

    private UUID developerId;

    private String name;

    private String description;

    private Integer points;

    private StoryPriority priority;

    private String stage;

    private UUID actorId;

    private String eventType;

    private Instant occurredAt;
}
