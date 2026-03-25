package com.example.spring_boot_practice.repository;

import com.example.spring_boot_practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    @Query("select s from  Student s where s.email = :email")
    Optional<Student> findByEmail(@Param("email") String email);
}
