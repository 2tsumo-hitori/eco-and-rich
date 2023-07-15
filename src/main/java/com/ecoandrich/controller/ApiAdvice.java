package com.ecoandrich.controller;

import com.ecoandrich.controller.dto.ClientFailureResponse;
import com.ecoandrich.support.exception.ParameterInValidException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApiAdvice {

    @ExceptionHandler(ParameterInValidException.class)
    public ResponseEntity<ClientFailureResponse<String>> exception(ParameterInValidException ex) {
        log.info(ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ClientFailureResponse<>(ex.getMessage()));
    }
}
