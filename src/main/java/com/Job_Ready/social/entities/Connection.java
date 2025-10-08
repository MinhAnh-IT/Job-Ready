package com.Job_Ready.social.entities;

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
@Table(name = "connections")
public class Connection {
    @Id
    @Column(name = "connection_id", columnDefinition = "uuid")
    java.util.UUID connectionId;

    @Column(name = "requester_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID requesterId;

    @Column(name = "addressee_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID addresseeId;

    @Column(nullable = false)
    String status;

    @Column(name = "requested_at", nullable = false)
    OffsetDateTime requestedAt;

    @Column(name = "responded_at")
    OffsetDateTime respondedAt;

    @Column(columnDefinition = "text")
    String message;
}
