package com.carro.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Carro{
    private String id;
    @NotBlank(message = "{FIELD_INVALID}")
    private String nome;
    @NotBlank(message = "{FIELD_INVALID}")
    private String ano;
    @NotBlank(message = "{FIELD_INVALID}")
    private String fabricante;
}
