package com.carro.repository;

import com.carro.entity.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ConssecionariaRepository extends MongoRepository<Carro, String> {
}
