package com.demo.models;

public class ForgetPassword {
	private Integer id;

	private String email;

	private String otpGerated;

	private boolean status;
	

	public ForgetPassword() {
		super();
	}


	public ForgetPassword(Integer id, String email, String otpGerated, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.otpGerated = otpGerated;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getOtpGerated() {
		return otpGerated;
	}


	public void setOtpGerated(String otpGerated) {
		this.otpGerated = otpGerated;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
