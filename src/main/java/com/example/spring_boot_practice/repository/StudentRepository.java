package com.example.spring_boot_practice.repository;

import com.example.spring_boot_practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Student} entities.
 * <p>
 * Provides standard CRUD operations through {@link JpaRepository}
 * and custom query methods for searching students.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Finds students by their name.
     *
     * @param name the name of the student
     * @return list of students matching the given name
     */
    List<Student> findByName(String name);

    /**
     * Finds a student by email address using a custom JPQL query.
     *
     * @param email the student's email address
     * @return an Optional containing the student if found, otherwise empty
     */
    @Query("select s from Student s where s.email = :email")
    Optional<Student> findByEmail(@Param("email") String email);
}