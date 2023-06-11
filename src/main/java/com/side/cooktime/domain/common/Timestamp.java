package com.side.cooktime.domain.common;

import java.time.LocalDateTime;

public class Timestamp {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Timestamp(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Timestamp(LocalDateTime createdAt){
        this.createdAt = createdAt;
        this.updatedAt = LocalDateTime.now();
    }

    public Timestamp update(){
        return new Timestamp(this.createdAt);
    }
}
