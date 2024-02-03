package com.carro.service.impl;

import com.carro.entity.EntityCar;
import com.carro.repository.CarroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarroRepository carroRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void postCar() {
        var car = EntityCar.getCarro();
        Mockito.when(carroRepository.save(car)).thenReturn(car);
        var carResult = carService.createCar(car);
        Assertions.assertEquals(carResult.getId(), car.getId());
    }

}