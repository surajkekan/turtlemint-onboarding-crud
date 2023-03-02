package com.example.demo.service;

import com.example.demo.entity.QueueEntity;
import com.example.demo.model.DequeueDTO;
import com.example.demo.model.EnqueueDTO;
import com.example.demo.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Stack;

@Service
public class QueueService {
    @Autowired
    QueueRepository queueRepository;
    @Autowired
    HelperService helperService;
    public String createQueue(){
        QueueEntity queueEntity= new QueueEntity();
        String id=helperService.getnewId();
        queueEntity.setId(id);
        queueEntity.setSt1(new Stack<Integer>());
        queueRepository.save(queueEntity);
        return id;
    }
    public String enque(EnqueueDTO enqueueDTO){
        Optional<QueueEntity> queueEntity=queueRepository.findById(enqueueDTO.getId());
        if(queueEntity.isPresent()){
            QueueEntity queue=queueEntity.get();
            Stack<Integer> st1=queue.getSt1();
            st1.push(enqueueDTO.getNumber());
            queue.setSt1(st1);
            queueRepository.save(queue);
            return "Successfully enqueued";
        }
        return "Queue Not Found";
    }

    public String deque(DequeueDTO dequeueDTO){
        Optional<QueueEntity> queueEntity=queueRepository.findById(dequeueDTO.getId());
        if(queueEntity.isPresent()){
            QueueEntity queue=queueEntity.get();
            Stack<Integer> st1=queue.getSt1();
            if(st1.size()==0){
                return "Empty Queue";
            }
            Stack<Integer> tempStack= new Stack<Integer>();
            while (st1.size()>0){
                tempStack.push(st1.pop());
            }
            Integer poped=tempStack.pop();
            while (tempStack.size()>0){
                st1.push(tempStack.pop());
            }
            queue.setSt1(st1);
            queueRepository.save(queue);
            return "Successfully dequeued '"+poped+"'";
        }
        return "Queue Not Found";
    }


}
