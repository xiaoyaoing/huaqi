create table fundreport
(
    ID int(15) NOT NULL,
    name char(40) NOT NULL ,
    income TEXT(200) NOT NULL ,
    investmentDetail TEXT(500) NOT NULL ,
    investigationResult TEXT(500) NOT NULL ,
    investmentStrategy TEXT(500) NOT NULL ,
    analyseResult TEXT(500),
    primary key (ID)
);