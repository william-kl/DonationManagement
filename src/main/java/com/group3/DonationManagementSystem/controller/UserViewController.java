package com.group3.DonationManagementSystem.controller;

import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.service.DonationService;
import com.group3.DonationManagementSystem.service.DonationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserViewController {

    @Autowired
    private DonationServiceImpl donationService;

    @GetMapping("/userview")
    public String userView(Model model) {
        model.addAttribute("donations", donationService.getAllDonations());
        return "userview";
    }
}
