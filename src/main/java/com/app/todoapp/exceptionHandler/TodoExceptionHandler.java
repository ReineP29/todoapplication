package com.app.todoapp.exceptionHandler;

import com.app.todoapp.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {

@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleBadRequest(IllegalArgumentException e){
    ErrorDto dto=new ErrorDto();
    dto.setMessage(e.getMessage());
    dto.setCode(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleUnkownError(RuntimeException e){
    ErrorDto dto=new ErrorDto();
    dto.setMessage("Oops! Unknown error, try again!");
    dto.setCode(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
}
}
