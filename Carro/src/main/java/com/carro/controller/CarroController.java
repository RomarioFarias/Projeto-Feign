package com.carro.controller;


import com.carro.dto.CarroDto;
import com.carro.entity.Carro;
import com.carro.service.CarroService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("v1/carro")
@Slf4j
public class CarroController {
    @Autowired
    private CarroService carroService;

    private ModelMapper modelMapper;

   public CarroController(){
        this.modelMapper = new ModelMapper();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarroDto salvarCarro(@RequestBody @Valid CarroDto carroDto) {
        Carro resultado = carroService.cadastrarCarro(modelMapper.map(carroDto, Carro.class));
        return modelMapper.map(resultado, CarroDto.class);
    }

    @GetMapping("/{id}")
    public Carro pegarCarroSelecionado(@PathVariable  String id) {
        log.debug("Carro id = {} ", id);
        return carroService.pegarCarroSelecionado(id);
    }
}
