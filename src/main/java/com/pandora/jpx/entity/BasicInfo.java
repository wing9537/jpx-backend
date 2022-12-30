package com.pandora.jpx.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BasicInfo implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String deleted;

    @Column
    private Integer createUser;

    @Column
    private Timestamp createTime;

    @Column
    private Integer modifyUser;

    @Column
    private Timestamp modifyTime;

    @PrePersist
    protected void prePersist() {
        if (this.createTime == null) createTime = new Timestamp(0);
        if (this.modifyTime == null) modifyTime = new Timestamp(0);
    }

    @PreUpdate
    protected void preUpdate() {
        this.modifyTime = new Timestamp(0);
    }
}
