drop database if exists groups_students;
create database groups_students;
use groups_students;
drop table if exists groups_table;
drop table if exists students_table;
drop table if exists groups_students_table;

create table groups_table
(
    id           bigint auto_increment
        primary key,
    created      datetime(6)  null,
    updated      datetime(6)  null,
    name varchar(255) not null
);

create table students_table
(
    id        bigint auto_increment
        primary key,
    created   datetime(6)  null,
    updated   datetime(6)  null,
    first_name varchar(255) not null,
    last_name varchar(255) not null
);

create table groups_students_table
(
    student_id bigint not null,
    group_id    bigint not null,
    primary key (student_id, group_id),
    foreign key (student_id) references students_table (id) ON DELETE CASCADE,
    foreign key (group_id) references groups_table (id) ON DELETE CASCADE
);