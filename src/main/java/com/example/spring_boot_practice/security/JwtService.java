package com.example.spring_boot_practice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Service for creating JSON Web Tokens (JWT) for authentication.
 * <p>
 * Provides functionality to generate JWTs with expiration and
 * HMAC-SHA key signing.
 */
@Service
public class JwtService {

    /**
     * Base64-encoded secret key used for signing JWTs.
     */
    private static final String SECRET_KEY = "bXktc3VwZXItc2VjcmV0LWtleS1mb3Itand0LXNpZ25pbmctMjAyNA==";

    /**
     * Generates a JWT token for a given username.
     *
     * @param username the subject of the token
     * @return a signed JWT as a String
     */
    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSignKey())
                .compact();
    }

    /**
     * Decodes the base64 secret and returns a {@link SecretKey} for signing JWTs.
     *
     * @return the secret key for HMAC-SHA signing
     */
    private SecretKey getSignKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extracts the username (subject) from a given JWT token.
     *
     * @param token the JWT token string
     * @return the username contained in the token
     */
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    /**
     * Checks whether a given JWT token is valid for a specific username.
     *
     * @param token    the JWT token string
     * @param username the username to validate against
     * @return true if the token's subject matches the username; false otherwise
     */
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}