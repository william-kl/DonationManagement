package com.group3.DonationManagementSystem;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group3.DonationManagementSystem.repository.UserRepository;

@SpringBootTest
class DonationManagementSystemApplicationTests {
	@Autowired
	UserRepository repo;
	
	@Autowired
	EntityManager entityManager;

	
	@Test
	void contextLoads() {
	}
	/*
	@Test
	public void testCreateNewUserWithTwoRoles() {
		Role roleEditor = entityManager.find(Role.class, 2);
		Role roleVisitor = entityManager.find(Role.class, 2);
		
		User user = new User("will", "c", "hc740@", "111111");
		user.addRole(roleEditor);
		user.addRole(roleVisitor);
		
		repo.save(user);
	}
	*/

}
