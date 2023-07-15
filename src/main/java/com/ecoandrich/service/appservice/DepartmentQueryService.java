package com.ecoandrich.service.appservice;

import com.ecoandrich.domain.QDepartment;
import com.ecoandrich.service.dto.GetDepartmentAndLocationInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.ecoandrich.domain.QDepartment.*;
import static com.ecoandrich.service.dto.GetDepartmentAndLocationInfo.*;
import static com.querydsl.core.types.Projections.constructor;

@Component
@RequiredArgsConstructor
public class DepartmentQueryService {

    private final JPAQueryFactory jpaQueryFactory;

    public List<GetDepartmentAndLocationInfo> getDepartmentAndLocation() {
        return jpaQueryFactory.select(
                        constructor(GetDepartmentAndLocationInfo.class,
                                constructor(GetDepartmentInfo.class,
                                        department.id,
                                        department.departmentName),
                                constructor(GetLocationInfo.class,
                                        department.location.id,
                                        department.location.streetAddress,
                                        department.location.postalCode,
                                        department.location.city,
                                        department.location.stateProvince)))
                .from(department)
                .fetch();
    }
}
