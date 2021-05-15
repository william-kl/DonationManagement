package com.group3.DonationManagementSystem.repository;

import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("FROM Transaction WHERE donation_id = ?1")
    List<Transaction> getTransactionsByDonationId(Long empId);

}
