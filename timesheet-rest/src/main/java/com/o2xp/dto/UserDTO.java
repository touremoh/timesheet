package com.o2xp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
