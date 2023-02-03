package com.pandora.jpx.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pandora.core.properties.BaseProperties;

@Configuration
public class SecurityConfig {

    @Autowired
    private BaseProperties baseProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        String encoderName = baseProperties.getAppName();
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
        encoderMap.put(encoderName, new Argon2PasswordEncoder(16, 32, 1, 1 << 16, 1));
        return new DelegatingPasswordEncoder(encoderName, encoderMap);
    }

}
