package com.group3.DonationManagementSystem.controller;

import com.group3.DonationManagementSystem.dto.UserRegistrationDto;
import com.group3.DonationManagementSystem.exception.ResourceNotFoundException;
import com.group3.DonationManagementSystem.model.Cart;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.User;
import com.group3.DonationManagementSystem.service.CartServiceImpl;
import com.group3.DonationManagementSystem.service.DonationService;
import com.group3.DonationManagementSystem.service.DonationServiceImpl;
import com.group3.DonationManagementSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserViewController {

    @Autowired
    private DonationServiceImpl donationService;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/userview")
    public String userView(@ModelAttribute("shoppingCart") Cart shoppingCart, BindingResult result, Model model) {
        model.addAttribute("donations", donationService.getAllDonations())
                .addAttribute("shoppingCart", shoppingCart);
        return "userview";
    }

    @GetMapping("/makedonation/{donationId}")
    public String showDonationPage(@PathVariable("donationId") Long donationId, Model model) {
        model.addAttribute("donation", donationService.getDonationById(donationId))
                .addAttribute("cartItem", new Cart());

        return "makedonation";
    }

    @PostMapping("/cart")
    public String addDonationToCart(@ModelAttribute("donationId") Long donationId, @ModelAttribute("amount") double amount, @ModelAttribute("recurring") boolean recurring) {
        Donation donation = donationService.getDonationById(donationId);
        double addedAmount = cartService.addCartItem(donationId, 1L, amount, recurring);

        return "redirect:/userview";
    }

    @GetMapping("/shoppingcart")
    public String shoppingCart(Model model) {

        model.addAttribute("shoppingCart", cartService.getCartItems());

        return "shoppingcart";
    }

    @PostMapping("/orderconfirmation")
    public String orderConfirmation() {
        return "orderconfirmation";
    }
}
