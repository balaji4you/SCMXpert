package com.demo.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.models.Role;
import com.demo.models.Users;
import com.demo.repositories.UserRepository;

@Service
public class UserRegisterService implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserRegisterService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public Users save(Users registrationDto) {

		Users user = new Users(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList( new Role("ROLE_USER"),
	                    new Role("ROLE_ADMIN")));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	 public Users findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	 

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
	
	public Users findUserByResetToken(String resetToken) {
		return userRepository.findByResetToken(resetToken);
	}
//	public void findTokenPassword(String tokens,String email) {
//		Users tokenEmail=userRepository.findByEmail(email);
//		
//		if(tokenEmail!=null) {
//			tokenEmail.setResetpasswordToken(tokens);
//			userRepository.save(tokenEmail);
//		}
//		else {
//			
//		}
//		
//	}
//	
//	public Users getToken(String token) {
//		return userRepository.findByResetPasswordToken(token);
//	}
//	 
//	public void updatePassword(Users user,String newPassword) {
//		BCryptPasswordEncoder passwordEncode= new BCryptPasswordEncoder();
//		String encodePass=passwordEncode.encode(newPassword);
//		
//		user.setPassword(encodePass);
//		user.setResetpasswordToken(null);
//		userRepository.save(user);
//		
//	}
	   
}