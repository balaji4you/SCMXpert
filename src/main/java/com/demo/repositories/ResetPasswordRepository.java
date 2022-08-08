package com.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.models.ForgetPassword;

public interface ResetPasswordRepository extends MongoRepository<ForgetPassword, Integer> {
//	ResetToken findByConfirmationToken(String confirmationToken);
	

	
	public ForgetPassword findByEmailAndOtpGerated(String email, String otp);
}