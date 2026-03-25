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
    public Page<Student> getStudents(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studentRepository.findAll(pageable);
    }

    public List<Student> findByName(String name) {

        return studentRepository.findByName(name);
    }

    public Optional<Student> findByEmail(String email) {


        return studentRepository.findByEmail(email);
    }

    public Student save(Student student) {

        return studentRepository.save(student);
    }

}