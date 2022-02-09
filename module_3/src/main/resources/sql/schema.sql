/*drop database if exists bank;
create database bank;
use bank;
drop table if exists users;
drop table if exists accounts;

create table users
(
    id           bigint auto_increment
        primary key,
    name varchar(255) not null
);

create table accounts
(
    id        bigint auto_increment
        primary key,
    balance bigint not null,
    wallet varchar(255) not null,
    user_id    bigint not null,
    foreign key (user_id) references users (id)
);*/
