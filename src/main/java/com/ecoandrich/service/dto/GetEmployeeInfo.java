package com.ecoandrich.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class GetEmployeeInfo {
    private int employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDate hireDate;

    private int salary;

    private BigDecimal commissionPct;

    private GetJobInfo jobInfo;

    private GetManagerInfo managerInfo;

    private GetDepartmentInfo departmentInfo;

    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetJobInfo {
        private String jobId;

        private String jobTitle;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetManagerInfo {
        private int employeeId;

        private String firstName;

        private String lastName;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetDepartmentInfo {
        private int departmentId;

        private String departmentName;
    }
}
