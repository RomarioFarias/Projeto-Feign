package com.carro.repository;

import com.carro.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CarRepository extends MongoRepository<Car, String> {
}
