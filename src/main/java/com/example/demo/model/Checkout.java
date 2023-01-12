package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

@Data
@Document(collection = "checkout")
@AllArgsConstructor
@NoArgsConstructor
public class Checkout {
    @Id
    private String checkoutId;
    private String requestId;
    private String name;
    private String email;
    private String phone;
    private String insurer;
}
