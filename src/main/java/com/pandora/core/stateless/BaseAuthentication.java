package com.pandora.core.stateless;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseAuthentication extends UsernamePasswordAuthenticationToken {

    public BaseAuthentication(String username, String password) {
        super(username, password);
    }

    public BaseAuthentication(UserDetails userDetails, Object credentials) {
        super(userDetails, credentials, userDetails.getAuthorities());
    }

    public Integer getUserId() {
        return ((BaseUserDetails) getPrincipal()).getUserId();
    }

    public String getUserName() {
        return ((BaseUserDetails) getPrincipal()).getUsername();
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return ((BaseUserDetails) getPrincipal()).getAuthorities();
    }

}
