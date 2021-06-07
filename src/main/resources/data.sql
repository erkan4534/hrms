INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'vodafon-info@vodafon.com','123','507532404');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'turkcell-info@turkcell.com','1234','507532405');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'turtelekom-info@turtelekom.com','1235','507532406');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'ali-kaya@gmail.com','12356','507532407');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'bennu-adali@gmail.com','123567','507532408');


INSERT INTO "Employers" ("Id","FirmName","WebSite")
VALUES ((select "Id" from "Persons" where  "Email"='vodafon-info@vodafon.com'),'Vodafon','www.vodafon.com');
INSERT INTO "Employers" ("Id","FirmName","WebSite")
VALUES ((select "Id" from "Persons" where  "Email"='turkcell-info@turkcell.com'),'Türkcell', 'www.turkcell.com');
INSERT INTO "Employers" ("Id","FirmName","WebSite")
VALUES ((select "Id" from "Persons" where  "Email"='turtelekom-info@turtelekom.com'),'Türktelekom', 'www.turktelekom.com');


INSERT INTO "Candidates" ("Id", "Name","Surname","NationalId","BirthDate")
VALUES ((select "Id" from "Persons" where "Email"='ali-kaya@gmail.com'),
'Ali','Kaya','123',to_date('01-04-1983','dd-MM-yyyy'));
INSERT INTO "Candidates" ("Id", "Name","Surname","NationalId","BirthDate")
VALUES ((select "Id" from "Persons" where "Email"='bennu-adali@gmail.com'),
'Bennu','Adalı','1234',to_date('02-04-1986','dd-MM-yyyy'));


INSERT INTO "Positions" ("Id","Name")
VALUES ("positionSeq".nextval,'Software Developer');
INSERT INTO "Positions" ("Id","Name")
VALUES ("positionSeq".nextval,'Software Architect');
INSERT INTO "Positions" ("Id","Name")
VALUES ("positionSeq".nextval,'Business Analyst');


INSERT INTO "Cities" ("Id","Name")
VALUES ("citySeq".nextval,'İstanbul');
INSERT INTO "Cities" ("Id","Name")
VALUES ("citySeq".nextval,'Ankara');
INSERT INTO "Cities" ("Id","Name")
VALUES ("citySeq".nextval,'İzmir');


INSERT INTO "JobAdverts" ("Id","EmployerId","PositionId","Description","CityId","Status","MaxSalary",
"MinSalary","OpenPositionsNumber","CreateDate","ApplyDeadLine")
VALUES ("jobAdvertSeq".nextval,(select "Id" from "Persons" where  "Email"='vodafon-info@vodafon.com'),
(SELECT "Id" FROM "Positions" where "Name"='Software Developer'),
'Software Developer',(SELECT "Id" FROM "Cities" where "Name"='İstanbul'),1, 10000, 5000, 5,CURRENT_DATE, CURRENT_DATE+4);

INSERT INTO "JobAdverts" ("Id","EmployerId","PositionId","Description","CityId","Status","MaxSalary",
"MinSalary","OpenPositionsNumber","CreateDate","ApplyDeadLine")
VALUES ("jobAdvertSeq".nextval,(select "Id" from "Persons" where  "Email"='turkcell-info@turkcell.com'),
(SELECT "Id" FROM "Positions" where "Name"='Software Architect'),
'Software Architect',(SELECT "Id" FROM "Cities" where "Name"='Ankara'),0, 20000, 10000, 3,CURRENT_DATE, CURRENT_DATE+6);

INSERT INTO "JobAdverts" ("Id","EmployerId","PositionId","Description","CityId","Status","MaxSalary",
"MinSalary","OpenPositionsNumber","CreateDate","ApplyDeadLine")
VALUES ("jobAdvertSeq".nextval,(select "Id" from "Persons" where  "Email"='turtelekom-info@turtelekom.com'),
(SELECT "Id" FROM "Positions" where "Name"='Business Analyst'),
'Business Analyst',(SELECT "Id" FROM "Cities" where "Name"='İzmir'),1, 8000, 3000, 2,CURRENT_DATE, CURRENT_DATE+10);


INSERT INTO "CurriculumVitaes" ("Id","CoverLetter","GithubAddress","LinkedinAddress","CandidateId")
VALUES ("curriculumVitaeSeq".nextval, 'test','http://githubMyAddress','http://linkedinMyAddress',
(select "Id" from "Persons" where "Email"='bennu-adali@gmail.com'));

INSERT INTO "Abilities" ("Id","AbilityName","CurriculumVitaeId")
VALUES ("abilitySeq".nextval,'Java',(select "Id" from "CurriculumVitaes"
where "CandidateId"=(select "Id" from "Persons" where "Email"='bennu-adali@gmail.com')));

INSERT INTO "Abilities" ("Id","AbilityName","CurriculumVitaeId")
VALUES ("abilitySeq".nextval,'Excel,Word',(select "Id" from "CurriculumVitaes"
where "CandidateId"=(select "Id" from "Persons" where "Email"='bennu-adali@gmail.com')));

INSERT INTO "Educations" ("Id","PartName","SchoolName","StartingDate","GraduationDate","CurriculumVitaeId")
VALUES ("educationSeq".nextval,'Bilgisayar Mühendisliği.','Marmara Üniversitesi',
to_date('02-04-2010','dd-MM-yyyy'),to_date('02-09-2014','dd-MM-yyyy'),
(select "Id" from "CurriculumVitaes" where
"CandidateId"=(select "Id" from "Persons" where "Email"='bennu-adali@gmail.com')));

INSERT INTO "Educations" ("Id","PartName","SchoolName","StartingDate","GraduationDate","CurriculumVitaeId")
VALUES ("educationSeq".nextval,'Bilgisayar Programcılığı.','Ahmet Yesevi Üniversitesi',
to_date('02-04-2008','dd-MM-yyyy'),to_date('02-08-2010','dd-MM-yyyy'),
(select "Id" from "CurriculumVitaes" where
"CandidateId"=(select "Id" from "Persons" where "Email"='bennu-adali@gmail.com')));
