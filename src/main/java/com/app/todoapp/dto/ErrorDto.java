package com.app.todoapp.dto;

import org.springframework.http.HttpStatus;

public class ErrorDto {

    private String message;
    private HttpStatus code;

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
