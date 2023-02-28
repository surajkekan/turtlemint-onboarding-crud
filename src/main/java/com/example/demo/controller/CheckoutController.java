package com.example.demo.controller;

import com.example.demo.model.CheckoutDTO;
import com.example.demo.model.InsurerDTO;
import com.example.demo.model.ProfileDTO;
import com.example.demo.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/turtle")
public class CheckoutController {
    @Autowired
    public CheckoutService checkoutService;
    @PostMapping(value = "/createcheckout")
    public ResponseEntity<?> createCheckout(@RequestBody CheckoutDTO checkout){
        try{
            CheckoutDTO response= checkoutService.createCheckout(checkout);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }catch( Exception e ){
            return  new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @RequestMapping(value = "/getcheckout", params = "requestId")
    public ResponseEntity<?> getCheckout( @RequestParam String requestId) {
        try{
            Optional<CheckoutDTO> checkout = checkoutService.getCheckoutByRequestId(requestId);
            if(!checkout.isPresent()) {
                Map<String, String> response = new HashMap<String, String>() {{
                    put("Data", "checkout not found");
                }};
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(checkout.get(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PutMapping(value = "/updatecheckout", params = "requestId")
    public ResponseEntity<?> updatecheckout(@RequestBody CheckoutDTO checkout, @RequestParam String requestId){
        try{
            Optional<CheckoutDTO> response = checkoutService.updateCheckout(requestId,checkout);
            if(response.isPresent()){
                return new ResponseEntity<>(response.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>("requestId not found", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @DeleteMapping(value = "/deletecheckout", params = "requestId")
    public ResponseEntity<?> deleteProfile(@RequestParam String requestId) {
        try{
            checkoutService.deleteCheckout(requestId);
            return new ResponseEntity<>("Checkout Deleted Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
