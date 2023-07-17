package com.ecoandrich.service;

import com.ecoandrich.domain.Employee;
import com.ecoandrich.repository.EmployeeRepository;
import com.ecoandrich.repository.JobHistoryRepository;
import com.ecoandrich.service.appservice.EmployeeQueryService;
import com.ecoandrich.service.dto.GetEmployeeHistoricalInfo;
import com.ecoandrich.service.dto.GetEmployeeInfo;
import com.ecoandrich.service.dto.GetEmployeeStatusInfo;
import com.ecoandrich.support.PreCondition;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeQueryService employeeQueryService;

    private final JobHistoryRepository jobHistoryRepository;

    private final EmployeeRepository employeeRepository;

    private static final String UPDATE_SUCCESS_MESSAGE = "변경 성공";


    public GetEmployeeStatusInfo findEmployeeInfoById(int employeeId) {

        return employeeQueryService.findEmployeeInfoById(employeeId)
                .orElseThrow(PreCondition::throwMessage);
    }

    public GetEmployeeHistoricalInfo findEmployeeHistoricalInfos(int employeeId) {

        GetEmployeeHistoricalInfo historicalInfo = employeeQueryService.findHistoricalInfoById(employeeId)
                .orElseThrow(PreCondition::throwMessage);

        jobHistoryRepository.findByEmployeeId(employeeId)
                .forEach(jobHistory ->
                    historicalInfo.addObject(
                            jobHistory.getStartDate(), jobHistory.getDepartmentId(), jobHistory.getDepartmentName(),
                            jobHistory.getJobId(), jobHistory.getJobTitle(), jobHistory.getEndDate()
                    )
                );

        return historicalInfo;
    }

    @Transactional
    public String updateDepartmentSalaryInfo(int departmentId, int rate) {
        employeeQueryService.employeeSalaryBulkUpdateByDepartmentId(departmentId, rate * 0.01 + 1);

        return UPDATE_SUCCESS_MESSAGE;
    }

    @Transactional
    public String updateEmployeeInfo(int employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, int salary, BigDecimal commissionPct, Long managerId, String jobId, Long departmentId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();

        GetEmployeeInfo employeeInfo = employeeQueryService.employeeInfo(managerId.intValue(), jobId, departmentId.intValue());

        employee.update(firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, employeeInfo.getManager(), employeeInfo.getJob(), employeeInfo.getDepartment());

        return UPDATE_SUCCESS_MESSAGE;
    }
}
