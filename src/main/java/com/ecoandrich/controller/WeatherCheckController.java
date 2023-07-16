package com.ecoandrich.controller;

import com.ecoandrich.service.appservice.OpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherCheckController {

    private final OpenApiService openApiService;

    @GetMapping("/weather")
    public String checkWeather() throws IOException {
        return openApiService.weatherCheck();
    }
}
