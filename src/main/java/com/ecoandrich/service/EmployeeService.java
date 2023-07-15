package com.ecoandrich.service;

import com.ecoandrich.repository.JobHistoryRepository;
import com.ecoandrich.service.appservice.EmployeeQueryService;
import com.ecoandrich.service.dto.GetEmployeeHistoricalInfo;
import com.ecoandrich.service.dto.GetEmployeeStatusInfo;
import com.ecoandrich.support.PreCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import static com.querydsl.core.types.Projections.constructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeQueryService employeeQueryService;

    private final JobHistoryRepository jobHistoryRepository;

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
}
