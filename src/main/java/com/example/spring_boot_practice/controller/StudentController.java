package com.example.spring_boot_practice.controller;

import com.example.spring_boot_practice.model.Student;
import com.example.spring_boot_practice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller providing student data.
 */
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public ResponseEntity<Page<Student>> getAllStudent(@RequestParam int page,
                                                       @RequestParam int size,
                                                       @RequestParam String sortBy) {

        return ResponseEntity.ok(studentService.getStudents(page, size, sortBy));
    }

    @GetMapping(value = "/students/search")
    public List<Student> findByName(@RequestParam String name) {

        return studentService.findByName(name);
    }
    @GetMapping(value = "/students/search/email")
    public ResponseEntity<Student> findByEmail(@RequestParam String email) {

        Optional<Student> student = studentService.findByEmail(email);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "student")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

}
