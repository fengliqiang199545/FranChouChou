/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     1/7/2019 5:48:55 PM                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('course') and o.name = 'FK_COURSE_COURSE&CO_COLLEGE')
alter table course
   drop constraint FK_COURSE_COURSE&CO_COLLEGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('course') and o.name = 'FK_COURSE_COURSE&TE_TEACHER')
alter table course
   drop constraint FK_COURSE_COURSE&TE_TEACHER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('student') and o.name = 'FK_STUDENT_STUDENT&C_COLLEGE')
alter table student
   drop constraint FK_STUDENT_STUDENT&C_COLLEGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('teacher') and o.name = 'FK_TEACHER_TEACHER&C_COLLEGE')
alter table teacher
   drop constraint FK_TEACHER_TEACHER&C_COLLEGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('userlogin') and o.name = 'FK_USERLOGI_USERLOGIN_ROLE')
alter table userlogin
   drop constraint FK_USERLOGI_USERLOGIN_ROLE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('college')
            and   type = 'U')
   drop table college
go

if exists (select 1
            from  sysobjects
           where  id = object_id('course')
            and   type = 'U')
   drop table course
go

if exists (select 1
            from  sysobjects
           where  id = object_id('role')
            and   type = 'U')
   drop table role
go

if exists (select 1
            from  sysobjects
           where  id = object_id('student')
            and   type = 'U')
   drop table student
go

if exists (select 1
            from  sysobjects
           where  id = object_id('teacher')
            and   type = 'U')
   drop table teacher
go

if exists (select 1
            from  sysobjects
           where  id = object_id('userlogin')
            and   type = 'U')
   drop table userlogin
go

/*==============================================================*/
/* Table: college                                               */
/*==============================================================*/
create table college (
   collegeID            int(11)              not null,
   collegeName          varchar(200)         not null,
   constraint PK_COLLEGE primary key (collegeID)
)
go

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course (
   courseID             int(11)              not null,
   courseName           varchar(200)         not null,
   teacherID            int(11)              not null,
   collegeID            int(11)              not null,
   courseTIme           varchar(200)         null default null,
   classRoom            varchar(200)         null default null,
   courseWeek           int(200)             null default null,
   courseType           varchar(20)          null default null,
   score                int(11)              null,
   constraint PK_COURSE primary key (courseID, teacherID, collegeID)
)
go

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role (
   roleID               int(11)              not null,
   roleName             varchar(20)          not null,
   permissions          varchar(255)         null default null,
   constraint PK_ROLE primary key (roleID)
)
go

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student (
   userID               int(11)              not null,
   userName             varchar(200)         not null,
   sex                  varchar(20)          null default null,
   birthYear            date                 null default null,
   grade                date                 null default null,
   collegeID            int(11)              not null,
   constraint PK_STUDENT primary key (userID, collegeID)
)
go

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher (
   userID               int(11)              not null,
   userName             varchar(200)         not null,
   sex                  varchar(20)          null default null,
   birthYear            date                 not null,
   degree               varchar(20)          null default null,
   title                varchar(255)         null default null,
   grade                date                 null default null,
   collegeID            int(11)              not null,
   constraint PK_TEACHER primary key (userID, collegeID)
)
go

/*==============================================================*/
/* Table: userlogin                                             */
/*==============================================================*/
create table userlogin (
   userID               int(11)              not null,
   userName             varchar(200)         not null,
   password             varchar(200)         not null,
   role                 int(11)              not null,
   constraint PK_USERLOGIN primary key (userID, role)
)
go

alter table course
   add constraint FK_COURSE_COURSE&CO_COLLEGE foreign key (collegeID)
      references college (collegeID)
go

alter table course
   add constraint FK_COURSE_COURSE&TE_TEACHER foreign key (teacherID)
      references teacher (userID)
go

alter table student
   add constraint FK_STUDENT_STUDENT&C_COLLEGE foreign key (collegeID)
      references college (collegeID)
go

alter table teacher
   add constraint FK_TEACHER_TEACHER&C_COLLEGE foreign key (collegeID)
      references college (collegeID)
go

alter table userlogin
   add constraint FK_USERLOGI_USERLOGIN_ROLE foreign key (role)
      references role (roleID)
go

