package com.Job_Ready.social.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "post_tags")
public class PostTag {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "post_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID postId;

    @Column(name = "tag_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID tagId;
}
