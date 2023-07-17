package com.ecoandrich.controller;

import com.ecoandrich.controller.dto.response.SuccessResponse;
import com.ecoandrich.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ecoandrich.controller.dto.response.ResponseHelper.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/info")
    public ResponseEntity<SuccessResponse<?>> getDepartmentAndLocation() {
        return successResponseHelper(departmentService.getDepartmentAndLocation());
    }
}
