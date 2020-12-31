package com.o2xp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date startingDt;
    private Date endingDt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public boolean hasName() {
        return this.name != null && !this.name.isEmpty();
    }

    public boolean hasDescription() {
        return this.description != null && !this.description.isEmpty();
    }

    public boolean hasStartingDt() {
        return this.startingDt != null;
    }

    public boolean hasEndingDt() {
        return this.endingDt != null;
    }

    public boolean hasID() {
        return this.id != null;
    }

    public boolean hasContract() {
        return this.contract != null;
    }
}
