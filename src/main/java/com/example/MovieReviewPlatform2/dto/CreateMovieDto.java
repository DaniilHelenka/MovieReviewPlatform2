package com.example.MovieReviewPlatform2.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class CreateMovieDto {
    @JsonProperty("name")
    String name;
    @JsonProperty("genre")
    String genre;
    @JsonProperty("description")
    String description;
    @JsonProperty("release_date")
    LocalDate release_date;
    String poster_url;
}
