package com.example.MovieReviewPlatform2.controller;

import com.example.MovieReviewPlatform2.dto.MovieDto;
import com.example.MovieReviewPlatform2.dto.MovieResponse;
import com.example.MovieReviewPlatform2.entity.Movies;
import com.example.MovieReviewPlatform2.mapper.MovieMapper;
import com.example.MovieReviewPlatform2.service.MovieService;
import com.example.MovieReviewPlatform2.service.RecommendationService;
import com.example.MovieReviewPlatform2.service.impl.ImageServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieRestController {

    private final MovieService movieService;
    private final RecommendationService recommendationService;
    private final MovieMapper movieMapper;
    private final ImageServiceClient imageServiceClient;

    /**
     * Получение списка фильмов с пагинацией
     */
    @GetMapping
    public ResponseEntity<?> getMovies(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "2") int size) {
        List<MovieDto> movies = movieService.findAllPaginated(page, size);
        movies.forEach(movie -> {
            if (movie.getPoster_url() != null) {
                movie.setPoster_url(imageServiceClient.getPosterUrl(movie.getPoster_url()));
            }
        });
        int totalMovies = movieService.findAll().size();
        int totalPages = (totalMovies + size - 1) / size;

        return ResponseEntity.ok(new MovieResponse(movies, page, size, totalPages, totalMovies));
    }

    /**
     * Получение топ-10 фильмов по рейтингу
     */
    @GetMapping("/top")
    public ResponseEntity<List<MovieDto>> getTopMovies() {
        List<Movies> topMovies = recommendationService.getTop10RatedMovies();
        List<MovieDto> movieDtos = topMovies.stream()
                .map(movieMapper::mapFrom)
                .toList();
        movieDtos.forEach(movie -> {
            if (movie.getPoster_url() != null) {
                movie.setPoster_url(imageServiceClient.getPosterUrl(movie.getPoster_url()));
            }
        });
        return ResponseEntity.ok(movieDtos);
    }
}