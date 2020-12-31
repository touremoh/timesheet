package com.o2xp.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String reference;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
