package com.ecoandrich.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmployeeHistoricalInfo {
    private GetEmployeeInfo employeeInfo;

    private List<GetHistoricalInfo> historicalInfo = new ArrayList<>();

    public GetEmployeeHistoricalInfo(GetEmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetEmployeeInfo {
        private int employeeId;

        private String firstName;

        private String lastName;

        private String email;

        private String phoneNumber;

        private LocalDate hireDate;

        private int salary;

        private BigDecimal commissionPct;
    }

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
    public static class GetDepartmentInfo {
        private int departmentId;

        private String departmentName;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GetHistoricalInfo {
        private LocalDate startDate;

        private GetDepartmentInfo departmentInfo;

        private GetJobInfo jobInfo;

        private LocalDate endDate;
    }
}
