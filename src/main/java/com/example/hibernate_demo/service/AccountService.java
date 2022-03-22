package com.example.hibernate_demo.service;

import com.example.hibernate_demo.dto.AccountDto;

public interface AccountService {
    AccountDto findByUsername(String username);
    AccountDto findById(Long id);

}
