package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "TWResponse")
public class CurrentQuotation {
    private String requestId;
    private ArrayList<Insurer> supportedInsurers;
}
