package com.pandora.jpx.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.core.model.BaseResponse;
import com.pandora.jpx.model.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public BaseResponse registration(@RequestBody UserDto dto) {
        return BaseResponse.accept(dto);
    }

}
