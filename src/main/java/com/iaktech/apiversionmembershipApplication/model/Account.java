package com.iaktech.apiversionmembershipApplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String accountName;

    private String accountAmount;

    @OneToMany(mappedBy = "memberAccount")
    @JsonManagedReference(value = "memberAccount")
    private List<ChurchMemberProfile> churchMemberProfile;

}
