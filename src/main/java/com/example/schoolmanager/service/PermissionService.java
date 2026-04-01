package com.example.schoolmanager.service;

import com.example.schoolmanager.model.Permission;
import com.example.schoolmanager.respository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionService {

    private final PermissionRepository repo;

    public PermissionService(PermissionRepository repo) {
        this.repo = repo;
    }

    public List<Permission> getAll() {
        return repo.findAll();
    }

    public Permission getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public List<Permission> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return repo.findAll();
        }
        String k = keyword.trim();
        return repo.findByCodeContainingIgnoreCaseOrDescriptionContainingIgnoreCase(k, k);
    }

    public Permission create(Permission permission) {
        return repo.save(permission);
    }

    public Permission update(UUID id, Permission data) {
        Permission existing = getById(id);
        if (existing == null) return null;
        existing.setCode(data.getCode());
        existing.setDescription(data.getDescription());
        return repo.save(existing);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
