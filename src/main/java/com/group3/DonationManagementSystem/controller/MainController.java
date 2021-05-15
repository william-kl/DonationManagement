package com.group3.DonationManagementSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group3.DonationManagementSystem.dto.UserRegistrationDto;
import com.group3.DonationManagementSystem.exception.ResourceNotFoundException;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.repository.UserRepository;
import com.group3.DonationManagementSystem.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
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
		//List<Role> listRoles = roleService.getAllRoles();
		//model.addAttribute("listRoles", listRoles);
		model.addAttribute("listUsers", userService.getAllUsers());
		return "user";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name="id") Long id) throws ResourceNotFoundException{
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		userService.delete(id);
		return "redirect:/displayList";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name="id") Long id) throws ResourceNotFoundException{
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		ModelAndView mav = new ModelAndView("edit_user");//edit_user is a thymeleaf page
		User user_ = userService.get(id);//fetch user from repo
		mav.addObject("user", user_);//thymeleaf use key "user" to get user_
		return mav;
	}
	
	
	@PostMapping("/save")
	public String saveEditedUser(@ModelAttribute("user") User u) {//fetch "user" from thymleaf, put it in u
		userService.saveEditedUser(u);							//use UserRegistrationDto because password encoding
		return "redirect:/displayList";					//and userRoles will dissapear if we save user
														//directly
	}
	
	@GetMapping("users/new")
	public String showCreateNewUserPage(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "new_user";
	}
	
	@PostMapping("/save_new_user")  //receive th:action="@{/registration} and post it 
	public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto registrationDto, BindingResult result) {
		if (result.hasErrors()) {
			return "new_user";
		}
		userService.save(registrationDto);
		return "redirect:/displayList";
	}
	
}
