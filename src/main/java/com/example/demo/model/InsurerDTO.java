package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsurerDTO {
    @Id
    private String insurerId;
    private String name;
    private String vertical;
    private String make;
    private String model;

}
