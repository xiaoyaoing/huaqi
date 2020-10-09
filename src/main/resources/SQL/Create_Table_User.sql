create table user
(
ID    char(10) NOT NULL ,
name  char(40) NOT NULL ,
email char(40) NOT NULL,
passward char(40) NOT NULL ,
token char(100),
fresh_token char(100),
constraint pk1 primary key(ID)
)DEFAULT CHARSET=utf8;