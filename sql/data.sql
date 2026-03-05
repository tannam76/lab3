USE [school]
GO
/****** Object:  Table [dbo].[students]    Script Date: 3/5/2026 11:06:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[students](
	[id] [int] NOT NULL,
	[name] [nvarchar](100) NULL,
	[age] [int] NULL,
	[email] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[students] ([id], [name], [age], [email]) VALUES (0, N'', 0, N'')
INSERT [dbo].[students] ([id], [name], [age], [email]) VALUES (3, N'Lê Văn CF', 23, N'c36@gmail.com')
INSERT [dbo].[students] ([id], [name], [age], [email]) VALUES (33, N'sdcafs', 0, N'fff')
INSERT [dbo].[students] ([id], [name], [age], [email]) VALUES (363636, N'nam', 36, N'thanhoa')
GO
