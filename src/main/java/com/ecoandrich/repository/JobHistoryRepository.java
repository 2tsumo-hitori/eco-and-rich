package com.ecoandrich.repository;

import com.ecoandrich.domain.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    @Query("SELECT j FROM JobHistory j JOIN FETCH j.department JOIN FETCH j.job WHERE j.pk.employee.id = :employeeId")
    public List<JobHistory> findByEmployeeId(@Param("employeeId") int employeeId);
}
