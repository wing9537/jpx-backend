package com.pandora.jpx.stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.pandora.core.stateless.BaseUserDetails;
import com.pandora.jpx.entity.User;
import com.pandora.jpx.service.UserService;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return new BaseUserDetails(user.getId(), user.getUsername(), user.getPassword(),
                    AuthorityUtils.createAuthorityList("ROLE_" + user.getRole()));
        }
        return null;
    }

}
