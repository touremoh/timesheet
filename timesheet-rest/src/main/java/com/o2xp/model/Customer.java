package com.o2xp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String reference;
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

    public boolean hasReference() {
        return this.reference != null && !this.name.isEmpty();
    }
}
