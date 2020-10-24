create table user
(
ID    int(11) NOT NULL ,
username  char(40) NOT NULL ,
email char(40) NOT NULL,
password char(40) NOT NULL ,
token TEXT(350),
fresh_token TEXT(350),
primary key(ID)
);