package com.example.MovieReviewPlatform2.service.impl;

import com.example.MovieReviewPlatform2.dto.WatchlistDto;
import com.example.MovieReviewPlatform2.entity.Movies;
import com.example.MovieReviewPlatform2.entity.Watchlist;
import com.example.MovieReviewPlatform2.mapper.WatchlistMapper;
import com.example.MovieReviewPlatform2.repository.MovieRepository;
import com.example.MovieReviewPlatform2.repository.WatchlistRepository;
import com.example.MovieReviewPlatform2.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final MovieRepository movieRepository;
    private final WatchlistRepository watchlistRepository;
    private final WatchlistMapper watchlistMapper;

    @Autowired
    public WatchlistServiceImpl(MovieRepository movieRepository,
                                WatchlistRepository watchlistRepository,
                                WatchlistMapper watchlistMapper) {
        this.movieRepository = movieRepository;
        this.watchlistRepository = watchlistRepository;
        this.watchlistMapper = watchlistMapper;
    }

    @Override
    @Transactional
    public void addMovieToWatchlist(int userId, Integer movieId, String listType) {
        Movies movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + movieId));

        Watchlist watchlist = Watchlist.builder()
                .userId(userId)
                .movie(movie)
                .listType(listType)
                .build();

        watchlistRepository.save(watchlist); // Spring Data JPA автоматически сохраняет запись
    }

    @Override
    @Transactional
    public boolean removeMovieFromWatchlist(int userId, int movieId, String listType) {
        Optional<Watchlist> watchlistOptional = watchlistRepository.findByMovieIdAndListType(movieId, listType);
        if (watchlistOptional.isPresent()) {
            Watchlist watchlist = watchlistOptional.get();
            if (watchlist.getUserId() == userId) {
                watchlistRepository.delete(watchlist);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<WatchlistDto> getUserWatchlistByType(int userId, String listType) {
        List<Watchlist> watchlists = watchlistRepository.findByUserIdAndListType(userId, listType);

        return watchlists.stream()
                .map(watchlistMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<WatchlistDto> getUserWatchlist(int userId) {
        List<Watchlist> watchlists = watchlistRepository.findByUserId(userId);

        return watchlists.stream()
                .map(watchlistMapper::mapFrom)
                .collect(Collectors.toList());
    }
}
