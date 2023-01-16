package com.pandora.core.stateless;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUserDetails extends User {

    private Integer userId;

    public BaseUserDetails(Integer userId, String username, String password, List<GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.setUserId(userId);
    }

}
