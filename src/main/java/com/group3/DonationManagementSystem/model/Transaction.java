package com.group3.DonationManagementSystem.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    // region VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private double amount;
    private LocalDate date;
    private boolean recurring;

    @ManyToOne  // allow bi-directional mapping so we can access User from Transaction
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @ManyToOne  // allow bi-directional mapping so we can access Donation from Transaction
    @JoinColumn(name = "donation_id", nullable = false)
    private Donation donation;
    // endregion

    // region GETTERS/SETTERS
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }
    // endregion

    @Override
    public String toString() {
        return "Transaction:/n" +
                "Transaction Id: " + transactionId +
                "/nAmount: " + amount +
                "/nDate: " + date +
                "/nRecurring: " + recurring +
                "/nName: " + user.getFirstName() + " " + user.getLastName() +
                "/nDonation Type: " + donation.getDonationType();
    }
}
