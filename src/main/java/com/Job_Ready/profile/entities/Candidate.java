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
@Table(name = "candidates")
public class Candidate {
    @Id
    @Column(name = "candidate_id", columnDefinition = "uuid")
    java.util.UUID candidateId;

    @Column(name = "account_id", unique = true, columnDefinition = "uuid", nullable = false)
    java.util.UUID accountId;

    @Column(name = "full_name", length = 128)
    String fullName;

    String headline;

    @Column(columnDefinition = "text")
    String summary;

    @Column(name = "years_experience")
    Integer yearsExperience;

    @Column(name = "position_id", columnDefinition = "uuid")
    java.util.UUID positionId;

    @Column(columnDefinition = "text")
    String skills;

    @Column(name = "location_city")
    String locationCity;

    @Column(name = "location_country")
    String locationCountry;

    @Column(name = "avatar_url")
    String avatarUrl;

    @Column(name = "github_url")
    String githubUrl;

    @Column(name = "linkedin_url")
    String linkedinUrl;

    @Column(name = "created_at", nullable = false)
    OffsetDateTime createdAt;
}
