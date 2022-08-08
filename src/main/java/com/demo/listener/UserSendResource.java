package com.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.demo.models.ShipmentDetails;
import com.demo.models.Users;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
@RestController

public class UserSendResource {

    @Autowired
    private KafkaTemplate<String, ShipmentDetails> kafkaGoods;
    
    @Autowired
    private KafkaTemplate<String, Users> kafkaRegisterUsers;
    
    private static final String GOODS_TOPIC = "KafkaShipmentGoods";
    private static final String USERS_TOPIC = "KafkaUsers";
    

   
    public String post( ShipmentDetails name) {
    	final ListenableFuture<SendResult<String, ShipmentDetails>> future;
    	future = kafkaGoods.send(GOODS_TOPIC,name);
    	
    	future.addCallback(new ListenableFutureCallback<SendResult<String, ShipmentDetails>>() {
			@Override
			public void onSuccess(final SendResult<String,ShipmentDetails> result) {
			
					
			}

			@Override
			public void onFailure(final Throwable err) {
				 err.getMessage();
			}
		});
        return "Published successfully";
    }
    @GetMapping("/api/kafka/publish")
    public String postUsers( Users name) {
    	final ListenableFuture<SendResult<String,Users>> future;
    	future = kafkaRegisterUsers.send(USERS_TOPIC,name);
    	
    	future.addCallback(new ListenableFutureCallback<SendResult<String, Users>>() {
			@Override
			public void onSuccess(final SendResult<String,Users> result) {
			
					
			}

			@Override
			public void onFailure(final Throwable err) {
				 err.getMessage();
			}
		});
        return "Published successfully";
    }
   
}