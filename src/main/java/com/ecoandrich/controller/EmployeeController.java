package com.ecoandrich.controller;

import com.ecoandrich.aop.RateRangeValidation;
import com.ecoandrich.controller.dto.EmployeeUpdateInfoRequest;
import com.ecoandrich.controller.dto.SuccessResponse;
import com.ecoandrich.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/info/{employeeId}")
    public ResponseEntity<SuccessResponse<?>> findEmployeeInfoById(@PathVariable int employeeId) {
        return ResponseEntity.ok(new SuccessResponse<>(employeeService.findEmployeeInfoById(employeeId)));
    }

    @GetMapping("/history/info/{employeeId}")
    public ResponseEntity<SuccessResponse<?>> findEmployeeHistoricalInfoById(@PathVariable int employeeId) {
        return ResponseEntity.ok(new SuccessResponse<>(employeeService.findEmployeeHistoricalInfos(employeeId)));
    }

    @PostMapping("/{departmentId}/salary-increase/{rate}")
    @RateRangeValidation(rate = "rate")
    public ResponseEntity<SuccessResponse<?>> updateDepartmentSalaryInfo(@PathVariable int departmentId, @PathVariable int rate) {
        return ResponseEntity.ok(new SuccessResponse<>(employeeService.updateDepartmentSalaryInfo(departmentId, rate)));
    }

    @PostMapping("/info/{employeeId}")
    public ResponseEntity<SuccessResponse<?>> updateEmployeeInfo(
            @PathVariable int employeeId,
            @RequestBody EmployeeUpdateInfoRequest request
    ) {
        return ResponseEntity.ok(new SuccessResponse<>(employeeService.updateEmployeeInfo(employeeId, request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPhoneNumber(), request.getHireDate(),
                request.getSalary(), request.getCommissionPct(), request.getManagerId(),
                request.getJobId(), request.getDepartmentId())));
    }
}