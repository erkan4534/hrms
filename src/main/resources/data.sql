INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'vodafon-info@vodafon.com','123','507532404');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'turkcell-info@turkcell.com','1234','507532405');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'turtelekom-info@turtelekom.com','1235','507532406');
INSERT INTO "Persons" ("Id","Email","Password","TelNo")
VALUES ("personSeq".nextval,'ali-kaya@gmail.com','12356','507532407');


INSERT INTO "Employers" ("Id","FirmName","WebSite")
VALUES ((select "Id" from "Persons" where  "Email"='vodafon-info@vodafon.com'),'Vodafon','www.vodafon.com');
INSERT INTO "Employers" ("Id","FirmName","WebSite")
VALUES ((select "Id" from "Persons" where  "Email"='turkcell-info@turkcell.com'),'Türkcell', 'www.turkcell.com');
INSERT INTO "Employers" ("Id","FirmName","WebSite")
VALUES ((select "Id" from "Persons" where  "Email"='turtelekom-info@turtelekom.com'),'Türktelekom', 'www.turktelekom.com');

INSERT INTO "Candidates" ("Id", "Name","Surname","NationalId","BirthDate")
VALUES ((select "Id" from "Persons" where "Email"='ali-kaya@gmail.com'),
'Ali','kaya','123',to_date('01-04-1983','dd-MM-yyyy'));


INSERT INTO "Positions" ("Id","Name")
VALUES ("positionSeq".nextval,'Software Developer');
INSERT INTO "Positions" ("Id","Name")
VALUES ("positionSeq".nextval,'Software Architect');

INSERT INTO "Cities" ("Id","Name")
VALUES ("citySeq".nextval,'İstanbul');
INSERT INTO "Cities" ("Id","Name")
VALUES ("citySeq".nextval,'Ankara');





INSERT INTO "JobAdverts" ("Id","EmployerId","PositionId","Description","CityId","Status","MaxSalary", "MinSalary","OpenPositionsNumber","CreateDate","ApplyDeadLine")
VALUES ("jobAdvertSeq".nextval,(select "Id" from "Persons" where  "Email"='vodafon-info@vodafon.com'),(SELECT "Id" FROM "Positions" where "Name"='Software Developer'),
'Software Developer',(SELECT "Id" FROM "Cities" where "Name"='İstanbul'),1, 10000, 5000, 5,CURRENT_DATE, CURRENT_DATE+4);

INSERT INTO "JobAdverts" ("Id","EmployerId","PositionId","Description","CityId","Status","MaxSalary", "MinSalary","OpenPositionsNumber","CreateDate","ApplyDeadLine")
VALUES ("jobAdvertSeq".nextval,(select "Id" from "Persons" where  "Email"='vodafon-info@vodafon.com'),(SELECT "Id" FROM "Positions" where "Name"='Software Architect'),
'Software Architect',(SELECT "Id" FROM "Cities" where "Name"='Ankara'),0, 20000, 10000, 3,CURRENT_DATE, CURRENT_DATE+6);