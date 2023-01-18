package com.assignment.springvotingsystem.service.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidRequestParamException extends RuntimeException{

    public InvalidRequestParamException(String message) {
        super(message + "\n Error Status " + HttpStatus.BAD_REQUEST);
    }
}
