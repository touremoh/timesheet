package com.o2xp.dto;


import lombok.Data;

import java.sql.Date;

@Data
public class ContractDTO {
    private Long id;
    private Date startingDt;
    private Date endingDt;
    private CustomerDTO customer;
    private UserDTO userProfile;
}
