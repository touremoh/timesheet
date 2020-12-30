package com.o2xp.dto;


import com.o2xp.model.Customer;
import com.o2xp.model.UserProfile;
import lombok.Data;

import java.sql.Date;

@Data
public class ContractDTO {
    private Long id;
    private Date startingDt;
    private Date endingDt;
    private Customer customer;
    private UserProfile userProfile;
}
