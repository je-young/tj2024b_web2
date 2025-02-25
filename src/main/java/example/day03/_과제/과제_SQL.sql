drop database if exists springweb;
create database springweb;
use springweb;

create table board
(
    bno     int auto_increment primary key,
    title   varchar(255) not null,
    content text         not null
);

create table student
(
    sno  int auto_increment,
    name varchar(100),
    kor  int,
    math int,
    constraint primary key (sno)
);