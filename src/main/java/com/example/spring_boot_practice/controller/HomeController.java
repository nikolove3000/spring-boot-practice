package com.example.spring_boot_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller responsible for basic application health checking.
 *
 * <p>Provides a simple endpoint to verify that the Spring Boot
 * application is running successfully.</p>
 */
@RestController
public class HomeController {

    /**
     * Returns a simple confirmation message indicating
     * that the application is running.
     *
     * @return a status message confirming server availability
     */
    @GetMapping(value = "/")
    public String printOut() {

        return "Spring Boot is running";
    }
}
