package com.ecoandrich.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateInfoRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate hireDate;

    private int salary;

    private BigDecimal commissionPct;

    @NotNull
    private Long managerId;

    @NotNull
    private String jobId;

    @NotNull
    private Long departmentId;
}
