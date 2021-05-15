package com.group3.DonationManagementSystem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegistrationDto {
	@NotEmpty(message = "First name can't be empty and it should have at least 2 characters")
	@Size(min = 2)
	private String firstName;
	
	@NotEmpty(message = "Last name can't be empty and it should have at least 2 characters")
	@Size(min = 2)
	private String lastName;
	
	@NotEmpty(message = "Email address can't be empty and it should contain @")
	private String email;
	
	@NotEmpty(message = "Last name can't be empty and it should have at least 6 characters")
	@Size(min = 6)
	private String password;
	
	public UserRegistrationDto() {}
	
	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
