package com.example.schoolmanager.respository;

import com.example.schoolmanager.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Page<User> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
