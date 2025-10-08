package com.Job_Ready.chat.entities;

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
@Table(name = "direct_conversations")
public class DirectConversation {
    @Id
    @Column(name = "conversation_id", columnDefinition = "uuid")
    java.util.UUID conversationId;

    @Column(name = "user_a", columnDefinition = "uuid", nullable = false)
    java.util.UUID userA;

    @Column(name = "user_b", columnDefinition = "uuid", nullable = false)
    java.util.UUID userB;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
