package com.pandora.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pandora.core.stateless.BaseAuthEntryPoint;
import com.pandora.core.stateless.BaseJwtFilter;

@Configuration
public class BaseSecurityConfig {

    @Autowired
    private BaseAuthEntryPoint baseAuthEntryPoint;

    @Autowired
    private BaseJwtFilter baseJwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.anonymous().disable();
        http.formLogin().disable();
        http.cors();
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeHttpRequests().requestMatchers("/user/profile").authenticated()
                .anyRequest().permitAll();
        http.exceptionHandling().authenticationEntryPoint(baseAuthEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(baseJwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
