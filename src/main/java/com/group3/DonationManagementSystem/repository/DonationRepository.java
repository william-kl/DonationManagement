package com.group3.DonationManagementSystem.repository;

import com.group3.DonationManagementSystem.model.Donation;
import com.group3.DonationManagementSystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("FROM Donation WHERE active = 1")
    List<Donation> getAllActiveDonations();

    @Query("FROM Transaction")
    List<Transaction> getAllTransactions();

    @Query("FROM Transaction WHERE donation_id = ?1")
    List<Transaction> getTransactionsByDonationId(Long empId);

//    @Query("FROM Transaction WHERE active = 1")
//    List<Transaction> getAllTransactionsForActiveDonations();
}
