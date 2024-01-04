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
    private String nome;
    @Field("ano")
    private String ano;
    @Field("fabricante")
    private String fabricante;
}
