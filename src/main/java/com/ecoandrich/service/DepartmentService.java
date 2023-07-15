package com.ecoandrich.service;

import com.ecoandrich.service.appservice.DepartmentQueryService;
import com.ecoandrich.service.dto.GetDepartmentAndLocationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentQueryService departmentQueryService;

    public List<GetDepartmentAndLocationInfo> getDepartmentAndLocation() {
        return departmentQueryService.getDepartmentAndLocation();
    }
}
