package com.group3.DonationManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;

    private String donationType;

    private Boolean canRecur;

    @OneToMany(mappedBy = "donation",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Transaction> transactionList;

    // region GETTERS/SETTERS
    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public Boolean getCanRecur() {
        return canRecur;
    }

    public void setCanRecur(Boolean canRecur) {
        this.canRecur = canRecur;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
    // endregion

    // region METHODS
    public void addTransactionEntry(Transaction transaction) {
        if (transaction != null) {
            if (transactionList == null) {
                transactionList = new ArrayList<>();
            }
            transaction.setDonation(this);
            transactionList.add(transaction);
        }
    }
    // endregion

    @Override
    public String toString() {
        return "Donation:/n" +
                "Donation Id: " + donationId +
                "/nDonation Type: " + donationType +
                "/nCan Recur? " + canRecur;
    }
}
