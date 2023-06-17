package com.side.cooktime.domain.model;

public abstract class BaseEntity {

    protected Timestamp timestamp;

    protected BaseEntity() {
        this.timestamp = new Timestamp();
    }

    protected void update(){

    }
}
