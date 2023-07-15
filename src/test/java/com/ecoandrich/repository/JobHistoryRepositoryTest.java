package com.ecoandrich.repository;

import com.ecoandrich.domain.JobHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JobHistoryRepositoryTest {

    @Autowired
    JobHistoryRepository jobHistoryRepository;

    @Test
    void name() {
        List<JobHistory> jobHistories = jobHistoryRepository.findByEmployeeId(101);
        jobHistories.forEach(jobHistory -> {
            System.out.println(jobHistory.getPk().getStartDate());
        });
    }
}