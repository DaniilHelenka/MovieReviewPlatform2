create table reviews
(
    id         serial
        primary key,
    user_id    integer not null
        references users,
    movie_id   integer not null
        references movies,
    rating     integer
        constraint reviews_rating_check
            check ((rating >= 1) AND (rating <= 10)),
    comments   text,
    created_at timestamp default CURRENT_TIMESTAMP
);

alter table reviews
    owner to techtask;