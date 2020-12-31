package com.o2xp.dto;

import com.o2xp.model.Contract;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Date startingDt;
    private Date endingDt;
    private ContractDTO contract;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
