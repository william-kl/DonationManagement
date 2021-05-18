package com.group3.DonationManagementSystem;

import com.group3.DonationManagementSystem.model.Cart;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.service.CartServiceImpl;
import com.group3.DonationManagementSystem.service.DonationServiceImpl;
import com.group3.DonationManagementSystem.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class DonationManagementSystemApplicationTests {

	@Autowired
	DonationServiceImpl donationService;

	@Autowired
	UserServiceImpl userService;

	@Autowired
	CartServiceImpl cartService;

	// region DONATION TESTS
	@Test
	void testGetAllDonations() {
		List<Donation> donationList = donationService.getAllDonations();
		System.out.println("=== TEST getAllDonations ===");
		System.out.println("Should return 5 records");
		System.out.println(donationList);
		System.out.println(" ");
	}

	@Test
	void testGetAllActiveDonations() {
		List<Donation> donationList = donationService.getAllActiveDonations();
		System.out.println("=== TEST getAllActiveDonations ===");
		System.out.println("Should return 4 records");
		System.out.println(donationList);
		System.out.println(" ");
	}

	@Test
	public void testDeleteDonationById() {
		System.out.println("=== TEST deleteDonationById ===");
		System.out.println("Deleting record 2: Run for the Sun 2021");
		donationService.deleteDonationById(2L);
		System.out.println(donationService.getAllActiveDonations());
		System.out.println(" ");
	}
	// endregion

	//region TRANSACTION TESTS
	@Test
	void testGetAllTransactions() {
		List<Transaction> transactionList = donationService.getAllTransactions();
		System.out.println("=== TEST getAllTransactions ===");
		System.out.println("Should return 6 records");
		System.out.println(transactionList);
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

	// region USER TESTS
	@Test
	void testGetAllUsers() {
		List<User> userList = userService.getAllUsers();
		System.out.println("=== TEST getAllUsers ===");
		System.out.println("Should return 4 records");
		System.out.println(userList);
		System.out.println(" ");
	}

	@Test
	void testGetAllActiveUsers() {
		List<User> userList = userService.getAllActiveUsers();
		System.out.println("=== TEST getAllActiveUsers ===");
		System.out.println("Should return 3 records");
		System.out.println(userList);
		System.out.println(" ");
	}

//	@Test
//	void testSaveEditedUser() {
//		User user = new User();
//		System.out.println("=== TEST saveEditedUser ===");
//		user.setFirstName("will");
//		user.setLastName("cai");
//		user.setEmail("hc740@");
//		user.setPassword("123456");
//		user.setRoles(Collections.singletonList(new Role("ADMIN")));
//		userService.saveEditedUser(user);
//		System.out.println(user);
//		System.out.println(" ");
//	}
	// endregion

	// region CART TESTS
	@Test
	void testAddCartItemForUser() {
		User user = userService.get(1L);
		Donation donation1 = donationService.getDonationById(1L);

		Cart cartItem = new Cart();
		cartItem.setDonation(donation1);
		cartItem.setUser(user);
		cartItem.setAmount(145.00);
		cartItem.setRecurring(true);
		cartItem.setDate(LocalDate.now());

		cartService.addCartItemForUser(cartItem);
	}
	// endregion

}
