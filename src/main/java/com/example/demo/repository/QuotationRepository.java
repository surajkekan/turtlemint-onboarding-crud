package com.example.demo.repository;

import com.example.demo.model.QuotationDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotationRepository extends MongoRepository<QuotationDTO,String> {

}
