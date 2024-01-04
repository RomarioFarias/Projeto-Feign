package com.carro.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "Carro")
public class Carro{
    @Id
    private String id;
    @Field("nome")
    @NotBlank(message = "{FIELD_INVALID}")
    private String nome;
    @NotBlank(message = "{FIELD_INVALID}")
    @Field("nome1")
    private String ano;
    @NotBlank(message = "{FIELD_INVALID}")
    @Field("nome2")
    private String fabricante;
}
