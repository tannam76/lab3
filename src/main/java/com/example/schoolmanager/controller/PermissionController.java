package com.example.schoolmanager.controller;

import com.example.schoolmanager.model.Permission;
import com.example.schoolmanager.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/permissions")
@CrossOrigin
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Permission> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Permission> search(@RequestParam(required = false) String keyword) {
        return service.search(keyword);
    }

    @GetMapping("/{id}")
    public Permission getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Permission create(@RequestBody Permission permission) {
        return service.create(permission);
    }

    @PutMapping("/{id}")
    public Permission update(@PathVariable UUID id, @RequestBody Permission permission) {
        return service.update(id, permission);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
