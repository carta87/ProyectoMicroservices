package com.microservice.auth.exception.exceptiongeneric;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotUsernameFoundException extends RuntimeException{

    private final HttpStatus httpStatus;
    public NotUsernameFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
