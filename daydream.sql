create database daydream;
use daydream;
CREATE TABLE Persons (
	PersonID int default null comment 'id',
    NickName varchar(63) default '' comment '昵称', 
    Avatar varchar(255) default '' comment '头像'
);

CREATE TABLE Movies (
	MovieName varchar(255) default '' comment '电影名称',
    MovieCover varchar(255) default '' comment '封面',
    MoviePath varchar(255) default '' comment '电影路径',
    MovieID int default null comment '电影id'
)