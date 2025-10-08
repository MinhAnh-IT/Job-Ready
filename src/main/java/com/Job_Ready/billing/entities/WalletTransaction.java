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
@Table(name = "wallet_transactions")
public class WalletTransaction {
    @Id
    @Column(name = "txn_id", columnDefinition = "uuid")
    java.util.UUID txnId;

    @Column(name = "wallet_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID walletId;

    @Column(nullable = false)
    String direction;

    @Column(name = "amount_cents", nullable = false)
    Long amountCents;

    @Column(nullable = false)
    String method;

    @Column(name = "ref_type")
    String refType;

    @Column(name = "ref_id", columnDefinition = "uuid")
    java.util.UUID refId;

    @Column(nullable = false)
    String status;

    @Column(columnDefinition = "text")
    String description;

    @Column(name = "occurred_at", nullable = false)
    OffsetDateTime occurredAt;

    @Column(name = "balance_after_cents")
    Long balanceAfterCents;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
