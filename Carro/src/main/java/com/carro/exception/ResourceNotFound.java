package com.carro.exception;

import com.carro.enums.ExceptionCode;
import com.carro.enums.ExceptionMessages;
import org.springframework.http.HttpStatus;

public class ResourceNotFound  extends BusinessException {
    private static final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public ResourceNotFound(String id, ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage().concat(id), ExceptionCode.API_FIELDS_INVALID);
    }


    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private String customMessage(String id, String message){
        return message.concat(id);
    }

}
