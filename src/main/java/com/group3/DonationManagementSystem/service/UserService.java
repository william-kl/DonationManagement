package com.group3.DonationManagementSystem.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.group3.DonationManagementSystem.dto.UserRegistrationDto;
import com.group3.DonationManagementSystem.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	List<User> getAllUsers();
	List<User> getAllActiveUsers();
	void delete(Long id);
	User get(Long id);
	void saveEditedUser(User u);
}
