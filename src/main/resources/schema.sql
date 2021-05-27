create table Candidates (
Id bigint not null,
BirthDate timestamp not null,
Name varchar(255),
NationalId varchar(255),
Surname varchar(255),
primary key (Id)
);

create table Employees(
Id bigint not null,
BirthDate timestamp not null,
Name varchar(255) not null,
NationalId varchar(255) not null,
Surname varchar(255) not null,
primary key (Id)
);

create table Employers (
Id bigint not null,
FirmName varchar(255) not null,
WebSite varchar(255) not null,
primary key (Id)
);

create table Persons (
Id bigint not null,
Email varchar(255) not null,
Password varchar(255) not null,
TelNo varchar(255) not null,
primary key (Id)
);

create table SystemEmployees (
Id bigint not null,
BirthDate timestamp not null,
Name varchar(255) not null,
NationalId varchar(255) not null,
Surname varchar(255) not null,
primary key (Id)
);

alter table Candidates
add constraint candidates_nationalId_unique unique (NationalId);

alter table Employees
add constraint employees_nationalId_unique unique (NationalId);

alter table Persons
add constraint persons_email_unique unique (Email);

alter table SystemEmployees
add constraint systemEmployees_nationalId_unique unique (NationalId);

alter table Candidates
add constraint candidates_persons_id_fk
foreign key (Id)
references Persons;

alter table Employees
add constraint employees_persons_id_fk
foreign key (Id)
references Persons;

alter table Employers
add constraint employers_persons_id_fk
foreign key (Id)
references Persons;

alter table SystemEmployees
add constraint systemEmployees_persons_id_fk
foreign key (Id)
references Persons;

alter table Persons
add constraint persons_fk
foreign key (Id)
references Persons;