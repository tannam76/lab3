package com.example.schoolmanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.schoolmanager.model.Student;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    Page<Student> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String name,
            String email,
            Pageable pageable
    );
}