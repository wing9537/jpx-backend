package com.pandora.jpx.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.micrometer.common.util.StringUtils;

@Component
public class PasswordHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return StringUtils.isNotEmpty(encodedPassword) && passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
