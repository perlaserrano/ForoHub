package com.alura.challenge.forohub.forochallenge.repository;


import com.alura.challenge.forohub.forochallenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
