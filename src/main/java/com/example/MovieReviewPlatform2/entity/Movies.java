package com.example.MovieReviewPlatform2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String genre;

    private String description;

    private String poster_url;

    private LocalDate release_date;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)  // Связь с Watchlist
    private List<Watchlist> watchlist;  // Список всех записей в Watchlist для этого фильма

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviews> reviews;

    public Movies(Integer id, String name, String genre, String description, String poster_url, LocalDate release_date) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.poster_url = poster_url;
        this.release_date = release_date;
    }

}