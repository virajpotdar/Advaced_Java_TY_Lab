package com.cache;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Cache {

    @Id
    private Long id;

    private String name;

    // REQUIRED by Hibernate
    public Cache() {
    }

    // Parameterized constructor
    public Cache(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}