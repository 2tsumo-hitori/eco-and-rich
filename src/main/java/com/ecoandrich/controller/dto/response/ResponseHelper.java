package com.ecoandrich.controller.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper<T> {

    private ResponseHelper() {}

    public static <T> ResponseEntity<SuccessResponse<?>> successResponseHelper(T t) {
        return ResponseEntity.ok(new SuccessResponse<>(t));
    }

    public static <T> ResponseEntity<ClientFailureResponse<?>> clientFailureResponseHelper(T t) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ClientFailureResponse<>(t));
    }

    public static <T> ResponseEntity<ServerFailureResponse<?>> serverFailureResponseHelper(T t) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServerFailureResponse<>(t));
    }
}
