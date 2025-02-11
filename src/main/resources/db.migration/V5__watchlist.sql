create table watchlist
(
    id        serial
        primary key,
    user_id   integer      not null
        constraint fk_user
            references users
                on delete cascade,
    movie_id  integer      not null
        constraint fk_movie
            references movies
                on delete cascade,
    list_type varchar(255) not null,
    constraint uc_user_movie
        unique (user_id, movie_id, list_type)
);

alter table watchlist
    owner to techtask;