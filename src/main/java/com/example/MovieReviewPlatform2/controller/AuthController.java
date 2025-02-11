package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.entity.RefreshToken;
import com.example.MovieReviewPlatform2.entity.User;
import com.example.MovieReviewPlatform2.repository.UserRepository;
import com.example.MovieReviewPlatform2.service.impl.RefreshTokenService;
import com.example.MovieReviewPlatform2.util.jwtUtil.JwtUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final RefreshTokenService refreshTokenService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            User user = userRepository.findByUsername(authRequest.getUsername())
                    .orElseThrow(() -> new NoSuchElementException("User not found: " + authRequest.getUsername()));

            String token = jwtUtil.generateToken(user.getUsername(), String.valueOf(user.getRole()));
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getUsername());

            return ResponseEntity.ok(new JwtResponse("Bearer " + token, refreshToken.getToken()));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest request) {
        Optional<RefreshToken> refreshToken = refreshTokenService.findByToken(request.getRefreshToken());

        if (refreshToken.isPresent() && refreshTokenService.isValid(refreshToken.get())) {
            User user = refreshToken.get().getUser();
            String token = jwtUtil.generateToken(user.getUsername(), String.valueOf(user.getRole()));
            return ResponseEntity.ok(new JwtResponse("Bearer " + token, request.getRefreshToken()));
        } else {
            return ResponseEntity.status(403).body("Invalid or expired refresh token");
        }
    }


    // DTO для запроса на логин
    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }

    // DTO для ответа (токен)
    @Data
    public static class JwtResponse {
        private final String token;
        private final String refreshToken;
    }
    // DTO для refresh
    @Data
    public class RefreshTokenRequest {
        private String refreshToken;
    }
}