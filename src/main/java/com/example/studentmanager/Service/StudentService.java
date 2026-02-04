// StudentService.java
package com.example.studentmanager.Service;

import com.example.studentmanager.Entity.Student;
import com.example.studentmanager.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() { return repository.findAll(); }
    public Student getById(int id) { return repository.findById(id).orElse(null); }
    public Student save(Student s) { return repository.save(s); }
    public void delete(int id) { repository.deleteById(id); }
    public List<Student> search(String keyword) { return repository.findByNameContainingIgnoreCase(keyword); }
}