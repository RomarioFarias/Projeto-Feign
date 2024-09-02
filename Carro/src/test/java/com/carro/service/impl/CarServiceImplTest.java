package com.carro.service.impl;

import com.carro.entity.EntityCar;
import com.carro.enums.ExceptionMessages;
import com.carro.exception.ResourceNotFound;
import com.carro.i18.MessageService;
import com.carro.repository.CarRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Autowired
    MessageService messageService;
    @Test
    public void postCar() {
        var car = EntityCar.getCarro();
        when(carRepository.save(car)).thenReturn(car);
        var carResult = carService.createCar(car);
        Assertions.assertEquals(carResult.getId(), car.getId());
    }

    @Test
    public void getCarById() {
        var carId = EntityCar.ID;
        var car = EntityCar.getCarro();

        when(carRepository.findById(carId)).thenReturn(Optional.of(car));

        carService.getCarById(carId);
        Assertions.assertEquals(car.getId(), carId);
    }

    @Test
    public void returnResourceNotFoundCar() {
        var carId = EntityCar.ID;

        var resourceNotFound = Assert.assertThrows(ResourceNotFound.class, () -> carService.getCarById(carId));

        Assertions.assertEquals(resourceNotFound.getHttpStatus(), HttpStatus.NOT_FOUND);
    }
}