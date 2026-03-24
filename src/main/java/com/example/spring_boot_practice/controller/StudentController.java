package com.example.spring_boot_practice.controller;

import com.example.spring_boot_practice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * REST controller providing student data.
 */
@RestController
public class StudentController {

    /**
     * Returns a sample list of students.
     *
     * @return list of students
     */
    @GetMapping(value = "/students")
    public List<Student> getStudents() {

        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(1, "Tha", "A");
        Student student2 = new Student(2, "Than", "AB");
        Student student3 = new Student(3, "Thanh", "ABC");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        return studentList;
    }
}
