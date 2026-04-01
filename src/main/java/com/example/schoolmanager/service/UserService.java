package com.example.schoolmanager.service;

import com.example.schoolmanager.model.Role;
import com.example.schoolmanager.model.User;
import com.example.schoolmanager.respository.RoleRepository;
import com.example.schoolmanager.respository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public Page<User> search(String keyword, int page, int size) {
        String k = (keyword == null) ? "" : keyword.trim();
        Pageable pageable = PageRequest.of(page, size);
        if (k.isEmpty()) {
            return userRepo.findAll(pageable);
        }
        return userRepo.findByUsernameContainingIgnoreCase(k, pageable);
    }

    public User getById(UUID id) {
        return userRepo.findById(id).orElse(null);
    }

    public User create(User user) {
        if (user.getStatus() == null) {
            user.setStatus("ACTIVE");
        }
        return userRepo.save(user);
    }

    public User update(UUID id, User data) {
        User existing = getById(id);
        if (existing == null) return null;
        existing.setUsername(data.getUsername());
        if (data.getPassword() != null && !data.getPassword().isBlank()) {
            existing.setPassword(data.getPassword());
        }
        if (data.getStatus() != null) {
            existing.setStatus(data.getStatus());
        }
        return userRepo.save(existing);
    }

    public void delete(UUID id) {
        userRepo.deleteById(id);
    }

    public User toggleStatus(UUID id) {
        User user = getById(id);
        if (user == null) return null;
        user.setStatus("ACTIVE".equals(user.getStatus()) ? "INACTIVE" : "ACTIVE");
        return userRepo.save(user);
    }

    @Transactional
    public User assignRoles(UUID userId, List<UUID> roleIds) {
        User user = getById(userId);
        if (user == null) return null;
        Set<Role> roles = new HashSet<>(roleRepo.findAllById(roleIds));
        user.setRoles(roles);
        return userRepo.save(user);
    }
}
