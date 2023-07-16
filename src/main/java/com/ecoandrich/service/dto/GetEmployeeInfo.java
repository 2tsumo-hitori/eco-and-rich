package com.ecoandrich.service.dto;

import com.ecoandrich.domain.Department;
import com.ecoandrich.domain.Employee;
import com.ecoandrich.domain.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeInfo {

    private Employee manager;

    private Job job;

    private Department department;
}
