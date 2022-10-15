package com.iaktech.apiversionmembershipApplication.repository;

import com.iaktech.apiversionmembershipApplication.model.ChurchMemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<ChurchMemberProfile, Long> {

}
