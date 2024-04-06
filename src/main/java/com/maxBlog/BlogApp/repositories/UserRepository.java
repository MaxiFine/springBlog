package com.maxBlog.BlogApp.repositories;

import com.maxBlog.BlogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // how we query the user by a unique field of the user Entity
    Optional<User> findByEmail(String email);
}
