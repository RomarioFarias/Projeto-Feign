package com.carro.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarroDto {

    private String id;
    @Field("nome")
    private String nome;
    @NotBlank(message = "{FIELD_INVALID}")
    private String ano;
    @NotBlank(message = "{FIELD_INVALID}")
    private String fabricante;
}
