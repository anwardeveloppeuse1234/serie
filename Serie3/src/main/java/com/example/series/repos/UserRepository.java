package com.example.series.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.series.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}