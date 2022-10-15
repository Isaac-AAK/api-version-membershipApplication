package com.iaktech.apiversionmembershipApplication.controller;

import com.iaktech.apiversionmembershipApplication.model.ChurchMemberProfile;
import com.iaktech.apiversionmembershipApplication.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<ChurchMemberProfile> memberList() {
        return memberRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addMember(@RequestBody ChurchMemberProfile member) {
        memberRepository.save(member);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ChurchMemberProfile update(@PathVariable Long id, @RequestBody ChurchMemberProfile member) {
        return memberRepository.saveAndFlush(member);
    }

    @GetMapping("/{id}")
    public Optional<ChurchMemberProfile> findById(@PathVariable Long id) {
        return memberRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }

}
