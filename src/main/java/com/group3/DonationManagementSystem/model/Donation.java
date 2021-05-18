package com.group3.DonationManagementSystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;

    private String donationType;
    private Boolean canRecur;
    private Boolean active;

    @OneToMany(mappedBy = "donation",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Transaction> transactionSet;

    // region CONSTRUCTOR(S)
    public Donation() {}

    public Donation(String donationType, Boolean canRecur, Set<Transaction> transactionSet) {
        super();
        this.donationType = donationType;
        this.canRecur = canRecur;
        this.transactionSet = transactionSet;
    }
    // endregion

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

    public Set<Transaction> getTransactionSet() {
        if (transactionSet == null) {
            transactionSet = new HashSet<>();
        }
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
    }
    // endregion

    // region METHODS
    public void addTransactionEntry(Transaction transaction) {
        if (transaction != null) {
            if (transactionSet == null) {
                transactionSet = new HashSet<>();
            }
            transaction.setDonation(this);
            transactionSet.add(transaction);
        }
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    // endregion

    @Override
    public String toString() {
        return "Donation:\n" +
                "Donation Id: " + donationId +
                "\nDonation Type: " + donationType +
                "\nCan Recur? " + canRecur +
                "\nIs Active? " + (active ? "true" : "false") + "\n";
    }
}
