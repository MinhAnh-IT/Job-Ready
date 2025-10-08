package com.Job_Ready.moderation.entities;

import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "moderation_logs")
public class ModerationLog {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "moderator_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID moderatorId;

    @Column(nullable = false)
    String action;

    @Column(name = "target_type", nullable = false)
    String targetType;

    @Column(name = "target_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID targetId;

    @Column(columnDefinition = "jsonb", nullable = false)
    String details;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
