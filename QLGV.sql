Create database QLGV char set utf8mb4 collate utf8mb4_bin;
use QLGV;

CREATE TABLE LECTURER(
ID int auto_increment,
CODE varchar(50) not null,
NAME nvarchar(100) NOT NULL,
PHOTO varchar(100) null,
EMAIL varchar(50) not null,
PHONE varchar(12) not null,
SALARY float not null,
constraint pk_LECTURER primary key (id),
UNIQUE INDEX `CODE_UNIQUE` (`CODE` ASC)
);

CREATE TABLE USER(
ID int auto_increment,
USERNAME varchar(50) not null,
PASSWORD varchar(50) not null,
ROLE bit null,
LECTURERID int null,
constraint pk_USER primary key (ID),
constraint FK_USER_LECTURER 
FOREIGN KEY (LECTURERID) REFERENCES LECTURER(ID),
unique key UNI_USER_LECTURER  (LECTURERID) using btree
);

CREATE TABLE RECORD(
ID int auto_increment,
TYPERECORD bit not null,
DATERECORD date not null,
NOTE nvarchar(200) null,
LECTURERID int not null,
constraint pk_RECORD primary key (ID),
constraint FK_RECORD_LECTURER 
FOREIGN KEY (LECTURERID) REFERENCES LECTURER(ID)
);

CREATE TABLE MAJOR(
ID int auto_increment,
CODE varchar(50)  not null,
NAME nvarchar(200),
LECTURERID int null,
constraint pk_MAJOR primary key (ID),
constraint FK_MAJOR_LECTURER 
FOREIGN KEY (LECTURERID) REFERENCES LECTURER(ID),
UNIQUE INDEX `CODE_UNIQUE` (`CODE` ASC)
);

CREATE TABLE SUBJECT(
ID int auto_increment,
CODE varchar(50) not null ,
NAME nvarchar(200) not null,
MAJORID int  null,
LECTURERID  int null,
constraint pk_SUBJECT primary key (ID),
constraint FK_SUBJECT_MARJOR 
FOREIGN KEY (MAJORID) REFERENCES MAJOR(ID),
constraint FK_SUBJECT_LECTURER 
FOREIGN KEY (LECTURERID) REFERENCES LECTURER(ID),
UNIQUE INDEX `CODE_UNIQUE` (`CODE` ASC)
);

CREATE TABLE CLASS(
ID int auto_increment,
CODE varchar(50)  not null,
MAJORID int null,
LECTURERID  int null,
constraint pk_CLASS primary key (ID),
constraint FK_CLASS_MARJOR 
FOREIGN KEY (MAJORID) REFERENCES MAJOR(ID),
constraint FK_CLASS_LECTURER 
FOREIGN KEY (LECTURERID) REFERENCES LECTURER(ID),
UNIQUE INDEX `CODE_UNIQUE` (`CODE` ASC)
);


CREATE TABLE STUDENT(
ID int auto_increment,
CODE varchar(50)  not null,
NAME nvarchar(200),
PHONE varchar(12) null,
PHOTO varchar(100) null,
EMAIL varchar(50) null,
NOTE nvarchar(200) null,
CLASSID int null,
MAJORID int null,
constraint pk_STUDENT primary key (ID),
constraint FK_STUDENT_CLASS 
FOREIGN KEY (CLASSID) REFERENCES CLASS(ID),
constraint FK_STUDENT_MAJOR 
FOREIGN KEY (MAJORID) REFERENCES MAJOR(ID),
UNIQUE INDEX `CODE_UNIQUE` (`CODE` ASC)
);


CREATE TABLE STUDENTANDCLASS(
CLASSID int not null,
STUDENTID int not null,
constraint FK_STUDENTANDCLASS_CLASS 
FOREIGN KEY (CLASSID) REFERENCES CLASS(ID),
constraint FK_STUDENTANDCLASS_STUDENT 
FOREIGN KEY (STUDENTID) REFERENCES STUDENT(ID)
);

INSERT INTO `qlgv`.`lecturer` (`CODE`, `NAME`,`PHOTO`, `EMAIL`, `PHONE`, `SALARY`) VALUES ('PH04444', 'DoanTriBinh', '','binh@gmail.com', '01665881854', 30000000000);

INSERT INTO `qlgv`.`user` (`USERNAME`, `PASSWORD`, `ROLE`, `LECTURERID`) VALUES ('admin', 'admin', 1, 1);

INSERT INTO `qlgv`.`record` (`TYPERECORD`, `DATERECORD`, `NOTE`, `LECTURERID`) VALUES (0, 12/12/2018, 'NA', 1);

INSERT INTO `qlgv`.`major` (`CODE`, `NAME`,`LECTURERID`) VALUES ('PB001', 'Phong MA',1);

INSERT INTO `qlgv`.`subject` (`CODE`, `NAME`, `MAJORID`, `LECTURERID`) VALUES ('SOF305', 'Struts', 1, 1);

INSERT INTO `qlgv`.`class` (`CODE`, `MAJORID`, `LECTURERID`) VALUES ('PT11302UD', 1, 1);

INSERT INTO `qlgv`.`student` (`CODE`, `NAME`, `PHONE`, `EMAIL`, `CLASSID`,`MAJORID`) VALUES ('PH04486', 'Doan Tri Binh', '01665881854', 'binh@gmail.com', 1,1);
