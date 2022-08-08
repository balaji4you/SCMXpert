package com.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.models.ShipmentDetails;

public interface ShipmentRepository extends MongoRepository<ShipmentDetails,String>{

}
