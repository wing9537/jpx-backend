package com.pandora.core.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pandora.core.stateless.BaseUserDetails;

public abstract class BaseController {

    protected BaseUserDetails getAuthority() {
        BaseUserDetails userDetail = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken) && authentication != null) {
            userDetail = (BaseUserDetails) authentication.getPrincipal();
        }
        return userDetail;
    }

    protected Integer getUserId() {
        BaseUserDetails userDetail = getAuthority();
        return userDetail != null ? userDetail.getUserId() : null;
    }

}