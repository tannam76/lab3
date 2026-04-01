package com.example.schoolmanager.service;

import com.example.schoolmanager.model.Permission;
import com.example.schoolmanager.model.Role;
import com.example.schoolmanager.respository.PermissionRepository;
import com.example.schoolmanager.respository.RoleRepository;
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
public class RoleService {

    private final RoleRepository roleRepo;
    private final PermissionRepository permissionRepo;

    public RoleService(RoleRepository roleRepo, PermissionRepository permissionRepo) {
        this.roleRepo = roleRepo;
        this.permissionRepo = permissionRepo;
    }

    public Page<Role> search(String keyword, int page, int size) {
        String k = (keyword == null) ? "" : keyword.trim();
        Pageable pageable = PageRequest.of(page, size);
        if (k.isEmpty()) {
            return roleRepo.findAll(pageable);
        }
        return roleRepo.findByCodeContainingIgnoreCaseOrNameContainingIgnoreCase(k, k, pageable);
    }

    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    public Role getById(UUID id) {
        return roleRepo.findById(id).orElse(null);
    }

    public Role create(Role role) {
        return roleRepo.save(role);
    }

    public Role update(UUID id, Role data) {
        Role existing = getById(id);
        if (existing == null) return null;
        existing.setCode(data.getCode());
        existing.setName(data.getName());
        return roleRepo.save(existing);
    }

    public void delete(UUID id) {
        roleRepo.deleteById(id);
    }

    @Transactional
    public Role assignPermissions(UUID roleId, List<UUID> permissionIds) {
        Role role = getById(roleId);
        if (role == null) return null;
        Set<Permission> permissions = new HashSet<>(permissionRepo.findAllById(permissionIds));
        role.setPermissions(permissions);
        return roleRepo.save(role);
    }
}
