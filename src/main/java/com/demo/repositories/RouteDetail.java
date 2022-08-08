package com.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.models.RouteDetails;

public interface RouteDetail extends MongoRepository<RouteDetails,String>{

	RouteDetails findByName(List<RouteDetails> list);
}
