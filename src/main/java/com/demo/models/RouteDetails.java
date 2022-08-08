package com.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="RouteDetail")
public class RouteDetails {

	private String id;
    private String name;
    
    
	public RouteDetails(String name) {
		super();
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
