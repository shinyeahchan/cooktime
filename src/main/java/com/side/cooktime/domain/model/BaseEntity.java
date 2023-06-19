package com.side.cooktime.domain.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Embedded
    protected Timestamp timestamp;

    protected BaseEntity() {
        this.timestamp = new Timestamp();
    }
    protected BaseEntity(Long id){
        this.id = id;
        this.timestamp = new Timestamp();
    }

    protected void update() {

    }
}
