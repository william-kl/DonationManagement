package com.group3.DonationManagementSystem;

import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.service.DonationServiceImpl;
import com.group3.DonationManagementSystem.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DonationManagementSystemApplicationTests {

	@Autowired
	DonationServiceImpl donationService;

	@Autowired
	UserServiceImpl userService;

	// region DONATION CLASS TESTS
	@Test
	void testGetAllDonations() {
		List<Donation> donationList = donationService.getAllDonations();
		System.out.println("=== TEST getAllDonations ===");
		System.out.println("Should return 4 records");
		System.out.println(donationList);
		System.out.println(" ");
	}

	@Test
	void testGetTransactionsByDonationId() {
		List<Transaction> transactions = donationService.getTransactionsByDonationId(2L);

		System.out.println("=== TEST getTransactionsByDonationId ===");
		System.out.println("Should return 2 records for id 2: Run For the Sun 2021");
		System.out.println(transactions);
		System.out.println(" ");
	}
	// endregion


	@Test
	void testGetAllUsers() {
		List<User> userList = userService.getAllUsers();
		System.out.println("=== TEST getAllUsers ===");
		System.out.println("Should return 2 records");
		System.out.println(userList);
		System.out.println(" ");
	}


}
