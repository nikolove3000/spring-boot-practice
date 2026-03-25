package com.example.spring_boot_practice.repository;

import com.example.spring_boot_practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    
}
