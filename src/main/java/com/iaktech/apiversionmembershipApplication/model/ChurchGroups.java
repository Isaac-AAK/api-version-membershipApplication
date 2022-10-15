package com.iaktech.apiversionmembershipApplication.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ChurchGroups {

    @Id
    private Long groupId;

    private String groupName;

    @OneToMany(mappedBy = "churchGroups")
    @JsonManagedReference(value = "churchGroups")
    private List<ChurchMemberProfile> churchMemberProfile;

}
