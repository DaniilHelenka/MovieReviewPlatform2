package com.example.MovieReviewPlatform2.service;

import com.example.MovieReviewPlatform2.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDto> findAll();

    List<MovieDto> findAllPaginated(int page, int size);

    Optional<MovieDto> findById(Integer id);

    boolean deleteMovie(Integer id);

    void moveToWatched(int movieId);
}
