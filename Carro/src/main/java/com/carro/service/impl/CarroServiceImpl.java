package com.carro.service.impl;

import com.carro.entity.Carro;
import com.carro.repository.CarroRepository;
import com.carro.service.CarroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CarroServiceImpl implements CarroService {

    @Autowired
    CarroRepository carroRepository;


    @Override
    public Carro cadastrarCarro(Carro carro) {
        carro.setId(UUID.randomUUID().toString());
        carroRepository.save(carro);
        log.debug("Carro id = {} ", carro.getId());
        return carro;
    }

    @Override
    public Carro pegarCarroSelecionado(String carroId) {
        return null;
    }
}
