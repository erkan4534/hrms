INSERT INTO Persons (Id,Email,Password,TelNo) VALUES (1,'etiya@gmail.com','123','507532404');
INSERT INTO Persons (Id,Email,Password,TelNo) VALUES (2,'cardif@gmail.com','1234','507532405');
INSERT INTO Persons (Id,Email,Password,TelNo) VALUES (3,'turtelekom@gmail.com','1235','507532406');

INSERT INTO Employers (Id,FirmName, WebSite) VALUES ((select id from Persons where  Email='etiya@gmail.com'),'Etiya','www.etiya.com');
INSERT INTO Employers (Id,FirmName, WebSite) VALUES ((select id from Persons where  Email='cardif@gmail.com'),'Cardif', 'www.cardif.com');
INSERT INTO Employers (Id,FirmName,WebSite) VALUES ((select id from Persons where  Email='turtelekom@gmail.com'),'Türktelekom', 'www.turktelekom.com');