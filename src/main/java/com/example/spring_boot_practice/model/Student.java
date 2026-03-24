package com.example.spring_boot_practice.model;

/**
 * Represents a student entity used in REST responses.
 * Contains basic student information such as id, name, and email.
 */
public class Student {

    private long id;
    private String name;
    private String email;

    /**
     * Constructs a Student with all required attributes.
     *
     * @param id the unique identifier of the student
     * @param name the student's name
     * @param email the student's email address
     */
    public Student(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Returns the student id.
     *
     * @return student id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the student id.
     *
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the student name.
     *
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the student email.
     *
     * @return student email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}