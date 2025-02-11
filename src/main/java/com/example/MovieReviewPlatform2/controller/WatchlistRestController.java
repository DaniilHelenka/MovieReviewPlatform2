package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.entity.User;
import com.example.MovieReviewPlatform2.service.MovieService;
import com.example.MovieReviewPlatform2.service.UserService;
import com.example.MovieReviewPlatform2.service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/watchlist")
@RequiredArgsConstructor
public class WatchlistRestController {

    private final WatchlistService watchlistService;
    private final UserService userService;
    private final MovieService movieService;

    /**
     * Добавить фильм в список (смотреть/просмотренные)
     */
    @PostMapping("/add")
    public ResponseEntity<?> addToWatchlist(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("movie_id") Integer movieId,
            @RequestParam("list_type") String listType) {

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not authenticated");
        }

        Optional<User> user = userService.getUserByUsername(userDetails.getUsername());
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        if (listType == null || listType.isBlank()) {
            return ResponseEntity.badRequest().body("List type is required");
        }

        watchlistService.addMovieToWatchlist(user.get().getId(), movieId, listType);
        return ResponseEntity.ok("Movie added to watchlist");
    }

    /**
     * Удалить фильм из списка
     */
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFromWatchlist(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("movie_id") Integer movieId,
            @RequestParam("list_type") String listType) {

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Please log in.");
        }

        Optional<User> user = userService.getUserByUsername(userDetails.getUsername());
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        boolean isDeleted = watchlistService.removeMovieFromWatchlist(user.get().getId(), movieId, listType);
        if (isDeleted) {
            return ResponseEntity.ok("Movie removed from watchlist.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found in the watchlist.");
        }
    }

    /**
     * Пометить фильм как просмотренный
     */
    @PostMapping("/markWatched")
    public ResponseEntity<?> markAsWatched(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("movie_id") Integer movieId) {

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Please log in.");
        }

        Optional<User> user = userService.getUserByUsername(userDetails.getUsername());
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        movieService.moveToWatched(movieId);
        return ResponseEntity.ok("Movie marked as watched.");
    }
}

