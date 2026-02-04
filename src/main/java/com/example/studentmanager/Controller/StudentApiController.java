// StudentApiController.java
package com.example.studentmanager.Controller;

import com.example.studentmanager.Entity.Student;
import com.example.studentmanager.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentService service;

    // Yêu cầu 5: Lấy danh sách - Get All
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // Yêu cầu 4: Lấy sinh viên theo ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getById(id);
    }

    // Yêu cầu 3: Tìm kiếm sinh viên theo tên
    @GetMapping("/search")
    public List<Student> search(@RequestParam String keyword) {
        return service.search(keyword);
    }

    // Yêu cầu 1: Thêm mới sinh viên
    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.save(student);
    }

    // Yêu cầu 6: Cập nhật sinh viên
    @PostMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        return service.save(student);
    }

    // Yêu cầu 2: Xóa sinh viên
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Xóa thành công sinh viên ID: " + id;
    }
}