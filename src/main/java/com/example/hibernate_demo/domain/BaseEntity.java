package com.example.hibernate_demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {
    @Column
    @Temporal(TemporalType.TIMESTAMP)

    private Date updatedDate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        updatedDate = now;
        createdDate = now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(updatedDate, that.updatedDate) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
