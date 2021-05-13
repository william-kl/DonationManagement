package com.group3.DonationManagementSystem.service;

import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }
}
