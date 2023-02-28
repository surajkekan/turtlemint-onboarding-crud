package com.example.demo.repository;

import com.example.demo.model.InsurerDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsurerRepository extends MongoRepository<InsurerDTO,String> {
    @Query("{'vertical': ?0 ,'make': ?1,'model': ?2}")
    Optional<List<InsurerDTO>> findAllByVerticalAndMakeAndModel(String vertical,String make,String model);

}
