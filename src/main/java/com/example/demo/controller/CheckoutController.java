package com.example.demo.controller;

import com.example.demo.model.Checkout;
import com.example.demo.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class CheckoutController {
    @Autowired
    public CheckoutService checkoutService;
    @RequestMapping("/checkout")
    public List<Checkout> getAllCheckouts(){
        return checkoutService.getAllCheckouts();
    }

}
