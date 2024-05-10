package com.example.plannerz_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientException extends RuntimeException {
    public ClientException(String message) {
        super(message);
    }
}
