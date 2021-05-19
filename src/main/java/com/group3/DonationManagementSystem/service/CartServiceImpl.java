package com.group3.DonationManagementSystem.service;

import com.group3.DonationManagementSystem.model.Cart;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    DonationServiceImpl donationService;

    @Autowired
    UserServiceImpl userService;

    @Override
    public List<Cart> getCartItems() {
        List<Cart> cartItems = cartRepository.findAll();
        return cartItems;
    }

    @Override
    public void addCartItemForUser(Cart cartItem) {
        cartRepository.save(cartItem);
    }

//    @Override
    public double addCartItem(Long donationId, Long id, double amount, boolean recurring) {
        double addedAmount = amount;
        Donation donation = donationService.getDonationById(donationId);
        User user = userService.get(id);

        Cart cartItem = cartRepository.findByUserAndDonation(user, donation);

        if (cartItem != null) {
            addedAmount = cartItem.getAmount() + amount;
            cartItem.setAmount(addedAmount);
        } else {
            cartItem = new Cart();
            cartItem.setAmount(amount);
            cartItem.setUser(user);
            cartItem.setDonation(donation);
            cartItem.setRecurring(recurring);
            cartItem.setDate(LocalDate.now());
        }

        cartRepository.save(cartItem);

        return addedAmount;
    }

}
