package com.group3.DonationManagementSystem.service;

import com.group3.DonationManagementSystem.exception.ResourceNotFoundException;
import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;
import com.group3.DonationManagementSystem.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public List<Donation> getAllActiveDonations() {
        return donationRepository.getAllActiveDonations();
    }

    @Override
    public void addDonation(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return donationRepository.getAllTransactions();
    }

//    @Override
//    public List<Transaction> getAllTransactionsForActiveDonations() {
//        return donationRepository.getAllTransactionsForActiveDonations();
//    }

    @Override
    public void addTransactionByDonationId(Long id, Transaction transactionEntry) throws ResourceNotFoundException {
        Donation donation;
        try {
            donation = donationRepository.getOne(id);
            donation.addTransactionEntry(transactionEntry);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Unable to locate donation by id: " + id);
        }
    }

    public List<Transaction> getTransactionsByDonationId(Long id) {
        return donationRepository.getTransactionsByDonationId(id);
    }

    @Transactional
    public void deleteDonationById(Long id) {
        Donation donation = donationRepository.getOne(id);
        donation.setActive(false);

        donationRepository.save(donation);
    }
}
