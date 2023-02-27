package com.example.demo.service;

import com.example.demo.model.InsurerDTO;
import com.example.demo.model.ProfileDTO;
import com.example.demo.repository.InsurerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurerService {
    @Autowired
    public InsurerRepository insurerRepository;
    @Autowired
    public HelperService helperService;
    public InsurerDTO addInsurer(InsurerDTO insurer){
        insurer.setInsurerId(helperService.getnewId());
        insurerRepository.save(insurer);
        return insurer;
    }

    public Optional<List<InsurerDTO>> getSupportedInsurers(String vertical,String make,String model){
        insurerRepository
    }
}
