package com.example.demo.services;

import com.example.demo.model.Checkout;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CheckoutService {
    List<Checkout> getAllCheckouts();

    Checkout getCheckoutByCheckoutId(String checkoutId);

    void addCheckout(Checkout checkout);

    Checkout updateCheckout(String checkoutId, Checkout checkout);

    void deleteCheckout(String checkoutId);
}
