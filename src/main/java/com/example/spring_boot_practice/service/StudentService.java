package com.example.spring_boot_practice.service;

import com.example.spring_boot_practice.model.Student;
import com.example.spring_boot_practice.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Returns a sample list of students.
     *
     * @return list of students
     */
    @Transactional
    public List<Student> getStudents() {

        return studentRepository.findAll();
    }
}
