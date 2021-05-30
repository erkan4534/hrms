INSERT INTO "Persons" ("Id","Email","Password","TelNo") VALUES ("personSeq".nextval,'vodafon-info@vodafon.com','123','507532404');
INSERT INTO "Persons" ("Id","Email","Password","TelNo") VALUES ("personSeq".nextval,'turkcell-info@turkcell.com','1234','507532405');
INSERT INTO "Persons" ("Id","Email","Password","TelNo") VALUES ("personSeq".nextval,'turtelekom-info@turtelekom.com','1235','507532406');

INSERT INTO "Employers" ("Id","FirmName","WebSite") VALUES ((select "Id" from "Persons" where  "Email"='vodafon-info@vodafon.com'),'Vodafon','www.vodafon.com');
INSERT INTO "Employers" ("Id","FirmName","WebSite") VALUES ((select "Id" from "Persons" where  "Email"='turkcell-info@turkcell.com'),'Türkcell', 'www.turkcell.com');
INSERT INTO "Employers" ("Id","FirmName","WebSite") VALUES ((select "Id" from "Persons" where  "Email"='turtelekom-info@turtelekom.com'),'Türktelekom', 'www.turktelekom.com');

INSERT INTO "Positions" ("Id","Name") VALUES ("positionSeq".nextval,'Software Developer');
INSERT INTO "Positions" ("Id","Name") VALUES ("positionSeq".nextval,'Software Architect');

INSERT INTO "Cities" ("Id","Name") VALUES ("citySeq".nextval,'İstanbul');
INSERT INTO "Cities" ("Id","Name") VALUES ("citySeq".nextval,'Ankara');
