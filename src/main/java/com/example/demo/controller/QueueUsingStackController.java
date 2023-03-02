package com.example.demo.controller;

import com.example.demo.model.DequeueDTO;
import com.example.demo.model.EnqueueDTO;
import com.example.demo.service.QueueService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queue")

public class QueueUsingStackController {

    @Autowired
    QueueService queueService;
    @GetMapping("/createqueue")
    public  ResponseEntity<?> createQueue(){
        try {
            String id=queueService.createQueue();
            return  new ResponseEntity<>(id, HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/enqueue")
    public ResponseEntity<?> enQueue(@RequestBody EnqueueDTO enqueueDTO){
        try{
            String response=queueService.enque(enqueueDTO);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/dequeue")
    public ResponseEntity<?> deQueue(@RequestBody DequeueDTO dequeueDTO){
        try{
            String response=queueService.deque(dequeueDTO);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
