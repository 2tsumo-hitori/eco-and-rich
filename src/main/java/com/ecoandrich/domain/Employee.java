package com.ecoandrich.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.ecoandrich.support.PreCondition.*;
import static java.util.Objects.*;
import static org.apache.logging.log4j.util.Strings.*;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private LocalDate hireDate;

    private int salary;

    @Column(name = "commission_pct", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    @JsonIgnore
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    @JsonIgnore
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    public void update(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, int salary, BigDecimal commissionPct, Employee manager, Job job, Department department) {
        require(isNotBlank(firstName));
        require(isNotBlank(lastName));
        require(isNotBlank(email));
        require(isNotBlank(phoneNumber));
        require(nonNull(hireDate));
        require(salary > 0);
        require(nonNull(commissionPct));
        require(nonNull(manager));
        require(nonNull(job));
        require(nonNull(department));

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.manager = manager;
        this.job = job;
        this.department = department;
    }
}
