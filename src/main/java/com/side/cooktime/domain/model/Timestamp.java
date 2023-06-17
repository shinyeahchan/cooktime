package com.side.cooktime.domain.model;

import java.time.LocalDateTime;

public class Timestamp {

    private LocalDateTime createdAt;
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
