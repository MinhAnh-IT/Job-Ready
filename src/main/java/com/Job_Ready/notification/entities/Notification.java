package com.Job_Ready.notification.entities;

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
@Table(name = "notifications")
public class Notification {
    @Id
    @Column(name = "notification_id", columnDefinition = "uuid")
    java.util.UUID notificationId;

    @Column(name = "account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID accountId;

    @Column(nullable = false)
    String type;

    @Column(columnDefinition = "jsonb", nullable = false)
    String payload;

    @Column(name = "is_read", nullable = false)
    Boolean isRead;

    @Column(name = "delivered_channels", columnDefinition = "jsonb", nullable = false)
    String deliveredChannels;

    @Column(name = "read_at")
    OffsetDateTime readAt;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
