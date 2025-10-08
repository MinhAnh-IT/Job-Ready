package com.Job_Ready.billing.entities;

import java.time.OffsetDateTime;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @Column(name = "subscription_id", columnDefinition = "uuid")
    java.util.UUID subscriptionId;

    @Column(name = "account_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID accountId;

    @Column(name = "package_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID packageId;

    @Column(nullable = false)
    String status;

    @Column(name = "start_date", nullable = false)
    LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    LocalDate endDate;

    @Column(name = "auto_renew", nullable = false)
    Boolean autoRenew;

    @Column(name = "next_billing_at")
    OffsetDateTime nextBillingAt;

    @Column(name = "cancel_at")
    OffsetDateTime cancelAt;

    @Column(columnDefinition = "jsonb", nullable = false)
    String meta;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;
}
