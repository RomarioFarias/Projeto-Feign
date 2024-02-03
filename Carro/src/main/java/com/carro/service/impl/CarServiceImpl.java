package com.carro.service.impl;

import com.carro.entity.Car;
import com.carro.repository.CarroRepository;
import com.carro.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    CarroRepository carroRepository;


    @Override
    public Car createCar(Car car) {
        car.setId(UUID.randomUUID().toString());
        carroRepository.save(car);
        log.debug("Carro id = {} ", car.getId());
        return car;
    }

    @Override
    public Car pegarCarroSelecionado(String carroId) {
        return null;
    }
}
