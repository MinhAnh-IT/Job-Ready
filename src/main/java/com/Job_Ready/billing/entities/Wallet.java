package com.Job_Ready.billing.entities;

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
@Table(name = "wallets")
public class Wallet {
    @Id
    @Column(name = "wallet_id", columnDefinition = "uuid")
    java.util.UUID walletId;

    @Column(name = "account_id", columnDefinition = "uuid", unique = true, nullable = false)
    java.util.UUID accountId;

    @Column(name = "balance_cents", nullable = false)
    Long balanceCents;

    @Column(nullable = false, length = 3)
    String currency;

    @Column(nullable = false)
    String status;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;
}
