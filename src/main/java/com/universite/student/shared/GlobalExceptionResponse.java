package com.universite.student.shared;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionResponse {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalResponse<?>> HandleValidationException(MethodArgumentNotValidException ex) {

        var errors = ex.getBindingResult().getFieldErrors().stream().map(err -> new GlobalResponse.ErrorItem(err.getField() + " " + err.getDefaultMessage())).toList();
        return new ResponseEntity<>(new GlobalResponse<>(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GlobalResponse<?>> HandleNoResourceException(NoResourceFoundException ex) {

        var errors = List.of(
                new GlobalResponse.ErrorItem("Resource is  not found  "),
                new GlobalResponse.ErrorItem("please check   your request !!!")
        );
        return new ResponseEntity<>(new GlobalResponse<>(errors), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomResponseException.class)
    public ResponseEntity<GlobalResponse<?>> HandleCustemResException(CustomResponseException ex) {
        var data = List.of(ex.getMessage());
        return new ResponseEntity<>(new GlobalResponse<>(data), HttpStatus.resolve(ex.getCode()));
    }


}
