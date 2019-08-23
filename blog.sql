use blog;
create table user
(
    id       int auto_increment
        primary key,
    name     varchar(255) not null,
    password varchar(255) not null,
    email    varchar(100) null
);
create table article
(
    id          int auto_increment
        primary key,
    user_id     int          null,
    title       varchar(255) null,
    content     mediumtext   null,
    summary     text         null,
    update_time datetime     null,
    create_time datetime     null
);
create table comment
(
    id          int auto_increment
        primary key,
    content     text         null,
    name        varchar(255) null,
    email       varchar(100) null,
    create_time datetime     null,
    article_id  int          not null
);