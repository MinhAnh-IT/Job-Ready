package com.Job_Ready.notification.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "notification_preferences")
public class NotificationPreference {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID accountId;

    @Column(nullable = false)
    String type;

    @Column(nullable = false)
    String channel;

    @Column(nullable = false)
    Boolean enabled;
}
