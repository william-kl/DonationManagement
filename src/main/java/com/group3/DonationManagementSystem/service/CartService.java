package com.group3.DonationManagementSystem.service;


import com.group3.DonationManagementSystem.model.Cart;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.User;

import java.util.List;

public interface CartService {
    List<Cart> getCartItemsForUser();
    void addCartItemForUser(Cart cartItem);
}
