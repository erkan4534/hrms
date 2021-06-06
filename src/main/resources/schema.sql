create table "Persons" (
"Id" bigint not null,
"Email" varchar(255) not null,
"Password" varchar(255) not null,
"TelNo" varchar(255) not null,
primary key ("Id"));

alter table "Persons"
add constraint "persons_email_unique"
unique ("Email");



create table "Candidates" (
"Id" bigint not null,
"BirthDate" timestamp not null,
"Name" varchar(255),
"NationalId" varchar(255),
"Surname" varchar(255),
primary key ("Id"));

alter table "Candidates"
add constraint "candidates_nationalId_unique"
unique ("NationalId");

alter table "Candidates"
add constraint "candidates_persons_id_fk"
foreign key ("Id")
references "Persons";




create table "Positions" (
"Id" bigint not null,
"Name" varchar(255) not null,
primary key ("Id"));

alter table "Positions"
add constraint "positions_name_unique"
unique ("Name");




create table "Employees"(
"Id" bigint not null,
"Name" varchar(255) not null,
"Surname" varchar(255) not null,
"PositionId" bigint,
"NationalId" varchar(255) not null,
"BirthDate" timestamp not null,
primary key ("Id"));

alter table "Employees"
add constraint "employees_nationalId_unique"
unique ("NationalId");

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
add constraint "systemEmployees_nationalId_unique"
unique ("NationalId");

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
"CreateDate" DATETIME,
"ApplyDeadLine" date,
primary key ("Id"));




alter table "JobAdverts"
add constraint "jobAdverts_employer_id_fk"
foreign key ("EmployerId")
references "Employers";

alter table "JobAdverts"
add constraint "jobAdverts_city_id_fk"
foreign key ("CityId")
references "Cities";

alter table "JobAdverts"
add constraint "jobAdverts_position_id_fk"
foreign key ("PositionId")
references "Positions";



create table "CurriculumVitaes" (
"Id" bigint not null,
"CoverLetter" varchar(255),
"GithubAddress" varchar(255),
"LinkedinAddress" varchar(255),
"CandidateId" bigint not null,
primary key ("Id"));

alter table "CurriculumVitaes"
add constraint curriculumVitae_candidate_id_fk
foreign key ("CandidateId")
references "Candidates";



create table "Abilities" (
"Id" bigint not null,
"AbilityName" varchar(255),
"CurriculumVitaeId" bigint not null,
primary key ("Id"));

alter table "Abilities"
add constraint ability_curriculumVitae_id_fk
foreign key ("CurriculumVitaeId")
references "CurriculumVitaes";



create table "Educations" (
"Id" bigint not null,
"GraduationDate" timestamp,
"PartName" varchar(255),
"SchoolName" varchar(255),
"StartingDate" timestamp,
"CurriculumVitaeId" bigint not null,
primary key ("Id"));

alter table "Educations"
add constraint education_curriculumVitae_id_fk
foreign key ("CurriculumVitaeId")
references "CurriculumVitaes";



create table "Experiences" (
"Id" bigint not null,
"FirmName" varchar(255),
"PositionName" varchar(255),
"quitDate" date,
"startingDate" date not null,
"CurriculumVitaeId" bigint not null,
primary key ("Id"));

alter table "Experiences"
add constraint experience_curriculumVitae_id_fk
foreign key ("CurriculumVitaeId")
references "CurriculumVitaes";



create table "Languages" (
"Id" bigint not null,
"Degree" bigint check ("Degree"<=5 AND "Degree">=1),
"Language" varchar(255) not null,
"CurriculumVitaeId" bigint not null,
primary key ("Id"));


alter table "Languages"
add constraint language_curriculumVitae_id_fk
foreign key ("CurriculumVitaeId")
references "CurriculumVitaes";





create sequence "abilitySeq" start with 1 increment by 1;
create sequence "citySeq" start with 1 increment by 1;
create sequence "curriculumVitaeSeq" start with 1 increment by 1;
create sequence "educationSeq" start with 1 increment by 1;
create sequence "experienceSeq" start with 1 increment by 1;
create sequence "jobAdvertSeq" start with 1 increment by 1;
create sequence "languageSeq" start with 1 increment by 1;
create sequence "personSeq" start with 1 increment by 1;
create sequence "positionSeq" start with 1 increment by 1;