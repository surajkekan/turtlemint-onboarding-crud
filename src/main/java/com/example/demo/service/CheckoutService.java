package com.example.demo.service;

import com.example.demo.model.CheckoutDTO;
import com.example.demo.model.ProfileDTO;
import com.example.demo.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutService {
    @Autowired
    CheckoutRepository checkoutRepository;

    public CheckoutDTO createCheckout(CheckoutDTO checkout){
        checkoutRepository.save(checkout);
        return checkout;
    }
    public Optional<CheckoutDTO> getCheckoutByRequestId(String requestId){
        return checkoutRepository.findById(requestId);
    }

    public Optional<CheckoutDTO> updateCheckout(String requestId,CheckoutDTO checkout){
        Optional<CheckoutDTO> checkCheckout = checkoutRepository.findById(requestId);
        if(checkCheckout.isPresent()){
            CheckoutDTO existingCheckout=checkCheckout.get();
            if(!(checkout.getCustomerName().isEmpty())){
                existingCheckout.setCustomerName(checkout.getCustomerName());
            }
            if(!(checkout.getCustomerPhone().isEmpty())){
                existingCheckout.setCustomerPhone(checkout.getCustomerPhone());
            }
            if(!(checkout.getCustomerEmail().isEmpty())){
                existingCheckout.setCustomerEmail(checkout.getCustomerEmail());
            }
            if(!(checkout.getInsurerId().isEmpty())){
                existingCheckout.setInsurerId(checkout.getInsurerId());
            }
            checkoutRepository.save(existingCheckout);
            return Optional.of(existingCheckout);
        }
        return checkCheckout;
    }
    public void deleteCheckout(String requestId){
        checkoutRepository.deleteById(requestId);
    }
}
