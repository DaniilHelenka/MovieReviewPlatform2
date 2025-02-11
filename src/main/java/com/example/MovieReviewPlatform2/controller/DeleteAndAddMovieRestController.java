package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.CreateMovieDto;
import com.example.MovieReviewPlatform2.service.MovieService;
import com.example.MovieReviewPlatform2.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/movies")
@RequiredArgsConstructor
public class DeleteAndAddMovieRestController {

    private final MovieService movieService;
    private final MovieServiceImpl movieServiceImpl;

    /**
     * Удаление фильма по ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID фильма не указан");
        }

        boolean isDeleted = movieService.deleteMovie(id);
        if (isDeleted) {
            return ResponseEntity.ok("Фильм успешно удален");
        } else {
            return ResponseEntity.status(404).body("Фильм с таким ID не найден");
        }
    }
    /**
     * Добавление фильма
     */
    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody CreateMovieDto movieDto) {
        movieServiceImpl.addMovie(movieDto);
        return ResponseEntity.ok("Movie added successfully");
    }
}
