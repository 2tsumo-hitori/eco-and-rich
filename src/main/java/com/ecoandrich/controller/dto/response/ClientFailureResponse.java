package com.ecoandrich.controller.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ClientFailureResponse<T> {

    private final int httpStatus = HttpStatus.NOT_FOUND.value();

    private final HttpStatus message = HttpStatus.NOT_FOUND;

    private T data;

    public ClientFailureResponse(T data) {
        this.data = data;
    }
}
