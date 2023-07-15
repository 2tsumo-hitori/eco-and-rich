package com.ecoandrich.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Data
@JsonInclude(NON_NULL)
public class GetEmployeeHistoricalInfo {
    private GetEmployeeInfo employeeInfo;

    private List<GetHistoricalInfo> historicalInfo = new ArrayList<>();

    public GetEmployeeHistoricalInfo(GetEmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public void addObject(LocalDate startDate, int departmentId, String departmentName, String jobId, String jobTitle, LocalDate endDate) {
        historicalInfo.add(new GetHistoricalInfo(startDate, new GetDepartmentInfo(departmentId, departmentName), new GetJobInfo(jobId, jobTitle), endDate));
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
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
    @JsonInclude(NON_NULL)
    public static class GetJobInfo {

        private String jobId;

        private String jobTitle;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class GetDepartmentInfo {

        private int departmentId;

        private String departmentName;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class GetHistoricalInfo {

        private LocalDate startDate;

        private GetDepartmentInfo departmentInfo;

        private GetJobInfo jobInfo;

        private LocalDate endDate;
    }
}
