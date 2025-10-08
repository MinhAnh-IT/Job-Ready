package com.Job_Ready.profile.entities;

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
@Table(name = "employment_histories")
public class EmploymentHistory {
    @Id
    @Column(columnDefinition = "uuid")
    java.util.UUID id;

    @Column(name = "candidate_id", columnDefinition = "uuid", nullable = false)
    java.util.UUID candidateId;

    @Column(name = "company_id", columnDefinition = "uuid")
    java.util.UUID companyId;

    @Column(name = "company_name")
    String companyName;

    @Column(name = "position_title")
    String positionTitle;

    @Column(name = "position_id", columnDefinition = "uuid")
    java.util.UUID positionId;

    @Column(name = "employment_type")
    String employmentType;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @Column(name = "is_current")
    Boolean isCurrent;

    @Column(name = "location_city")
    String locationCity;

    @Column(name = "location_country")
    String locationCountry;

    @Column(columnDefinition = "text")
    String description;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;
}
