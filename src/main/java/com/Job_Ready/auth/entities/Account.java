package com.Job_Ready.auth.entities;

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
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_id", columnDefinition = "uuid")
    java.util.UUID accountId;

    @Column(nullable = false, unique = true, length = 64)
    String username;

    @Column(nullable = false, unique = true)
    String email;

    @Column(name = "password_hash")
    String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider", nullable = false)
    AuthProvider authProvider;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AccountStatus status;

    @Column(name = "email_verified_at")
    OffsetDateTime emailVerifiedAt;

    @Column(name = "last_login_at")
    OffsetDateTime lastLoginAt;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;
}
