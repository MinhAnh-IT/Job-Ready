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
@Table(name = "reports")
public class Report {
    @Id
    @Column(name = "report_id", columnDefinition = "uuid")
    java.util.UUID reportId;

    @Column(name = "reporter_account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID reporterAccountId;

    @Column(name = "target_type", nullable = false)
    String targetType;

    @Column(name = "target_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID targetId;

    @Column(nullable = false)
    String reason;

    @Column(columnDefinition = "text")
    String description;

    @Column(nullable = false)
    String status;

    @Column(name = "moderator_id", columnDefinition = "uuid")
    java.util.UUID moderatorId;

    @Column(nullable = false)
    String action;

    @Column(name = "action_note")
    String actionNote;

    @Column(name = "resolved_at")
    OffsetDateTime resolvedAt;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;
}
