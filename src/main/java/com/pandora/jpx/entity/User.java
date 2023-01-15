package com.pandora.jpx.entity;

import com.pandora.core.entity.BaseInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_user")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends BaseInfo {

    public enum UserRole {
        User, Admin
    };

    public enum UserStatus {
        Active, Inactive, Freeze, Lock
    };

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String mobile;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    private int loginFailedCount;

}
