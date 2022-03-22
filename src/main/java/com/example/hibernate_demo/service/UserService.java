package com.example.hibernate_demo.service;

import com.example.hibernate_demo.dto.UserDto;


public interface UserService {
    UserDto findByUsername(String username);
    UserDto findById(Long id);
}
