package com.example.MovieReviewPlatform2.service;

import com.example.MovieReviewPlatform2.entity.Movies;

import java.util.List;

public interface RecommendationService {
    List<Movies> getTop10RatedMovies();
}
