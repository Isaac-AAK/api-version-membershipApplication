package com.iaktech.apiversionmembershipApplication.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter
@Setter
public class ChurchMemberProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    private String memberFirstName;

    private String memberLastName;

    private String memberPhoneNumber;

    private String memberStreetAddress;

    private String memberZipcode;

    private String memberCountry;

    private String memberEmail;

    @ManyToOne
    @JoinColumn(name = "churchgroupId")
    @JsonBackReference(value = "churchGroups")
    private ChurchGroups churchGroups;


    @ManyToOne
    @JoinColumn(name = "accountId")
    @JsonBackReference(value = "memberAccount")
    private Account memberAccount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate memberDateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memberRegistrationDate;

    public ChurchMemberProfile() {
    }
}
