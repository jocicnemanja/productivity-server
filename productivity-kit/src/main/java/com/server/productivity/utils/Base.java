package com.server.productivity.utils;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Base {

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private Instant createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private Instant modifiedDate;

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Instant setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
        return createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public Instant setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
        return modifiedDate;
    }

}
