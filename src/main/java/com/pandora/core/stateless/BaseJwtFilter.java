package com.pandora.core.stateless;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pandora.core.handler.BaseJwtHandler;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BaseJwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BaseJwtHandler baseJwtHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;
        // JWT Token is in the form "Bearer token"
        // Remove Bearer word and get only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = baseJwtHandler.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                log.info("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                log.info("JWT Token has expired");
            }
        } else {
            log.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // if token is valid configure Spring Security to manually set authentication
            if (baseJwtHandler.validateToken(jwtToken, userDetails)) {
                BaseAuthentication baseAuthentication = new BaseAuthentication(userDetails, null);
                baseAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context,
                // we specify that the current user is authenticated.
                // So it passes the Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(baseAuthentication);
                log.debug("Authorized user: {}", userDetails);
            } else {
                log.debug("Unauthorized user: {}", userDetails);
            }
        } else {
            log.warn("Skip JWT authentication");
        }
        chain.doFilter(request, response);
    }

}
