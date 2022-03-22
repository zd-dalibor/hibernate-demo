package com.example.hibernate_demo.dto;


import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String username;
    private Date createdDate;
    private Date updatedDate;
}
