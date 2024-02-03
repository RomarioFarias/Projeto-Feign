package com.carro.enums;

import lombok.Getter;

@Getter
public enum ExceptionMessages {
    CAR_NOT_FOUND("Car not found by id: ");


    final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
}
