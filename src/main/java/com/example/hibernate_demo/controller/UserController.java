package com.example.hibernate_demo.controller;

import com.example.hibernate_demo.dto.UserDto;
import com.example.hibernate_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/username/{username}")
    public UserDto findByUsername(
            @PathVariable String username
    ) {
        UserDto dto = userService.findByUsername(username);
        return dto;
    }

    @GetMapping("/id/{id}")
    public UserDto findById(
            @PathVariable Long id
    ) {
        UserDto dto = userService.findById(id);
        return dto;
    }
}
