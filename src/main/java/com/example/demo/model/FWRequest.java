package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FWRequest")
public class FWRequest {
    private String id;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;
    private String requestId;
}
