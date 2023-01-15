package com.pandora.core.stateless;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseAuthentication extends UsernamePasswordAuthenticationToken {

    public BaseAuthentication(String username, String password) {
        super(username, password);
    }

    public BaseAuthentication(UserDetails userDetails, Object credentials) {
        super(userDetails, credentials, userDetails.getAuthorities());
    }

}
