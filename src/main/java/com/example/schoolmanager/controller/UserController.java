package com.example.schoolmanager.controller;

import com.example.schoolmanager.model.User;
import com.example.schoolmanager.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public Page<User> search(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.search(keyword, page, size);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable UUID id, @RequestBody User user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/{id}/status")
    public User toggleStatus(@PathVariable UUID id) {
        return service.toggleStatus(id);
    }

    @PutMapping("/{id}/roles")
    public User assignRoles(@PathVariable UUID id, @RequestBody List<UUID> roleIds) {
        return service.assignRoles(id, roleIds);
    }
}
