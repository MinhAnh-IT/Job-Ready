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
@Table(name = "packages")
public class PackageEntity {
    @Id
    @Column(name = "package_id", columnDefinition = "uuid")
    java.util.UUID packageId;

    @Column(nullable = false, unique = true)
    String name;

    @Column(columnDefinition = "text")
    String description;

    @Column(nullable = false)
    String period;

    @Column(name = "price_cents", nullable = false)
    Long priceCents;

    @Column(columnDefinition = "jsonb", nullable = false)
    String features;

    @Column(name = "is_active", nullable = false)
    Boolean isActive;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;
}
