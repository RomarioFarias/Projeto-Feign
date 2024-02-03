package com.carro.exception;

import com.carro.enums.ExceptionCode;
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    ExceptionCode exceptionCode;
    private static final HttpStatus httpStatus;

    public BusinessException(String message, ExceptionCode exceptionCode){
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(ExceptionCode exceptionCode){
        this.exceptionCode = exceptionCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    static {
        httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
