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
@Table(name = "follows")
public class Follow {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "follower_account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID followerAccountId;

    @Column(name = "followee_account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID followeeAccountId;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
