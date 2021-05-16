package com.group3.DonationManagementSystem.service;

import com.group3.DonationManagementSystem.exception.ResourceNotFoundException;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;

import java.util.List;

public interface DonationService {
    List<Donation> getAllDonations();
    List<Donation> getAllActiveDonations();
    void addDonation(Donation donation);
    void deleteDonationById(Long id);

    void addTransactionByDonationId(Long id, Transaction transactionEntry) throws ResourceNotFoundException;
    List<Transaction> getAllTransactions();
//    List<Transaction> getAllTransactionsForActiveDonations();
}
