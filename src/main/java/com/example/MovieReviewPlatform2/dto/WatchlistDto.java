package com.example.MovieReviewPlatform2.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class WatchlistDto {
    Integer id;
    String movieName;
    String listType;
    Integer movieId;
}
