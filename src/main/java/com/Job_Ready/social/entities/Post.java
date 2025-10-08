package com.Job_Ready.social.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "post_id", columnDefinition = "uuid")
    UUID postId;

    @Column(name = "author_account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID authorAccountId;

    @Column(columnDefinition = "text", nullable = false)
    String content;

    @Column(nullable = false)
    String visibility;

    @Column(name = "upvote_count", nullable = false)
    Integer upvoteCount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PostMedia> medias = new ArrayList<>();
}
