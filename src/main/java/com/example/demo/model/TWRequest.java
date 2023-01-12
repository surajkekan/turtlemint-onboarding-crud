package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

@Document(collection = "TWRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TWRequest {
    @Id
    private String id;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;
    private String requestId;
}
