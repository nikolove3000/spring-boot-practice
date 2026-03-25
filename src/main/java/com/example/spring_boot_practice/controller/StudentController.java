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
 * REST controller responsible for handling HTTP requests
 * related to {@link Student} resources.
 * <p>
 * Provides endpoints for retrieving, searching, and creating students.
 */
@RestController
public class StudentController {

    /**
     * Service layer used to perform student operations.
     */
    private final StudentService studentService;

    /**
     * Constructs a StudentController with the required service dependency.
     *
     * @param studentService the student service
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Retrieves a paginated and sorted list of students.
     *
     * @param page   the page number (zero-based)
     * @param size   the number of records per page
     * @param sortBy the field used for sorting
     * @return ResponseEntity containing a page of students
     */
    @GetMapping(value = "/students")
    public ResponseEntity<Page<Student>> getAllStudent(@RequestParam int page,
                                                       @RequestParam int size,
                                                       @RequestParam String sortBy) {

        return ResponseEntity.ok(studentService.getStudents(page, size, sortBy));
    }

    /**
     * Searches students by name.
     *
     * @param name the student name to search for
     * @return list of students matching the given name
     */
    @GetMapping(value = "/students/search")
    public List<Student> findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    /**
     * Searches for a student by email.
     *
     * @param email the student's email address
     * @return ResponseEntity containing the student if found,
     *         otherwise HTTP 404 Not Found
     */
    @GetMapping(value = "/students/search/email")
    public ResponseEntity<Student> findByEmail(@RequestParam String email) {

        Optional<Student> student = studentService.findByEmail(email);
        return student.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new student.
     *
     * @param student the student data received from request body
     * @return ResponseEntity containing the created student
     *         with HTTP status 201 (Created)
     */
    @PostMapping(value = "student")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.save(student));
    }
}