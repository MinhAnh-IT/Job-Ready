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
@Table(name = "tags")
public class Tag {
    @Id
    @Column(name = "tag_id", columnDefinition = "uuid")
    java.util.UUID tagId;

    @Column(nullable = false, length = 64)
    String name;

    @Column(nullable = false, length = 64)
    String slug;

    @Column(columnDefinition = "text")
    String description;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
