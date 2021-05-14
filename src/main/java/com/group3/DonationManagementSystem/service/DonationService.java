package com.group3.DonationManagementSystem.service;

import com.group3.DonationManagementSystem.exception.ResourceNotFoundException;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;

import java.util.List;

public interface DonationService {
    List<Donation> getAllDonations();
    void addDonation(Donation donation);
    void addTransactionByDonationId(Long id, Transaction transactionEntry) throws ResourceNotFoundException;
}
