package com.group3.DonationManagementSystem.model;

import javax.persistence.*;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;

    private String donationType;

    private Boolean canRecur;

    @OneToMany(mappedBy = "transaction",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
//    private List<TimeClock> timeClockEntries;

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
    // endregion

    @Override
    public String toString() {
        return "Donation:/n" +
                "Donation Id: " + donationId +
                "/nDonation Type: " + donationType +
                "/nCan Recur? " + canRecur;
    }
}
