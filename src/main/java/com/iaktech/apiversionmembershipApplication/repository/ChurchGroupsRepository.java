package com.iaktech.apiversionmembershipApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iaktech.apiversionmembershipApplication.model.ChurchGroups;
import org.springframework.stereotype.Repository;

@Repository
public interface ChurchGroupsRepository extends JpaRepository<ChurchGroups, Long> {

}
