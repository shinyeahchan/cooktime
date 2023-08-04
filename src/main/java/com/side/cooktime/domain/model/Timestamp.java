package com.side.cooktime.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Embeddable
public class Timestamp {

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    public Timestamp() {
        this(LocalDateTime.now(), LocalDateTime.now());
    }

    public Timestamp(LocalDateTime createdAt) {
        this(createdAt, LocalDateTime.now());
    }

    public Timestamp(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = null;
    }

    public Timestamp(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Timestamp update() {
        return new Timestamp(this.createdAt);
    }

    public Timestamp delete() {
        return new Timestamp(this.createdAt, LocalDateTime.now(), LocalDateTime.now());
    }
}
