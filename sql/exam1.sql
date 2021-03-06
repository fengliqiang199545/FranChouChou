USE [examination_system]
GO
/****** Object:  Table [dbo].[college]    Script Date: 1/24/2019 5:13:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[college](
	[collegeID] [int] NOT NULL,
	[collegeName] [varchar](200) NOT NULL,
 CONSTRAINT [PK_COLLEGE] PRIMARY KEY CLUSTERED 
(
	[collegeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[course]    Script Date: 1/24/2019 5:13:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[course](
	[courseID] [int] NOT NULL,
	[courseName] [varchar](200) NOT NULL,
	[teacherID] [int] NOT NULL,
	[courseTIme] [varchar](200) NULL,
	[classRoom] [varchar](200) NULL,
	[courseWeek] [int] NULL,
	[courseType] [varchar](20) NULL,
	[collegeID] [int] NOT NULL,
	[score] [int] NULL,
 CONSTRAINT [PK_COURSE] PRIMARY KEY CLUSTERED 
(
	[courseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 1/24/2019 5:13:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[roleID] [int] NOT NULL,
	[roleName] [varchar](20) NOT NULL,
	[permissions] [varchar](255) NULL,
 CONSTRAINT [PK_ROLE] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[selectedcourse]    Script Date: 1/24/2019 5:13:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[selectedcourse](
	[courseID] [int] NOT NULL,
	[studentID] [int] NOT NULL,
	[mark] [int] NULL,
 CONSTRAINT [PK_SELECTEDCOURSE] PRIMARY KEY CLUSTERED 
(
	[courseID] ASC,
	[studentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 1/24/2019 5:13:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[userID] [int] NOT NULL,
	[userName] [varchar](200) NOT NULL,
	[sex] [varchar](20) NULL,
	[birthYear] [date] NULL,
	[grade] [date] NULL,
	[collegeID] [int] NOT NULL,
 CONSTRAINT [PK_STUDENT] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[teacher]    Script Date: 1/24/2019 5:13:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[teacher](
	[userID] [int] NOT NULL,
	[userName] [varchar](200) NOT NULL,
	[sex] [varchar](20) NULL,
	[birthYear] [date] NOT NULL,
	[degree] [varchar](20) NULL,
	[title] [varchar](255) NULL,
	[grade] [date] NULL,
	[collegeID] [int] NOT NULL,
 CONSTRAINT [PK_TEACHER] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userlogin]    Script Date: 1/24/2019 5:13:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userlogin](
	[userID] [int] IDENTITY(30,1) NOT NULL,
	[userName] [varchar](200) NOT NULL,
	[password] [varchar](200) NOT NULL,
	[role] [int] NOT NULL,
 CONSTRAINT [PK_userlogin_1] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[college] ([collegeID], [collegeName]) VALUES (1, N'计算机系')
INSERT [dbo].[college] ([collegeID], [collegeName]) VALUES (2, N'设计系')
INSERT [dbo].[college] ([collegeID], [collegeName]) VALUES (3, N'财经系')
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (1, N'C语言程序设计', 1001, N'周二', N'科401', 18, N'必修课', 1, 3)
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (2, N'Python爬虫技巧', 1001, N'周四', N'X402', 18, N'必修课', 1, 3)
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (4, N'Java程序设计', 1002, N'周五', N'科401', 18, N'必修课', 1, 2)
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (5, N'英语', 1002, N'周四', N'X302', 18, N'必修课', 2, 2)
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (6, N'服装设计', 1003, N'周一', N'科401', 18, N'选修课', 2, 2)
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (1234, N'室内设计', 31321, N'', N'A教学楼', NULL, N'必修课', 1, 3)
INSERT [dbo].[course] ([courseID], [courseName], [teacherID], [courseTIme], [classRoom], [courseWeek], [courseType], [collegeID], [score]) VALUES (32132, N'佛挡杀佛', 1001, N'321321', N'佛挡杀佛反倒是', 23, N'必修课', 1, 3)
INSERT [dbo].[role] ([roleID], [roleName], [permissions]) VALUES (0, N'admin', NULL)
INSERT [dbo].[role] ([roleID], [roleName], [permissions]) VALUES (1, N'teacher', NULL)
INSERT [dbo].[role] ([roleID], [roleName], [permissions]) VALUES (2, N'student', NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (1, 999, NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (1, 10001, 95)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (1, 10002, 66)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (1, 10003, NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (1, 1234566, NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (2, 10001, 12)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (2, 10003, 99)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (4, 999, NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (4, 145321, NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (4, 1234566, NULL)
INSERT [dbo].[selectedcourse] ([courseID], [studentID], [mark]) VALUES (5, 10001, NULL)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (123, N'fudao2', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (999, N'修休息徐', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (1888, N'封封', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (10002, N'小米444', N'男', CAST(N'1995-09-14' AS Date), CAST(N'2015-09-02' AS Date), 3)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (10003, N'小陈', N'女', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 2)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (10005, N'小左', N'女', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 2)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (11122, N'小强', N'男', CAST(N'1995-04-05' AS Date), CAST(N'2019-01-15' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (12333, N'小陈', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (12341, N'哈哈哈哈', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (12345, N'小陈', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (21432, N'XIAOQIU', N'女', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (23333, N'fengliqiang', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (24561, N'小李', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (42321, N'小晨', N'女', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (145321, N'fengliqiang', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (199545, N'冯理强', N'男', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[student] ([userID], [userName], [sex], [birthYear], [grade], [collegeID]) VALUES (1234566, N'李丽丽', N'女', CAST(N'1996-09-02' AS Date), CAST(N'2015-09-02' AS Date), 3)
INSERT [dbo].[teacher] ([userID], [userName], [sex], [birthYear], [degree], [title], [grade], [collegeID]) VALUES (100, N'冯理强', N'男', CAST(N'1996-09-02' AS Date), N'本科', N'助教', CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[teacher] ([userID], [userName], [sex], [birthYear], [degree], [title], [grade], [collegeID]) VALUES (1001, N'刘老师33', N'男', CAST(N'1990-03-08' AS Date), N'硕士', N'副教授', CAST(N'2015-09-02' AS Date), 2)
INSERT [dbo].[teacher] ([userID], [userName], [sex], [birthYear], [degree], [title], [grade], [collegeID]) VALUES (1002, N'张老师', N'男', CAST(N'1996-09-02' AS Date), N'本科', N'普通教师', CAST(N'2015-09-02' AS Date), 1)
INSERT [dbo].[teacher] ([userID], [userName], [sex], [birthYear], [degree], [title], [grade], [collegeID]) VALUES (1003, N'软老师', N'男', CAST(N'1996-09-02' AS Date), N'硕士', N'助教', CAST(N'2017-07-07' AS Date), 1)
INSERT [dbo].[teacher] ([userID], [userName], [sex], [birthYear], [degree], [title], [grade], [collegeID]) VALUES (31321, N'疯54', N'男', CAST(N'1996-09-02' AS Date), N'硕士', N'助教', CAST(N'2015-09-02' AS Date), 1)
SET IDENTITY_INSERT [dbo].[userlogin] ON 

INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (1, N'admin', N'1234', 0)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (9, N'10002', N'199545', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (10, N'10003', N'199545', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (11, N'10005', N'123', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (14, N'1001', N'123', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (15, N'1002', N'123', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (16, N'1003', N'123', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (100, N'冯理强', N'123', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (123, N'fdsfssfs', N'123', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (12341, N'哈哈哈哈', N'123', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (21432, N'XIAOQIU', N'123', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (42321, N'小晨', N'123', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (42322, N'123', N'1234', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (145321, N'fengliqiang', N'199', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (145322, N'145321', N'111', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (199545, N'冯理强', N'111', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (199546, N'999', N'998', 2)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (199547, N'31321', N'111', 1)
INSERT [dbo].[userlogin] ([userID], [userName], [password], [role]) VALUES (199548, N'1234566', N'123', 2)
SET IDENTITY_INSERT [dbo].[userlogin] OFF
ALTER TABLE [dbo].[course] ADD  DEFAULT (NULL) FOR [courseTIme]
GO
ALTER TABLE [dbo].[course] ADD  DEFAULT (NULL) FOR [classRoom]
GO
ALTER TABLE [dbo].[course] ADD  DEFAULT (NULL) FOR [courseWeek]
GO
ALTER TABLE [dbo].[course] ADD  DEFAULT (NULL) FOR [courseType]
GO
ALTER TABLE [dbo].[role] ADD  DEFAULT (NULL) FOR [permissions]
GO
ALTER TABLE [dbo].[selectedcourse] ADD  DEFAULT (NULL) FOR [mark]
GO
ALTER TABLE [dbo].[student] ADD  DEFAULT (NULL) FOR [sex]
GO
ALTER TABLE [dbo].[student] ADD  DEFAULT (NULL) FOR [birthYear]
GO
ALTER TABLE [dbo].[student] ADD  DEFAULT (NULL) FOR [grade]
GO
ALTER TABLE [dbo].[teacher] ADD  DEFAULT (NULL) FOR [sex]
GO
ALTER TABLE [dbo].[teacher] ADD  DEFAULT (NULL) FOR [degree]
GO
ALTER TABLE [dbo].[teacher] ADD  DEFAULT (NULL) FOR [title]
GO
ALTER TABLE [dbo].[teacher] ADD  DEFAULT (NULL) FOR [grade]
GO
ALTER TABLE [dbo].[course]  WITH NOCHECK ADD  CONSTRAINT [FK_COURSE_COURSECOL_COLLEGE] FOREIGN KEY([collegeID])
REFERENCES [dbo].[college] ([collegeID])
GO
ALTER TABLE [dbo].[course] NOCHECK CONSTRAINT [FK_COURSE_COURSECOL_COLLEGE]
GO
ALTER TABLE [dbo].[course]  WITH NOCHECK ADD  CONSTRAINT [FK_COURSE_COURSETEA_TEACHER] FOREIGN KEY([teacherID])
REFERENCES [dbo].[teacher] ([userID])
GO
ALTER TABLE [dbo].[course] NOCHECK CONSTRAINT [FK_COURSE_COURSETEA_TEACHER]
GO
ALTER TABLE [dbo].[selectedcourse]  WITH NOCHECK ADD  CONSTRAINT [FK_SELECTED_SELECTEDC_COURSE] FOREIGN KEY([courseID])
REFERENCES [dbo].[course] ([courseID])
GO
ALTER TABLE [dbo].[selectedcourse] NOCHECK CONSTRAINT [FK_SELECTED_SELECTEDC_COURSE]
GO
ALTER TABLE [dbo].[selectedcourse]  WITH NOCHECK ADD  CONSTRAINT [FK_SELECTED_SELECTEDC_STUDENT] FOREIGN KEY([studentID])
REFERENCES [dbo].[student] ([userID])
GO
ALTER TABLE [dbo].[selectedcourse] NOCHECK CONSTRAINT [FK_SELECTED_SELECTEDC_STUDENT]
GO
ALTER TABLE [dbo].[student]  WITH NOCHECK ADD  CONSTRAINT [FK_STUDENT_STUDENTCO_COLLEGE] FOREIGN KEY([collegeID])
REFERENCES [dbo].[college] ([collegeID])
GO
ALTER TABLE [dbo].[student] NOCHECK CONSTRAINT [FK_STUDENT_STUDENTCO_COLLEGE]
GO
ALTER TABLE [dbo].[teacher]  WITH NOCHECK ADD  CONSTRAINT [FK_TEACHER_TEACHERCO_COLLEGE] FOREIGN KEY([collegeID])
REFERENCES [dbo].[college] ([collegeID])
GO
ALTER TABLE [dbo].[teacher] NOCHECK CONSTRAINT [FK_TEACHER_TEACHERCO_COLLEGE]
GO
ALTER TABLE [dbo].[userlogin]  WITH NOCHECK ADD  CONSTRAINT [FK_USERLOGI_USERLOGIN_ROLE] FOREIGN KEY([role])
REFERENCES [dbo].[role] ([roleID])
GO
ALTER TABLE [dbo].[userlogin] NOCHECK CONSTRAINT [FK_USERLOGI_USERLOGIN_ROLE]
GO
