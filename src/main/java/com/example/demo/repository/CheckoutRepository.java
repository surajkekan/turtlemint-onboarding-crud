package com.example.demo.repository;

import com.example.demo.model.CheckoutDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends MongoRepository<CheckoutDTO,String > {

}
