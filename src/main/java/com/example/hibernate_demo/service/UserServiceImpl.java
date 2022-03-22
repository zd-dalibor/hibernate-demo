package com.example.hibernate_demo.service;

import com.example.hibernate_demo.domain.User;
import com.example.hibernate_demo.dto.UserDto;
import com.example.hibernate_demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) return null;

        UserDto dto = mapper.map(user.get(), UserDto.class);
        return dto;
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return null;

        UserDto dto = mapper.map(user.get(), UserDto.class);
        return dto;
    }
}
