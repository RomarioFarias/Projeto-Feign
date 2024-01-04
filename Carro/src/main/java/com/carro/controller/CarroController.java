package com.carro.controller;


import com.carro.entity.Carro;
import com.carro.repository.ConssecionariaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
@RestController
@RequestMapping("v1/consessionaria")

@Slf4j
public class CarroController {
    @Autowired
    ConssecionariaRepository repository;

    @PostMapping
    public void salvarCarro(@RequestBody @Valid Carro carro) {
     //   logger.info("Carro com nome de:"+ carro.getNome());
        carro.setId(UUID.randomUUID().toString());
        repository.save(carro);
        log.debug("Carro id = "+ carro.getId());
    }

    @GetMapping("/{id}")
    public Carro pegarCarroSelecionado(@PathVariable  String id) {
        System.out.println(id);
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }
}
