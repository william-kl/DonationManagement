package com.group3.DonationManagementSystem.service;

import com.group3.DonationManagementSystem.model.Cart;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> getCartItemsForUser() {
        return null;
    }

    @Override
    public void addCartItemForUser(Cart cartItem) {
        cartRepository.save(cartItem);
    }

}
