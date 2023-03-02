package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Stack;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Queue")
public class QueueEntity {
    @Id
    private String id;
    private Stack<Integer> st1;
}
