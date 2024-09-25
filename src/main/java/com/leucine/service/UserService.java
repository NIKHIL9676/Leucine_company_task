package com.leucine.service;

import com.leucine.entity.User;
import com.leucine.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
