package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.User;

public interface UserService {

    public User findById(Integer id);

    public User findByUsername(String username);

    public List<User> search(String username, String email, String mobile, String status);

    public User save(User user);

    public void deleteById(Integer id);

}
