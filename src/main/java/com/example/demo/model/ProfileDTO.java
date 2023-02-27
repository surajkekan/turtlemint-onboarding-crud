package com.example.demo.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "requests")
public class ProfileDTO {
    @Id
    private String requestId;
    private String vertical;
    private String make;
    private String model;

}
