package com.example.MovieReviewPlatform2.mapper;

import com.example.MovieReviewPlatform2.dto.WatchlistDto;
import com.example.MovieReviewPlatform2.entity.Watchlist;
import org.springframework.stereotype.Component;

@Component
public class WatchlistMapper {
    public WatchlistDto mapFrom(Watchlist watchlist) {
        return WatchlistDto.builder()
                .id(watchlist.getId())
                .movieId(watchlist.getMovie().getId())
                .movieName(watchlist.getMovie().getName())
                .listType(watchlist.getListType())
                .build();
    }
}
