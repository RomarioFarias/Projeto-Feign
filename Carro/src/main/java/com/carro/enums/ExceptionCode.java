package com.carro.enums;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    API_FIELDS_INVALID_4411("4411"),
    INTERNAL_SERVER_ERROR("5000");
    final String code;

    ExceptionCode(String exceptionCode) {
        this.code = exceptionCode;
    }

}
