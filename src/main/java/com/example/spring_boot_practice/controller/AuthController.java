package com.example.spring_boot_practice.controller;

import com.example.spring_boot_practice.dto.AuthRequest;
import com.example.spring_boot_practice.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller responsible for handling authentication requests.
 * <p>
 * Provides login endpoint that authenticates users and returns a JWT token.
 */
@RestController
public class AuthController {

    /**
     * Service used to generate JWT tokens.
     */
    private final JwtService jwtService;

    /**
     * Spring Security authentication manager used to authenticate credentials.
     */
    private final AuthenticationManager authenticationManager;

    /**
     * Constructs an AuthController with required dependencies.
     *
     * @param authenticationManager the authentication manager
     * @param jwtService            the JWT service
     */
    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    /**
     * Authenticates a user and generates a JWT token.
     *
     * @param request the authentication request containing username and password
     * @return ResponseEntity containing the generated JWT token if successful
     */
    @PostMapping(value = "/auth/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        return ResponseEntity.ok(jwtService.generateToken(username));
    }
}