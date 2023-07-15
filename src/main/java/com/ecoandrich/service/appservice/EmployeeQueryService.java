package com.ecoandrich.service.appservice;

import com.ecoandrich.domain.QEmployee;
import com.ecoandrich.service.dto.GetEmployeeHistoricalInfo;
import com.ecoandrich.service.dto.GetEmployeeStatusInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.ecoandrich.domain.QDepartment.department;
import static com.ecoandrich.domain.QEmployee.employee;
import static com.ecoandrich.domain.QJob.job;
import static com.ecoandrich.domain.QJobHistory.*;
import static com.ecoandrich.service.dto.GetEmployeeStatusInfo.*;
import static com.querydsl.core.types.Projections.constructor;

@Component
@RequiredArgsConstructor
public class EmployeeQueryService {
    private final JPAQueryFactory jpaQueryFactory;

    private static final QEmployee manager = new QEmployee("manager");

    public Optional<GetEmployeeStatusInfo> findEmployeeInfoById(int employeeId) {
        GetEmployeeStatusInfo getEmployeeStatusInfo = jpaQueryFactory.select(
                        constructor(GetEmployeeStatusInfo.class,
                                constructor(GetEmployeeInfo.class,
                                        employee.id,
                                        employee.firstName,
                                        employee.lastName,
                                        employee.email,
                                        employee.phoneNumber,
                                        employee.hireDate,
                                        employee.salary,
                                        employee.commissionPct),
                                constructor(GetJobInfo.class,
                                        job.id,
                                        job.jobTitle),
                                constructor(GetManagerInfo.class,
                                        employee.manager.id,
                                        employee.manager.firstName,
                                        employee.manager.lastName),
                                constructor(GetDepartmentInfo.class,
                                        department.id,
                                        department.departmentName)))
                .from(employee)
                .leftJoin(employee.job, job)
                .leftJoin(employee.manager, manager)
                .leftJoin(employee.department, department)
                .where(employee.id.eq(employeeId))
                .fetchOne();

        return Optional.ofNullable(getEmployeeStatusInfo);
    }

    public Optional<GetEmployeeHistoricalInfo> findHistoricalInfoById(int employeeId) {
        GetEmployeeHistoricalInfo historicalInfo = jpaQueryFactory.select(
                        constructor(GetEmployeeHistoricalInfo.class,
                                constructor(GetEmployeeHistoricalInfo.GetEmployeeInfo.class,
                                        jobHistory.pk.employee.id,
                                        jobHistory.pk.employee.firstName,
                                        jobHistory.pk.employee.lastName,
                                        jobHistory.pk.employee.email,
                                        jobHistory.pk.employee.phoneNumber,
                                        jobHistory.pk.employee.hireDate,
                                        jobHistory.pk.employee.salary,
                                        jobHistory.pk.employee.commissionPct
                                )
                        )
                ).from(jobHistory)
                .where(jobHistory.pk.employee.id.eq(employeeId))
                .fetchFirst();

        return Optional.ofNullable(historicalInfo);
    }
}
