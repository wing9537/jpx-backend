package com.pandora.jpx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pandora.jpx.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsernameAndDeleted(String username, String deleted);

}
