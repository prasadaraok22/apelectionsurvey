Host:	localhost
Port:	3306
DBName:	apelectionsurvey
User:	apsurveyuser
Pwd:	apsurveyPWD9563


Admin User:	root
Admin Pwd:	root

CREATE DATABASE apelectionsurvey;

USE apelectionsurvey;

CREATE USER 'apsurveyuser'@'localhost' IDENTIFIED BY 'apsurveyPWD9563';

GRANT ALL PRIVILEGES ON * . * TO 'apsurveyuser'@'localhost';


/************************************/;
/* DISTRICT SQL Table */;
/************************************/;
CREATE TABLE district (
  id int AUTO_INCREMENT NOT NULL,
  districtcode varchar(3) NOT NULL,
  districtname nvarchar(100) NOT NULL,
  stateid varchar(3) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (districtcode, stateid) 
);

/************************************/;
/* AssemblyConstituency SQL Table */;
/************************************/;
CREATE TABLE assemblyconstituency (
  id int AUTO_INCREMENT NOT NULL,
  constituencycode varchar(3) NOT NULL,
  constituencyname nvarchar(100) NOT NULL,
  districtcode varchar(3) NOT NULL,
  stateid varchar(3) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (constituencycode, districtcode, stateid) 
);

/************************************/;
/* AssemblyConstituencyVotes SQL Table */;
/************************************/;
CREATE TABLE assemblyconstituencyvotes (
  id int AUTO_INCREMENT NOT NULL,
  constituencycode varchar(3) NOT NULL,
  districtcode varchar(3) NOT NULL,
  stateid varchar(3) NOT NULL,
  partyid varchar(10) NOT NULL,
  logtime TIMESTAMP  NOT NULL,
  PRIMARY KEY (id)
);


/************************************/;
/* PartyVotes SQL Table */;
/************************************/;
CREATE TABLE partyvotes (
  id int AUTO_INCREMENT NOT NULL,
  stateid varchar(3) NOT NULL,
  partyid varchar(10) NOT NULL,
  logtime TIMESTAMP  NOT NULL,
  PRIMARY KEY (id)
);


insert into District(districtCode,districtName,stateID) values ('12','Anantapur','S01');
insert into District(districtCode,districtName,stateID) values ('13','Chittoor','S01');
insert into District(districtCode,districtName,stateID) values ('4','East Godavari','S01');
insert into District(districtCode,districtName,stateID) values ('7','Guntur','S01');
insert into District(districtCode,districtName,stateID) values ('10','Kadapa','S01');
insert into District(districtCode,districtName,stateID) values ('6','Krishna','S01');
insert into District(districtCode,districtName,stateID) values ('11','Kurnool','S01');
insert into District(districtCode,districtName,stateID) values ('9','Nellore','S01');
insert into District(districtCode,districtName,stateID) values ('8','Prakasam','S01');
insert into District(districtCode,districtName,stateID) values ('1','Srikakulam','S01');
insert into District(districtCode,districtName,stateID) values ('3','Visakhapatnam','S01');
insert into District(districtCode,districtName,stateID) values ('2','Vizianagaram','S01');
insert into District(districtCode,districtName,stateID) values ('5','West Godavari','S01');