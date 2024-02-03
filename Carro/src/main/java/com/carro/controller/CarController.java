package com.carro.controller;


import com.carro.dto.CarDto;
import com.carro.entity.Car;
import com.carro.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("v1/car")
@Slf4j
public class CarController {

    @Autowired
    private CarService carService;

    private final ModelMapper modelMapper;

   public CarController(){
        this.modelMapper = new ModelMapper();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarDto createCar(@RequestBody @Valid CarDto carDto) {
        Car result = carService.createCar(modelMapper.map(carDto, Car.class));
        return modelMapper.map(result, CarDto.class);
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable  String id) {
        return carService.getCarById(id);
    }
}
