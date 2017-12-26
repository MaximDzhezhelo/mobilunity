package com.staxter.mobilunity.controller;

import com.staxter.mobilunity.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    public static final String ERROR_RESPONSE = "{\n" +
            " \"code\": \"USER_ALREADY_EXISTS\",\n" +
            " \"description\": \"A user with the given username already exists\"\n" +
            "}";

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody String exceptionHandler(UserAlreadyExistsException e){
        return ERROR_RESPONSE;
    }

}
