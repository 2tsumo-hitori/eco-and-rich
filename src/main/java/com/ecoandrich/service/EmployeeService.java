package com.ecoandrich.service;

import com.ecoandrich.repository.JobHistoryRepository;
import com.ecoandrich.service.appservice.EmployeeQueryService;
import com.ecoandrich.service.dto.GetEmployeeHistoricalInfo;
import com.ecoandrich.service.dto.GetEmployeeInfo;
import com.ecoandrich.support.PreCondition;
import com.ecoandrich.support.exception.ParameterInValidException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import static com.ecoandrich.service.dto.GetEmployeeHistoricalInfo.*;
import static com.ecoandrich.service.dto.GetEmployeeHistoricalInfo.GetDepartmentInfo;
import static com.ecoandrich.service.dto.GetEmployeeHistoricalInfo.GetJobInfo;
import static com.querydsl.core.types.Projections.constructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeQueryService employeeQueryService;

    private final JobHistoryRepository jobHistoryRepository;

    public GetEmployeeInfo findEmployeeInfoById(int employeeId) {
        return employeeQueryService.findEmployeeInfoById(employeeId);
    }

    public GetEmployeeHistoricalInfo findEmployeeHistoricalInfos(int employeeId) {
        GetEmployeeHistoricalInfo historicalInfo = employeeQueryService.findHistoricalInfoById(employeeId)
                .orElseThrow(PreCondition::throwMessage);

        jobHistoryRepository.findByEmployeeId(employeeId)
                .forEach(jobHistory ->
                    historicalInfo.getHistoricalInfo().add(new GetHistoricalInfo(jobHistory.getPk().getStartDate(),
                            new GetDepartmentInfo(jobHistory.getDepartment().getId(), jobHistory.getDepartment().getDepartmentName()),
                            new GetJobInfo(jobHistory.getJob().getId(), jobHistory.getJob().getJobTitle()), jobHistory.getEndDate()))
                );

        return historicalInfo;
    }
}
