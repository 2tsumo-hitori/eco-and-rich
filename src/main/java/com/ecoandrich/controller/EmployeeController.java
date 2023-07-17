package com.ecoandrich.controller;

import com.ecoandrich.aop.RateRangeValidation;
import com.ecoandrich.controller.dto.request.EmployeeUpdateInfoRequest;
import com.ecoandrich.controller.dto.response.SuccessResponse;
import com.ecoandrich.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ecoandrich.controller.dto.response.ResponseHelper.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/info/{employeeId}")
    public ResponseEntity<SuccessResponse<?>> findEmployeeInfoById(
            @PathVariable int employeeId
    ) {
        return successResponseHelper(employeeService.findEmployeeInfoById(employeeId));
    }

    @GetMapping("/info/history/{employeeId}")
    public ResponseEntity<SuccessResponse<?>> findEmployeeHistoricalInfoById(
            @PathVariable int employeeId
    ) {
        return successResponseHelper(employeeService.findEmployeeHistoricalInfos(employeeId));
    }

    @PostMapping("/{departmentId}/salary-increase/{rate}")
    @RateRangeValidation(rate = "rate")
    public ResponseEntity<SuccessResponse<?>> updateDepartmentSalaryInfo(
            @PathVariable int departmentId,
            @PathVariable int rate
    ) {
        return successResponseHelper(employeeService.updateDepartmentSalaryInfo(departmentId, rate));
    }

    @PostMapping("/info/update/{employeeId}")
    public ResponseEntity<SuccessResponse<?>> updateEmployeeInfo(
            @PathVariable int employeeId,
            @RequestBody EmployeeUpdateInfoRequest request
    ) {
        return successResponseHelper(employeeService.updateEmployeeInfo(employeeId, request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPhoneNumber(), request.getHireDate(),
                request.getSalary(), request.getCommissionPct(), request.getManagerId(),
                request.getJobId(), request.getDepartmentId()));
    }
}