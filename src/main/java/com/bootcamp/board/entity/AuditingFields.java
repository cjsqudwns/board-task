package com.bootcamp.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class AuditingFields {
    @CreatedDate
    protected LocalDateTime createdDate;

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 20)
    protected String createdBy;

    @LastModifiedDate
    protected LocalDateTime modifiedDate;

    @LastModifiedBy
    @Column(nullable = false, updatable = false, length = 20)
    protected String modifiedBy;
}
