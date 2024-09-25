package com.leucine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leucine.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
