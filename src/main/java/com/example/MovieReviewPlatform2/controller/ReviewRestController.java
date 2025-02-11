package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.MovieDto;
import com.example.MovieReviewPlatform2.dto.ReviewDto;
import com.example.MovieReviewPlatform2.service.MovieService;
import com.example.MovieReviewPlatform2.service.ReviewService;
import com.example.MovieReviewPlatform2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;
    private final MovieService movieService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getReviews(@RequestParam("movieId") Integer movieId) {
        if (movieId == null) {
            return ResponseEntity.badRequest().body("Идентификатор фильма не указан.");
        }

        List<ReviewDto> reviews = reviewService.findAllByMovieId(movieId);
        Optional<MovieDto> movieOptional = movieService.findById(movieId);

        if (movieOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Фильм с указанным ID не найден.");
        }

        MovieDto movie = movieOptional.get();

        Map<String, Object> response = new HashMap<>();
        response.put("movieName", movie.getName());
        response.put("poster", movie.getPoster_url());
        response.put("comments", reviews);
        response.put("movieId", movieId);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> postReview(
            @RequestParam("movie_id") Integer movieId,
            @RequestParam("rating") Integer rating,
            @RequestParam("comments") String comments,
            @AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Пользователь не авторизован.");
        }

        String username = userDetails.getUsername();
        Integer userId = userService.getUserByUsername(username)
                .map(user -> user.getId())
                .orElse(null);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ошибка авторизации.");
        }

        reviewService.addReview(userId, movieId, rating, comments);
        return ResponseEntity.ok("Отзыв добавлен успешно.");
    }
}
