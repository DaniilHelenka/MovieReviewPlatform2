create table users
(
    id       serial
        primary key,
    name     varchar(255) not null,
    username varchar(255) not null
        constraint users_email_key
            unique,
    image    varchar(255) not null,
    password varchar(255) not null,
    role     varchar(255) not null
);

alter table users
    owner to techtask;