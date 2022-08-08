package com.demo.controllers;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.demo.listener.UserSendResource;
import com.demo.models.ReCaptchaResponse;
import com.demo.models.Users;
import com.demo.services.UserRegisterService;




@Controller
@RequestMapping("/register")
public class RegisterController {

	private UserRegisterService userService;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserSendResource kafkaservice;
	
	public RegisterController(UserRegisterService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public Users userRegistrationDto() {
		return new Users();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "signup";
	}

	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		StringTrimmerEditor stringEditor=new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringEditor);
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user")@Valid Users registrationDto,BindingResult results,@RequestParam(name="g-recaptcha-response") String captchaResponse) {
		String url = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6Lcc0HwUAAAAAE95NcYpjnL1eQ-EuIpViecOpWRQ&response="+captchaResponse;
		ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
		if(results.hasErrors()) {
			return "redirect:/register?error";
		}
	
		if(reCaptchaResponse.isSuccess()) {
			kafkaservice.postUsers(registrationDto);
			userService.save(registrationDto);

			return "redirect:/register?success";
		} else {
			
			return "redirect:/register?error";
		}
		
		
		
	
}
}