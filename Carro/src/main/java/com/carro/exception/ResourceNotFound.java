package com.carro.exception;

import com.carro.enums.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ResourceNotFound extends BusinessException {
    private static final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public ResourceNotFound(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }


    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private String customMessage(String id, String message) {
        return message.concat(id);
    }

}
