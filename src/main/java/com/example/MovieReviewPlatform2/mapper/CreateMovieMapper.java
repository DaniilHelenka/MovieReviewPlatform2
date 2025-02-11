package com.example.MovieReviewPlatform2.mapper;


import com.example.MovieReviewPlatform2.dto.CreateMovieDto;
import com.example.MovieReviewPlatform2.entity.Movies;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateMovieMapper implements Mapper<CreateMovieDto, Movies> {

    private static final String IMAGE_FOLDER = "posters/";

    public Movies mapFrom(CreateMovieDto object) {
        return Movies.builder()
                .name(object.getName())
                .genre(object.getGenre())
                .description(object.getDescription())
                .release_date(object.getRelease_date())
                .poster_url(IMAGE_FOLDER + object.getPoster_url())
                .build();
    }
}
