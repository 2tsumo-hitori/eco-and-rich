package com.ecoandrich.controller.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponse<T> {
    private final int httpStatus = HttpStatus.OK.value();

    private final HttpStatus message = HttpStatus.OK;

    private T data;

    public SuccessResponse(T data) {
        this.data = data;
    }
}
