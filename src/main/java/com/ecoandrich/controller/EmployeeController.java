package com.ecoandrich.controller;

import com.ecoandrich.controller.dto.SuccessResponse;
import com.ecoandrich.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
