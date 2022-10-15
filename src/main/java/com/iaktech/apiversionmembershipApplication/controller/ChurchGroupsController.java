package com.iaktech.apiversionmembershipApplication.controller;

import java.util.List;

import com.iaktech.apiversionmembershipApplication.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.iaktech.apiversionmembershipApplication.model.ChurchGroups;
import com.iaktech.apiversionmembershipApplication.repository.ChurchGroupsRepository;

@RestController
@RequestMapping("api/v1/churchgroups")
public class ChurchGroupsController {

    @Autowired
    private ChurchGroupsRepository churchGroupsRepository;

    @GetMapping
    public List<ChurchGroups> listGroups() {
        return churchGroupsRepository.findAll();
    }

    @PostMapping(consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public void addAccount(@RequestBody ChurchGroups churchGroups) {
        churchGroupsRepository.save(churchGroups);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        churchGroupsRepository.deleteById(id);
    }

}
