package com.example.schoolmanager.controller;

import com.example.schoolmanager.model.Role;
import com.example.schoolmanager.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Role> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public Page<Role> search(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.search(keyword, page, size);
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return service.create(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable UUID id, @RequestBody Role role) {
        return service.update(id, role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/{id}/permissions")
    public Role assignPermissions(@PathVariable UUID id, @RequestBody List<UUID> permissionIds) {
        return service.assignPermissions(id, permissionIds);
    }
}
