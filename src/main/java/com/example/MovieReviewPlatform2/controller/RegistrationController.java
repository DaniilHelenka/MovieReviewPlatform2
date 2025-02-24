package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.CreateUserDto;
import com.example.MovieReviewPlatform2.entity.Role;
import com.example.MovieReviewPlatform2.exception.ValidationException;
import com.example.MovieReviewPlatform2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.Part;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(List.of(Role.values()));
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody CreateUserDto userDto) {
        try {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
           userService.create(userDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (ValidationException exception) {
            return ResponseEntity.badRequest().body("Validation failed: " + exception.getErrors());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing the image: " + e.getMessage());
        }
    }
}
