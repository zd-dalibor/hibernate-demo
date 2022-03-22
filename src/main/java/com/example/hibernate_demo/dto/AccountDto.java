package com.example.hibernate_demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Date createdDate;
    private Date updatedDate;
    private Long userId;
}
