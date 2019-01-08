/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     1/8/2019 2:59:48 PM                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('course') and o.name = 'FK_COURSE_COURSECOL_COLLEGE')
alter table course
   drop constraint FK_COURSE_COURSECOL_COLLEGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('course') and o.name = 'FK_COURSE_COURSETEA_TEACHER')
alter table course
   drop constraint FK_COURSE_COURSETEA_TEACHER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('selectedcourse') and o.name = 'FK_SELECTED_SELECTEDC_COURSE')
alter table selectedcourse
   drop constraint FK_SELECTED_SELECTEDC_COURSE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('selectedcourse') and o.name = 'FK_SELECTED_SELECTEDC_STUDENT')
alter table selectedcourse
   drop constraint FK_SELECTED_SELECTEDC_STUDENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('student') and o.name = 'FK_STUDENT_STUDENTCO_COLLEGE')
alter table student
   drop constraint FK_STUDENT_STUDENTCO_COLLEGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('teacher') and o.name = 'FK_TEACHER_TEACHERCO_COLLEGE')
alter table teacher
   drop constraint FK_TEACHER_TEACHERCO_COLLEGE
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
           where  id = object_id('selectedcourse')
            and   type = 'U')
   drop table selectedcourse
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
   collegeID            int                  not null,
   collegeName          varchar(200)         not null,
   constraint PK_COLLEGE primary key (collegeID)
)
go

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course (
   courseID             int                  not null,
   courseName           varchar(200)         not null,
   teacherID            int                  not null,
   collegeID            int                  not null,
   courseTIme           varchar(200)         null default null,
   classRoom            varchar(200)         null default null,
   courseWeek           int                  null default null,
   courseType           varchar(20)          null default null,
   score                int                  null,
   constraint PK_COURSE primary key (courseID)
)
go

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role (
   roleID               int                  not null,
   roleName             varchar(20)          not null,
   permissions          varchar(255)         null default null,
   constraint PK_ROLE primary key (roleID)
)
go

/*==============================================================*/
/* Table: selectedcourse                                        */
/*==============================================================*/
create table selectedcourse (
   courseID             int                  not null,
   studentID            int                  not null,
   mark                 int                  null default null,
   constraint PK_SELECTEDCOURSE primary key (courseID, studentID)
)
go

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student (
   userID               int                  not null,
   userName             varchar(200)         not null,
   sex                  varchar(20)          null default null,
   birthYear            date                 null default null,
   grade                date                 null default null,
   collegeID            int                  not null,
   constraint PK_STUDENT primary key (userID)
)
go

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher (
   userID               int                  not null,
   userName             varchar(200)         not null,
   sex                  varchar(20)          null default null,
   birthYear            date                 not null,
   degree               varchar(20)          null default null,
   title                varchar(255)         null default null,
   grade                date                 null default null,
   collegeID            int                  not null,
   constraint PK_TEACHER primary key (userID)
)
go

/*==============================================================*/
/* Table: userlogin                                             */
/*==============================================================*/
create table userlogin (
   userID               int                  not null,
   userName             varchar(200)         not null,
   password             varchar(200)         not null,
   role                 int                  not null,
   constraint PK_USERLOGIN primary key (userID, role)
)
go

alter table course
   add constraint FK_COURSE_COURSECOL_COLLEGE foreign key (collegeID)
      references college (collegeID)
go

alter table course
   add constraint FK_COURSE_COURSETEA_TEACHER foreign key (teacherID)
      references teacher (userID)
go

alter table selectedcourse
   add constraint FK_SELECTED_SELECTEDC_COURSE foreign key (courseID)
      references course (courseID)
go

alter table selectedcourse
   add constraint FK_SELECTED_SELECTEDC_STUDENT foreign key (studentID)
      references student (userID)
go

alter table student
   add constraint FK_STUDENT_STUDENTCO_COLLEGE foreign key (collegeID)
      references college (collegeID)
go

alter table teacher
   add constraint FK_TEACHER_TEACHERCO_COLLEGE foreign key (collegeID)
      references college (collegeID)
go

alter table userlogin
   add constraint FK_USERLOGI_USERLOGIN_ROLE foreign key (role)
      references role (roleID)
go

