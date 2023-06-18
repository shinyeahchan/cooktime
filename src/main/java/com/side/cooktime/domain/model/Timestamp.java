package com.side.cooktime.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class Timestamp {

    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column()
    private LocalDateTime updatedAt;

    protected Timestamp(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    protected Timestamp(LocalDateTime createdAt){
        this.createdAt = createdAt;
        this.updatedAt = LocalDateTime.now();
    }

    protected Timestamp update(){
        return new Timestamp(this.createdAt);
    }
}
