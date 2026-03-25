package com.example.spring_boot_practice.controller;

import com.example.spring_boot_practice.model.Student;
import com.example.spring_boot_practice.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Student> getAllStudent() {

        return studentService.getStudents();
    }
}
