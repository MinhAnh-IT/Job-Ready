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
@Table(name = "payments")
public class Payment {
    @Id
    @Column(name = "payment_id", columnDefinition = "uuid")
    java.util.UUID paymentId;

    @Column(name = "subscription_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID subscriptionId;

    @Column(name = "wallet_txn_id", columnDefinition = "uuid")
    java.util.UUID walletTxnId;

    @Column(name = "external_ref")
    String externalRef;

    @Column(name = "amount_cents", nullable = false)
    Long amountCents;

    @Column(nullable = false)
    String status;

    @Column(name = "paid_at")
    OffsetDateTime paidAt;

    @Column(name = "failure_reason")
    String failureReason;

    @Column(name = "invoice_url")
    String invoiceUrl;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
