package com.example.demo.repository;

import com.example.demo.model.ProfileDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileDTO,String> {

}
