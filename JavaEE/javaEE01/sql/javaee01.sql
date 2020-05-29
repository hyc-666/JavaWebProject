drop database if exists javaee01;

create database javaee01;
use javaee01;
create table user(
    `username` varchar(40) unique not null,
     `password` varchar(32)
);