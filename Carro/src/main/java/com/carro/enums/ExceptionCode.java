package com.carro.enums;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    API_FIELDS_INVALID("4411"),
    NOT_FOUND_BY_ID("4412"),
    INTERNAL_SERVER_ERROR("5000");
    final String code;
    String[] parametros;

    ExceptionCode(String exceptionCode) {
        this.code = exceptionCode;
    }

    public ExceptionCode setParamentrosMensagem(String[] parametros) {
        this.parametros = parametros;
        return this;
    }

}
