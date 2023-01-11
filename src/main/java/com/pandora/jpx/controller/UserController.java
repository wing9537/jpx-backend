package com.pandora.jpx.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.core.model.BaseResponse;
import com.pandora.jpx.entity.User;
import com.pandora.jpx.entity.User.UserStatus;
import com.pandora.jpx.model.UserDto;
import com.pandora.jpx.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse registration(@Valid @RequestBody UserDto dto) {
        // validation
        User dbUser = userService.findByUsername(dto.getUsername());
        if (dbUser != null) {
            return BaseResponse.reject("username.duplicate");
        }
        // save
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setStatus(UserStatus.Active);
        userService.save(user);
        return BaseResponse.accept(user);
    }

}
