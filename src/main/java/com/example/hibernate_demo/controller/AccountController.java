package com.example.hibernate_demo.controller;

import com.example.hibernate_demo.dto.AccountDto;
import com.example.hibernate_demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/username/{username}")
    public AccountDto findByUsername(
            @PathVariable String username
    ) {
        AccountDto dto = accountService.findByUsername(username);
        return dto;
    }

    @GetMapping("/id/{id}")
    public AccountDto findById(
            @PathVariable Long id
    ) {
        AccountDto dto = accountService.findById(id);
        return dto;
    }
}
