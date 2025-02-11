package com.example.MovieReviewPlatform2.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CreateMovieDto {
    String name;
    String genre;
    String description;
    LocalDate release_date;
    String poster_url;
}
