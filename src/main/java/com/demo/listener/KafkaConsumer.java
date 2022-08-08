package com.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.models.ShipmentDetails;
import com.demo.models.Users;

@Service
public class KafkaConsumer {

//    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//    }



    
    @KafkaListener(topics = "KafkaShipmentGoods", groupId = "shipment_goods")
    public void consumeJson(ShipmentDetails user) {
        System.out.println("Consumed JSON Message: " + user);
    }
    
    @KafkaListener(topics = "KafkaUsers", groupId = "users_kafka")
    public void consumeJson(Users user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}