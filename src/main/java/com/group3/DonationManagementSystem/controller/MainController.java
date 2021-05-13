package com.group3.DonationManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group3.DonationManagementSystem.service.UserServiceImpl;

@Controller
public class MainController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		
		return "index";
	}
	
	@GetMapping("/displayList")//get the list of all the users
	public String listUsers(Model model) {
		model.addAttribute("listUsers", userServiceImpl.getAllUsers());
		return "user";
	}
}
