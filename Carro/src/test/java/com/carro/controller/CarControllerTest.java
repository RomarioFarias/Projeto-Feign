package com.carro.controller;

import com.carro.dto.CarDto;
import com.carro.entity.Car;
import com.carro.entity.EntityCar;
import com.carro.exception.ApiExceptionHandler;
import com.carro.i18.MessageService;
import com.carro.mapper.JsonMapper;
import com.carro.repository.CarroRepository;
import com.carro.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@SpringBootTest
class CarControllerTest {

    @InjectMocks
    private CarController carController;
    @Mock
    private CarService carService;

    @Mock
    private CarroRepository carroRepository;

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
    public void successfullyCreatedCar() throws Exception {
        CarDto carDto = EntityCar.getCarroDto();
        Car car = EntityCar.getCarro();
        String requestBody = JsonMapper.toString(carDto);

        Mockito.when(carService.createCar(ArgumentMatchers.any(Car.class))).thenReturn(car);

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
        // Arrange
        CarDto carDto = EntityCar.getCarroDto();
        carDto.setName(null);// Create a valid CarDto
        String requestBody = JsonMapper.toString(carDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].message").value("Campo não pode ser nulo ou esta com valor incorreto"));
    }


}
