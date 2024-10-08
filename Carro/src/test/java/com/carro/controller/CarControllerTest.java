package com.carro.controller;

import com.carro.dto.CarDto;
import com.carro.entity.Car;
import com.carro.entity.EntityCar;
import com.carro.entity.Errors;
import com.carro.exception.ApiExceptionHandler;
import com.carro.i18.MessageService;
import com.carro.mapper.JsonMapper;
import com.carro.repository.CarRepository;
import com.carro.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CarControllerTest {

    @InjectMocks
    private CarController carController;
    @Mock
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    private MockMvc mockMvc;
    @Autowired
    MessageService messageService;
    private static final String URL = "/v1/car";


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(carController).setControllerAdvice(new ApiExceptionHandler(messageService)).build();
    }

    @Test
    void testMessageResolution() {
        String message = messageService.get(("API_FIELDS_INVALID"));
        System.out.println("Resolved message: " + message);
    }

    @Test
    public void successfullyCreatedCar() throws Exception {
        CarDto carDto = EntityCar.getCarroDto();
        Car car = EntityCar.getCarro();
        String requestBody = JsonMapper.toString(carDto);

        Mockito.when(carService.createCar(any(Car.class))).thenReturn(car);

        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(car.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value(car.getManufacturer()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(car.getYear()));
    }

    @Test
    void handleYourSpecificException() throws Exception {

        CarDto carDto = EntityCar.getCarroDto();
        carDto.setName(null);
        String requestBody = JsonMapper.toString(carDto);
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();

        TypeReference<List<Errors>> typeReference = new TypeReference<>(){};
        List<Errors> listErro = JsonMapper.toObjectList(result.getResponse().getContentAsString(),typeReference);

        Assertions.assertEquals(messageService.get(listErro.get(0).getMessage().replace("{", "").replace("}", "")), "Campo não pode ser nulo ou esta com valor incorreto");
    }

@Test
public void successfullyGetByIdCar() throws Exception {
    var carId = EntityCar.ID;
    var car = EntityCar.getCarro();
    var urlCustom = URL + "/" + carId;

    Mockito.when(carService.getCarById(carId)).thenReturn(car);

    mockMvc.perform(MockMvcRequestBuilders.get(urlCustom)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(car.getName()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value(car.getManufacturer()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(car.getYear()));
}


}
