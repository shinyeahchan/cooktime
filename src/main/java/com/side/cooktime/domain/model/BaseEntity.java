package com.side.cooktime.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@EntityListeners(TimestampListener.class)
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

    protected BaseEntity(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.timestamp = new Timestamp(createdAt, updatedAt);
    }

    protected void create(){
        timestamp = new Timestamp();
    }
    protected void update() {
        timestamp = timestamp.update();
    }
}
