package com.example.schoolmanager.controller;

import com.example.schoolmanager.respository.PermissionRepository;
import com.example.schoolmanager.respository.RoleRepository;
import com.example.schoolmanager.respository.StudentRepository;
import com.example.schoolmanager.respository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

    private final StudentRepository studentRepo;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PermissionRepository permissionRepo;

    public DashboardController(StudentRepository studentRepo, UserRepository userRepo, 
                               RoleRepository roleRepo, PermissionRepository permissionRepo) {
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.permissionRepo = permissionRepo;
    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("students", studentRepo.count());
        stats.put("users", userRepo.count());
        stats.put("roles", roleRepo.count());
        stats.put("permissions", permissionRepo.count());
        return stats;
    }
}
