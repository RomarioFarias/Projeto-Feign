package com.carro.service;

import com.carro.entity.Carro;

public interface CarroService {
    Carro cadastrarCarro(Carro carro);
    Carro pegarCarroSelecionado(String carroId);
}
