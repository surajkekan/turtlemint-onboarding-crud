package com.example.demo.controller;

import com.example.demo.model.InsurerDTO;
import com.example.demo.model.ProfileDTO;
import com.example.demo.repository.InsurerRepository;
import com.example.demo.service.InsurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turtle")
public class InsurerController {
    @Autowired
    private InsurerService insurerService;
    @PostMapping("/addinsurer")
    public ResponseEntity<?> addInsurer(@RequestBody InsurerDTO insurer){
        try{
            InsurerDTO response =insurerService.addInsurer(insurer);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }catch ( Exception e ){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
