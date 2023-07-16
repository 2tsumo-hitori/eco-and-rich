package com.ecoandrich.controller;

import com.ecoandrich.controller.dto.SuccessResponse;
import com.ecoandrich.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/info")
    public ResponseEntity<SuccessResponse<?>> getDepartmentAndLocation() {
        return ResponseEntity.ok(new SuccessResponse<>(departmentService.getDepartmentAndLocation()));
    }
}
