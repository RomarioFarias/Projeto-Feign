package com.carro.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Errors {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String field;
    private String message;
    private String code;

}
