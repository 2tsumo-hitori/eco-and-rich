package com.ecoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Job {
    @Id
    @Column(name = "job_id")
    private String id;

    private String jobTitle;

    @Column(precision = 8)
    private BigDecimal minSalary;

    @Column(precision = 8)
    private BigDecimal maxSalary;
}
