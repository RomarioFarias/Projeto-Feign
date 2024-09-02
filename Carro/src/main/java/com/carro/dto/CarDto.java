package com.carro.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private String id;

    @NotBlank(message = "{API_FIELDS_INVALID}")
    @Size(min = 1, max = 20, message = "LENGHT_NAME}")
    private String name;

    private String year;

    @NotBlank(message = "{API_FIELDS_INVALID}")
    @Size(min = 1, max = 50, message = "{LENGHT_NAME}")
    private String manufacturer;

}
