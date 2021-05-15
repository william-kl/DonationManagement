package com.group3.DonationManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group3.DonationManagementSystem.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);

	@Query("FROM User WHERE active = 1")
	List<User> getAllActiveUsers();

}
