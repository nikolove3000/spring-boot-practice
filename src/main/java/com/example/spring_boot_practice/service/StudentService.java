package com.example.spring_boot_practice.service;

import com.example.spring_boot_practice.model.Student;
import com.example.spring_boot_practice.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer responsible for handling business logic
 * related to {@link Student} entities.
 * <p>
 * Acts as an intermediary between controllers and the repository layer.
 */
@Service
public class StudentService {

    /**
     * Repository used for student data access operations.
     */
    private final StudentRepository studentRepository;

    /**
     * Constructs a StudentService with the required repository dependency.
     *
     * @param studentRepository the student repository
     */
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Retrieves students with pagination and sorting support.
     *
     * @param page   the page number (zero-based)
     * @param size   the number of records per page
     * @param sortBy the field used for sorting
     * @return a paginated list of students
     */
    @Transactional
    public Page<Student> getStudents(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studentRepository.findAll(pageable);
    }

    /**
     * Finds students by their name.
     *
     * @param name the student's name
     * @return list of students matching the given name
     */
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    /**
     * Finds a student by email.
     *
     * @param email the student's email address
     * @return an Optional containing the student if found
     */
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    /**
     * Saves or updates a student entity.
     *
     * @param student the student to save
     * @return the persisted student entity
     */
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}