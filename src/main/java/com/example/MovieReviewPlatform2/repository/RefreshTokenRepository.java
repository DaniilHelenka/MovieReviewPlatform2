package com.example.MovieReviewPlatform2.repository;

import com.example.MovieReviewPlatform2.entity.RefreshToken;
import com.example.MovieReviewPlatform2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUser(User user);
}