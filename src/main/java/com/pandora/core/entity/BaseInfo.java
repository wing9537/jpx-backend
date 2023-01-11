package com.pandora.core.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public abstract class BaseInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column
    @JsonIgnore
    private String deleted;

    @Column
    @JsonIgnore
    private Integer createUser;

    @Column
    @JsonIgnore
    private Timestamp createTime;

    @Column
    @JsonIgnore
    private Integer modifyUser;

    @Column
    @JsonIgnore
    private Timestamp modifyTime;

    @PrePersist
    protected void prePersist() {
        createUser = 0; // TODO: get session user
        modifyUser = 0; // TODO: get session user
        createTime = new Timestamp(System.currentTimeMillis());
        modifyTime = new Timestamp(System.currentTimeMillis());
        deleted = "N";
    }

    @PreUpdate
    protected void preUpdate() {
        modifyUser = 0; // TODO: get session user
        modifyTime = new Timestamp(System.currentTimeMillis());
    }

}
