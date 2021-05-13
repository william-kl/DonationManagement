package com.group3.DonationManagementSystem.repository;

import com.group3.DonationManagementSystem.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
