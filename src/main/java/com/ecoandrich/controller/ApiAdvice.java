package com.ecoandrich.controller;

import com.ecoandrich.controller.dto.ClientFailureResponse;
import com.ecoandrich.controller.dto.ServerFailureResponse;
import com.ecoandrich.support.exception.ParameterInValidException;
import com.ecoandrich.support.exception.WrongParameterNameException;
import com.ecoandrich.support.exception.WrongRateRangeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ResponseEntity.*;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApiAdvice {

    @ExceptionHandler(ParameterInValidException.class)
    public ResponseEntity<ClientFailureResponse<String>> exception(ParameterInValidException ex) {
        log.info(ex.getMessage(), ex);

        return status(HttpStatus.NOT_FOUND)
                .body(new ClientFailureResponse<>(ex.getMessage()));
    }

    @ExceptionHandler(WrongRateRangeException.class)
    public ResponseEntity<ServerFailureResponse<String>> exception(WrongRateRangeException ex) {
        log.info(ex.getMessage(), ex);

        return status(HttpStatus.NOT_FOUND)
                .body(new ServerFailureResponse<>(ex.getMessage()));
    }

    @ExceptionHandler(WrongParameterNameException.class)
    public ResponseEntity<ServerFailureResponse<String>> exception(WrongParameterNameException ex) {
        log.info(ex.getMessage(), ex);

        return status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServerFailureResponse<>(ex.getMessage()));
    }
}
