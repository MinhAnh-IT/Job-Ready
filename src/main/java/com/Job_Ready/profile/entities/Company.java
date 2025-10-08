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
@Table(name = "companies")
public class Company {
    @Id
    @Column(name = "company_id", columnDefinition = "uuid")
    java.util.UUID companyId;

    @Column(name = "account_id", unique = true, columnDefinition = "uuid", nullable = false)
    java.util.UUID accountId;

    @Column(name = "company_name", unique = true, nullable = false)
    String companyName;

    @Column(name = "company_type_id", columnDefinition = "uuid")
    java.util.UUID companyTypeId;

    @Column(columnDefinition = "text")
    String website;

    @Column(name = "size_range")
    String sizeRange;

    Integer foundedYear;

    String country;

    @Column(name = "logo_url")
    String logoUrl;

    @Column(columnDefinition = "text")
    String about;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
