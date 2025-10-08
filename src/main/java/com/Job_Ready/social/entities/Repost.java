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
@Table(name = "reposts")
public class Repost {
    @Id
    @Column(name = "repost_id", columnDefinition = "uuid")
    java.util.UUID repostId;

    @Column(name = "post_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID postId;

    @Column(name = "by_account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID byAccountId;

    @Column(name = "quote_text", columnDefinition = "text")
    String quoteText;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
