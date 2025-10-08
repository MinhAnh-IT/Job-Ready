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
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @Column(name = "message_id", columnDefinition = "uuid")
    java.util.UUID messageId;

    @Column(name = "conversation_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID conversationId;

    @Column(name = "sender_account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID senderAccountId;

    @Column(name = "message_type", nullable = false)
    String messageType;

    @Column(columnDefinition = "text")
    String message;

    @Column(name = "is_seen", nullable = false)
    Boolean isSeen;

    @Column(name = "sent_at", nullable = false)
    OffsetDateTime sentAt;
}
