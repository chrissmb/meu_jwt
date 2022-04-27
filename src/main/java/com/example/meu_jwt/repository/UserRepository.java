package com.example.meu_jwt.repository;

import com.example.meu_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> getUserByUsername(String username);
}
