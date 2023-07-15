package com.ecoandrich.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Test
    void name() {
        System.out.println(countryService.findAll());
    }
}