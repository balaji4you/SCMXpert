package com.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Roles")
public class Role {

	  private String id;
	  private String role;
	  
	 
	public Role() {
		
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	  
}
