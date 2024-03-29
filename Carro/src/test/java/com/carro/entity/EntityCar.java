package com.carro.entity;

import com.carro.dto.CarDto;

public class EntityCar {
    public final static String ID = "29bd6f1e-aa69-43bd-8494-6b4d401969ff";
     final static String NAME = "Prisma";
     final static String YEAR = "2019";
     final static String MANUFACTURER = "Chevrolet";

    public static Car getCarro() {
        Car car = new Car();
        car.setId(ID);
        car.setManufacturer(MANUFACTURER);
        car.setYear(YEAR);
        car.setName(NAME);
        return car;
    }

    public static CarDto getCarroDto() {
        CarDto carDto = new CarDto();
        carDto.setId(ID);
        carDto.setManufacturer(MANUFACTURER);
        carDto.setYear(YEAR);
        carDto.setName(NAME);
        return carDto;
    }
}
