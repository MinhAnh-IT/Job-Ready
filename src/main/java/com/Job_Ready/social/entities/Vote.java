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
@Table(name = "votes")
public class Vote {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "post_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID postId;

    @Column(name = "account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID accountId;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
