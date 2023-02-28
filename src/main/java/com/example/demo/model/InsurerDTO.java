package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Insurers")
public class InsurerDTO {
    @Id
    private String insurerId;
    private String name;
    private String vertical;
    private String make;
    private String model;
    private String premium;

}
