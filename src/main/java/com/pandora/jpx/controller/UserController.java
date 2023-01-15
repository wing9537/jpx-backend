package com.pandora.jpx.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.core.handler.BaseJwtHandler;
import com.pandora.core.model.BaseResponse;
import com.pandora.jpx.entity.User;
import com.pandora.jpx.entity.User.UserRole;
import com.pandora.jpx.entity.User.UserStatus;
import com.pandora.jpx.form.LoginForm;
import com.pandora.jpx.form.RegisterForm;
import com.pandora.jpx.handler.PasswordHandler;
import com.pandora.jpx.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordHandler passwordHandler;

    @Autowired
    private BaseJwtHandler baseJwtHandler;

    @GetMapping("/testing")
    public BaseResponse testing() {
        User user = userService.findByUsername("wing9537");
        user.setPassword(passwordHandler.encode("12345678"));
        userService.save(user);
        return BaseResponse.ok;
    }

    @PostMapping("/register")
    public BaseResponse registration(@Valid @RequestBody RegisterForm form) {
        // validation
        final User dbUser = userService.findByUsername(form.getUsername());
        if (dbUser != null) {
            return BaseResponse.reject("username.duplicate");
        }
        // save
        User user = new User();
        BeanUtils.copyProperties(form, user);
        user.setRole(UserRole.User);
        user.setStatus(UserStatus.Active);
        userService.save(user);

        return BaseResponse.accept(user);
    }

    @PostMapping("/login")
    public BaseResponse login(@Valid @RequestBody LoginForm form) {
        final User user = userService.findByUsername(form.getUsername());
        if (user != null && passwordHandler.matches(form.getPassword(), user.getPassword())) {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(form.getUsername());
            final String token = baseJwtHandler.generateToken(userDetails);
            return BaseResponse.accept(token);
        } else {
            return BaseResponse.reject("user.incorrect");
        }
    }

}
