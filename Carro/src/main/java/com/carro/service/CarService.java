package com.carro.service;

import com.carro.entity.Car;

public interface CarService {
    Car createCar(Car car);
    Car pegarCarroSelecionado(String carroId);
}
