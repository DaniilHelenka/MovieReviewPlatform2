package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.CreateMovieDto;
import com.example.MovieReviewPlatform2.service.MovieService;
import com.example.MovieReviewPlatform2.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    // Метод для загрузки постера
    @PostMapping(value = "/upload-poster", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadPoster(@RequestParam("poster_url") MultipartFile poster_url) {
        // Сохраняем постер и получаем его название
        movieServiceImpl.uploadPoster(poster_url);
        return ResponseEntity.ok("Poster upload");
    }

    // Метод для добавления фильма
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMovie(@RequestBody CreateMovieDto movieDto) {
        // Загрузка фильма
        movieServiceImpl.addMovie(movieDto);
        return ResponseEntity.ok("Movie added successfully");
    }
}
