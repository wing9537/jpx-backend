package com.pandora.jpx.repository;

import org.springframework.stereotype.Repository;

import com.pandora.core.repository.BaseRepository;
import com.pandora.jpx.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User> {

    User findByUsernameAndDeleted(String username, String deleted);

}
