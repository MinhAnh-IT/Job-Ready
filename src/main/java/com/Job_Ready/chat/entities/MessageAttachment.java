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
@Table(name = "message_attachments")
public class MessageAttachment {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "message_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID messageId;

    @Column(nullable = false)
    String url;

    @Column(name = "mime_type")
    String mimeType;

    @Column(name = "size_bytes")
    Long sizeBytes;

    @Column(name = "file_name")
    String fileName;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
