package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "quotation")
@AllArgsConstructor
@NoArgsConstructor
@CompoundIndex(def = "{'vertical': 1,'vehicleMake': 1, 'vehicleModel': 1}", unique = true)

public class Quotation {
    @Id
    private String id;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;
    private ArrayList<Insurer> supportedInsurers;
}
