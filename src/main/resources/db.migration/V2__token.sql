create table refresh_tokens
(
    id          bigint generated by default as identity
        primary key,
    expiry_date timestamp(6) with time zone not null,
    token       varchar(255)                not null
        constraint ukghpmfn23vmxfu3spu3lfg4r2d
            unique,
    user_id     integer                     not null
        constraint fk1lih5y2npsf8u5o3vhdb9y0os
            references users
);

alter table refresh_tokens
    owner to techtask;