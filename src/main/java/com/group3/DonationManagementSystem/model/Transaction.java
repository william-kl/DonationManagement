package com.group3.DonationManagementSystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    // region CONSTRUCTOR(S)
    public Transaction() {};

    public Transaction(double amount, String date, boolean recurring, User user, Donation donation) {
        super();
        this.amount = amount;
        this.date = LocalDate.parse(date);
        this.recurring = recurring;
        this.user = user;
        this.donation = donation;
    }
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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");

        return "Transaction:\n" +
                "Transaction Id: " + transactionId +
                "\nAmount: $" + String.format("%.2f", amount) +
                "\nDate: " + dateFormatter.format(date) +
                "\nRecurring: " + recurring +
                "\nName: " + user.getFirstName() + " " + user.getLastName() +
                "\nDonation Type: " + donation.getDonationType() + "\n";
    }
}
