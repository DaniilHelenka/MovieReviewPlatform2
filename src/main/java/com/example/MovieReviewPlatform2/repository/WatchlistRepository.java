package com.example.MovieReviewPlatform2.repository;

import com.example.MovieReviewPlatform2.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    List<Watchlist> findByUserId(int userId);

    List<Watchlist> findByUserIdAndListType(int userId, String listType);

    Optional<Watchlist> findByMovieIdAndListType(int movieId, String listType);
}
