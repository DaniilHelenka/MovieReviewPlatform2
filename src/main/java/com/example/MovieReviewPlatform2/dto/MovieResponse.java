package com.example.MovieReviewPlatform2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MovieResponse {
    private final List<MovieDto> movies;
    private final int currentPage;
    private final int pageSize;
    private final int totalPages;
    private final int totalMovies;
}
