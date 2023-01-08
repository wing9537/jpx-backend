package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.User;

public interface UserService {

    User findById(Integer id);

    List<User> search(String username, String email, String mobile, String status);

    User save(User manga);

}
