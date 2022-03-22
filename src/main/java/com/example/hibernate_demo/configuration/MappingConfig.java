package com.example.hibernate_demo.configuration;

import com.example.hibernate_demo.domain.Account;
import com.example.hibernate_demo.domain.User;
import com.example.hibernate_demo.dto.AccountDto;
import com.example.hibernate_demo.dto.UserDto;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(User.class, UserDto.class);

        modelMapper.createTypeMap(Account.class, AccountDto.class)
                .addMappings(mapper -> {
                    mapper
                        .map(src -> src.getUser().getId(), AccountDto::setUserId);
                    mapper
                        .map(src -> src.getUser().getUsername(), AccountDto::setUsername);
                });

        modelMapper.validate();

        return modelMapper;
    }
}
