package com.carro.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "Car")
public class Car {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("year")
    private String year;
    @Field("manufacturer")
    private String manufacturer;
}
