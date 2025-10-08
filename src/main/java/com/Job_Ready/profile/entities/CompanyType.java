package com.Job_Ready.profile.entities;

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
@Table(name = "company_types")
public class CompanyType {
    @Id
    @Column(name = "company_type_id", columnDefinition = "uuid")
    java.util.UUID companyTypeId;

    @Column(nullable = false, length = 128)
    String name;

    @Column(nullable = false, length = 128)
    String slug;

    @Column(columnDefinition = "text")
    String description;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
