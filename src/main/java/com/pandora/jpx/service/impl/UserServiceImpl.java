package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pandora.jpx.entity.User;
import com.pandora.jpx.repository.UserRepository;
import com.pandora.jpx.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsernameAndDeleted(username, "N");
    }

    @Override
    @Transactional
    public List<User> search(String username, String email, String mobile, String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}
