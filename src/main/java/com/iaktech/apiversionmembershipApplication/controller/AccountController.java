package com.iaktech.apiversionmembershipApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iaktech.apiversionmembershipApplication.model.Account;
import com.iaktech.apiversionmembershipApplication.repository.AccountRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "api/v1/accounts" )
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Account accoutUpdate(@PathVariable Long id, @RequestBody Account account) {
        return accountRepository.saveAndFlush(account);

    }

    @PostMapping(consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public void addAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }

    @RequestMapping(value = "/{id}")
    public Optional<Account> findAccountById(@PathVariable Long id) {
        return accountRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }

}
