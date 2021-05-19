package com.group3.DonationManagementSystem.repository;

import com.group3.DonationManagementSystem.model.Cart;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByUserAndDonation(User user, Donation donation);
}
