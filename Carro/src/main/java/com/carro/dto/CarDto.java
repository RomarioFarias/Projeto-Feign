package com.carro.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private String id;
    @NotBlank(message = "{FIELD_INVALID}")
    private String name;
    @NotBlank(message = "{FIELD_INVALID}")
    private String year;
    @NotBlank(message = "{FIELD_INVALID}")
    private String manufacturer;
}
