package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CheckoutDTO {
    @Id
    private String requestId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String insurerId;

}

