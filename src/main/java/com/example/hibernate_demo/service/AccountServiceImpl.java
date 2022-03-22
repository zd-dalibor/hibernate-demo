package com.example.hibernate_demo.service;

import com.example.hibernate_demo.domain.Account;
import com.example.hibernate_demo.dto.AccountDto;
import com.example.hibernate_demo.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto findByUsername(String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        if (account.isEmpty()) return null;

        AccountDto dto = mapper.map(account.get(), AccountDto.class);
        return dto;
    }

    @Override
    public AccountDto findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) return null;

        AccountDto dto = mapper.map(account.get(), AccountDto.class);
        return dto;
    }

}
