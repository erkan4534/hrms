create table "Persons" (
"Id" bigint not null,
"Email" varchar(255) not null,
"Password" varchar(255) not null,
"TelNo" varchar(255) not null,
primary key ("Id"));

alter table "Persons"
add constraint "persons_email_unique" unique ("Email");

CREATE SEQUENCE "personSeq" START WITH 1 INCREMENT BY 1;

create table "Candidates" (
"Id" bigint not null,
"BirthDate" timestamp not null,
"Name" varchar(255),
"NationalId" varchar(255),
"Surname" varchar(255),
primary key ("Id"));

alter table "Candidates"
add constraint "candidates_nationalId_unique" unique ("NationalId");

alter table "Candidates"
add constraint "candidates_persons_id_fk"
foreign key ("Id")
references "Persons";

create table "Positions" (
"Id" bigint not null,
"Name" varchar(255) not null,
primary key ("Id"));

CREATE SEQUENCE "positionSeq" START WITH 1 INCREMENT BY 1;

alter table "Positions"
add constraint "positions_name_unique" unique ("Name");


create table "Employees"(
"Id" bigint not null,
"Name" varchar(255) not null,
"Surname" varchar(255) not null,
"PositionId" bigint,
"NationalId" varchar(255) not null,
"BirthDate" timestamp not null,
primary key ("Id"));

alter table "Employees"
add constraint "employees_nationalId_unique" unique ("NationalId");

alter table "Employees"
add constraint "employees_persons_id_fk"
foreign key ("Id")
references "Persons";

alter table "Employees"
add constraint "employees_positions_id_fk"
foreign key ("PositionId")
references "Positions";

create table "Employers" (
"Id" bigint not null,
"FirmName" varchar(255) not null,
"WebSite" varchar(255) not null,
primary key ("Id"));

alter table "Employers"
add constraint "employers_persons_id_fk"
foreign key ("Id")
references "Persons";


create table "SystemEmployees" (
"Id" bigint not null,
"Name" varchar(255) not null,
"Surname" varchar(255) not null,
"BirthDate" timestamp not null,
"NationalId" varchar(255) not null,
"PositionId" bigint,
primary key ("Id"));

alter table "SystemEmployees"
add constraint "systemEmployees_nationalId_unique" unique ("NationalId");

alter table "SystemEmployees"
add constraint "systemEmployees_persons_id_fk"
foreign key ("Id")
references "Persons";

alter table "SystemEmployees"
add constraint "systemEmployees_positions_id_fk"
foreign key ("PositionId")
references "Positions";

create table "Cities" (
"Id" bigint not null,
"Name" varchar(255) not null,
primary key ("Id"));

CREATE SEQUENCE "citySeq" START WITH 1 INCREMENT BY 1;


create table "JobAdverts" (
"Id" bigint not null,
"EmployerId" bigint not null,
"PositionId" bigint not null,
"Description" varchar(255) not null,
"CityId" bigint not null,
"Status" integer not null,
"MaxSalary" bigint,
"MinSalary" bigint,
"OpenPositionsNumber" bigint not null,
"CreateDate" timestamp,
"ApplyDeadLine" timestamp,
primary key ("Id"));


alter table "JobAdverts"
add constraint "jobAdverts_employer_Id_fk"
foreign key ("EmployerId")
references "Employers";


alter table "JobAdverts"
add constraint "jobAdverts_city_Id_fk"
foreign key ("CityId")
references "Cities";

alter table "JobAdverts"
add constraint "jobAdverts_position_Id_fk"
foreign key ("PositionId")
references "Positions";

CREATE SEQUENCE "jobAdvertSeq" START WITH 1 INCREMENT BY 1;
