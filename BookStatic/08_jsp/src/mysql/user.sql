CREATE database user;
use user;
create TABLE user(
    `id` INT primary key auto_increment,
    `username` varchar (40),
    `password` varchar (32)
);
insert into user values(0 ,'root','root');
insert into user values(null ,'user1','user1');
insert into user values(null ,'user2','user2');
insert into user values(null ,'user3','user3');
