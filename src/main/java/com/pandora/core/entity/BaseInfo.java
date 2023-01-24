package com.pandora.core.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pandora.core.handler.BaseJsonEncodeHandler;
import com.pandora.core.stateless.BaseAuthentication;

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
    @JsonSerialize(using = BaseJsonEncodeHandler.class)
    private Integer id;

    @Column
    @JsonIgnore
    private String deleted;

    @Column
    @JsonIgnore
    private String createUser;

    @Column
    @JsonIgnore
    private Timestamp createTime;

    @Column
    @JsonIgnore
    private String modifyUser;

    @Column
    @JsonIgnore
    private Timestamp modifyTime;

    @PrePersist
    protected void prePersist() {
        createUser = getOperatingUser();
        modifyUser = getOperatingUser();
        createTime = new Timestamp(System.currentTimeMillis());
        modifyTime = new Timestamp(System.currentTimeMillis());
        deleted = "N";
    }

    @PreUpdate
    protected void preUpdate() {
        modifyUser = getOperatingUser();
        modifyTime = new Timestamp(System.currentTimeMillis());
    }

    protected String getOperatingUser() {
        BaseAuthentication authentication = (BaseAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? authentication.getUserName() : "SYSTEM";
    }

}
