package com.group3.DonationManagementSystem.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group3.DonationManagementSystem.dto.UserRegistrationDto;
import com.group3.DonationManagementSystem.model.Role;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public List<User> getAllActiveUsers() {
		return userRepository.getAllActiveUsers();
	}
	
	@Override
	public void delete(Long id) {
		User user = userRepository.getOne(id);
		//user.setActive(false);
		//userRepository.save(user);
		userRepository.delete(user);
	}

	@Override
	public User get(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void saveEditedUser(User user) {
//		User newUser = user;
//		newUser.setRoles = user.getRoles();
		userRepository.save(user);
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
							 registrationDto.getLastName(),
							 registrationDto.getEmail(),
							 passwordEncoder.encode(registrationDto.getPassword()),
							 Arrays.asList(new Role("USER")));
////		if (user.getRoles() == null) {
//			user.setRoles(Arrays.asList(new Role("USER")));
//		}
							
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
