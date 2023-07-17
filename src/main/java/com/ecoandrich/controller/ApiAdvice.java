package com.ecoandrich.controller;

import com.ecoandrich.controller.dto.response.ClientFailureResponse;
import com.ecoandrich.controller.dto.response.ServerFailureResponse;
import com.ecoandrich.support.exception.ParameterInValidException;
import com.ecoandrich.support.exception.UnExceptedRequestBodyException;
import com.ecoandrich.support.exception.WrongParameterNameException;
import com.ecoandrich.support.exception.WrongRateRangeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.ecoandrich.controller.dto.response.ResponseHelper.*;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApiAdvice {

    @ExceptionHandler(ParameterInValidException.class)
    public ResponseEntity<ClientFailureResponse<?>> exception(ParameterInValidException ex) {
        log.info(ex.getMessage(), ex);

        return clientFailureResponseHelper(ex.getMessage());
    }

    @ExceptionHandler(WrongRateRangeException.class)
    public ResponseEntity<ClientFailureResponse<?>> exception(WrongRateRangeException ex) {
        log.info(ex.getMessage(), ex);

        return clientFailureResponseHelper(ex.getMessage());
    }

    @ExceptionHandler(WrongParameterNameException.class)
    public ResponseEntity<ServerFailureResponse<?>> exception(WrongParameterNameException ex) {
        log.info(ex.getMessage(), ex);

        return serverFailureResponseHelper(ex.getMessage());
    }

    @ExceptionHandler(UnExceptedRequestBodyException.class)
    public ResponseEntity<ClientFailureResponse<?>> exception(UnExceptedRequestBodyException ex) {
        log.info(ex.getMessage(), ex);

        return clientFailureResponseHelper(ex.getMessage());
    }
}
