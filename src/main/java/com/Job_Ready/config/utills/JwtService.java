package com.Job_Ready.config.utills;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtService {

    @Value("${jobready.jwt.secret}")
    private String jwtSecret;

    @Value("${jobready.jwt.expiration}")
    private long jwtExpiration;

    @Value("${jobready.jwt.refresh.expiration}")
    private long jwtRefreshExpiration;

    @Value("${jobready.jwt.audience}")
    private String audience;

    @Value("${jobready.jwt.issuer}")
    private String issuer;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(jwtSecret);
    }

    public String generateAccessToken(String subjectId, String username, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);
        return JWT.create()
                .withSubject(subjectId)
                .withAudience(audience)
                .withIssuedAt(now)
                .withClaim("username", username)
                .withIssuer(issuer)
                .withExpiresAt(expiryDate)
                .withClaim("role", role)
                .sign(getAlgorithm());
    }

    public String generateRefreshToken(String subjectId, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtRefreshExpiration);
        return JWT.create()
                .withSubject(subjectId)
                .withAudience(audience)
                .withIssuedAt(now)
                .withIssuer(issuer)
                .withExpiresAt(expiryDate)
                .withClaim("role", role)
                .sign(getAlgorithm());
    }

    public String getUserIdFromJWT(String token) {
        DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                .withIssuer(issuer)
                .build()
                .verify(token);
        return decodedJWT.getSubject();
    }

    public String getUsernameFromJWT(String token) {
        DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                .withIssuer(issuer)
                .build()
                .verify(token);
        return decodedJWT.getClaim("username").asString();
    }

    public String getRoleFromToken(String token) {
        DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                .withIssuer(issuer)
                .build()
                .verify(token);
        return decodedJWT.getClaim("role").asString();
    }

    public boolean validateToken(String authToken) {
        try {
            JWT.require(getAlgorithm())
                    .withIssuer(issuer)
                    .build()
                    .verify(authToken);
            return true;
        } catch (Exception ex) {
            log.error("JWT validation error: {}", ex.getMessage());
        }
        return false;
    }

    public String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    // Expose expirations for use by services (milliseconds)
    public long getJwtExpiration() {
        return jwtExpiration;
    }

    public long getJwtRefreshExpiration() {
        return jwtRefreshExpiration;
    }
}
