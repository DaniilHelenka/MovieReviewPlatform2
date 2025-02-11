package com.example.MovieReviewPlatform2.service;

import com.example.MovieReviewPlatform2.dto.WatchlistDto;

import java.util.List;

public interface WatchlistService {
    void addMovieToWatchlist(int userId, Integer movieId, String listType);

    boolean removeMovieFromWatchlist(int userId, int movieId, String listType);

    List<WatchlistDto> getUserWatchlistByType(int userId, String listType);

    List<WatchlistDto> getUserWatchlist(int userId);
}
