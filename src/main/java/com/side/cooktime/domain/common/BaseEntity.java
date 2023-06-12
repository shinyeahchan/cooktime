package com.side.cooktime.domain.common;

import java.sql.Time;

public abstract class BaseEntity {

    protected Timestamp timestamp;

    public BaseEntity() {
        this.timestamp = new Timestamp();
    }
}
