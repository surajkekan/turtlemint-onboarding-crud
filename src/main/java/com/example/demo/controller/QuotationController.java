package com.example.demo.controller;

import com.example.demo.model.InsurerDTO;
import com.example.demo.model.ProfileDTO;
import com.example.demo.model.QuotationDTO;
import com.example.demo.repository.InsurerRepository;
import com.example.demo.service.InsurerService;
import com.example.demo.service.ProfileService;
import com.example.demo.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/turtle")
public class QuotationController {
    @Autowired
    QuotationService quotationService;
    @Autowired
    ProfileService profileService;
    @Autowired
    InsurerService insurerService;
    @RequestMapping(value = "/getquotation", params = "requestId")
    public ResponseEntity<?> getQuotation(@RequestParam String requestId) {
        try{
            QuotationDTO quote=new QuotationDTO();
            quote.setRequestId(requestId);
            Optional<ProfileDTO> profile= profileService.getProfileByRequestId(requestId);
            if(!profile.isPresent()){
                return new ResponseEntity<>("requestId not found",HttpStatus.BAD_REQUEST);
            }
            String model=profile.get().getModel();
            String make=profile.get().getMake();
            String vertical=profile.get().getVertical();
            Optional<List<InsurerDTO>> supportedInsurers=insurerService.getSupportedInsurers(vertical,make,model);
            if (supportedInsurers.isPresent()){
                quote.setSupportedInsurers(supportedInsurers.get());
            }
            return new ResponseEntity<>(quote, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
