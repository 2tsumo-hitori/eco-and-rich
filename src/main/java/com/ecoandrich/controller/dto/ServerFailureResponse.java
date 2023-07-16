package com.ecoandrich.controller.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServerFailureResponse<T> {

    private final int httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private final HttpStatus message = HttpStatus.INTERNAL_SERVER_ERROR;

    private T data;

    public ServerFailureResponse(T data) {
        this.data = data;
    }
}
