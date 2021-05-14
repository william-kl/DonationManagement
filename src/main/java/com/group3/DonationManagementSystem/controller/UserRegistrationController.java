package com.group3.DonationManagementSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.DonationManagementSystem.dto.UserRegistrationDto;
import com.group3.DonationManagementSystem.service.UserService;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	@Autowired
	private UserService userService;


	/*
	@ModelAttribute("user")  //this "user" is the "user" in registration Thymeleaf
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	*/    //same purpose as below
	
	@GetMapping
	public String showRegistrationForm(Model model) {//Model model
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	@PostMapping  //receive th:action="@{/registration} and post it 
	public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto registrationDto, BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		}
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	
}
