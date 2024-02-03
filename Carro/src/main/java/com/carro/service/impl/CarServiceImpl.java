package com.carro.service.impl;

import com.carro.entity.Car;
import com.carro.enums.ExceptionMessages;
import com.carro.exception.ResourceNotFound;
import com.carro.repository.CarRepository;
import com.carro.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;


    @Override
    public Car createCar(Car car) {
        car.setId(UUID.randomUUID().toString());
        carRepository.save(car);
        log.debug("Carro id = {} ", car.getId());
        return car;
    }

    @Override
    public Car getCarById(String carId) {
        log.debug("car id = {} ", carId);
        return carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFound(carId, ExceptionMessages.CAR_NOT_FOUND));
    }
}
