package com.demo.models;

import java.util.Date;
import java.util.UUID;

public class ResetToken {

	private long tokenid;
	
	private String confirmationToken;
	
	private Date createdDate;

    private Users user;

	public ResetToken( Users user) {
		super();
		this.confirmationToken =UUID.randomUUID().toString();
		this.createdDate = new Date();
		this.user = user;
	}

	public ResetToken() {
		super();
	}

	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
    
	
	
    
}
