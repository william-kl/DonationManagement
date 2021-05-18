package com.group3.DonationManagementSystem.controller;

import com.group3.DonationManagementSystem.model.Transaction;
import com.group3.DonationManagementSystem.service.DonationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DonationManagementController {

    @Autowired
    private DonationServiceImpl donationService;

    @GetMapping("/donationmanagement")
    public String donation(Model model) {
        model.addAttribute("transactionsList", donationService.getAllTransactions());
        return "donationmanagement";
    }
}
