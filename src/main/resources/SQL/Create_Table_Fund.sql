create table fund
(
    ID int(15) NOT NULL,
    name char(40) NOT NULL ,
    industry TEXT(200)  ,
    riskPotential TEXT(200)  ,
    investigationResult TEXT(300)  ,
    distributionDescription TEXT(300)  ,
    fundGoal TEXT(300)  ,
    minimumInvestAmount TEXT(200),
    `beginTime` char(200),
    `endTime` char(200),
    primary key (ID)
)