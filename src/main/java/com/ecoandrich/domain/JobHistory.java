package com.ecoandrich.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "job_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobHistory {

    @EmbeddedId
    private JobHistoryPK pk;

    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public int getDepartmentId() {
        return this.getDepartment().getId();
    }

    public String getDepartmentName() {
        return this.getDepartment().getDepartmentName();
    }

    public String getJobId() {
        return this.getJob().getId();
    }

    public String getJobTitle() {
        return this.getJob().getJobTitle();
    }

    public LocalDate getStartDate() {
        return this.getPk().getStartDate();
    }
}
