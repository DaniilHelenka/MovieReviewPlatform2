create table movies
(
    id           serial
        primary key,
    name         varchar(255) not null,
    genre        varchar(255),
    description  text,
    release_date date,
    poster_url   varchar(255)
);
alter table movies
    owner to techtask;