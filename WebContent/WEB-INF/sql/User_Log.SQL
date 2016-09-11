USE Medical_Assistant_DB;

CREATE TABLE
IF NOT EXISTS User_Log (
	UserName VARCHAR (16) NOT NULL DEFAULT '' COMMENT '用户名(5到15位)',
	LastLoginTime datetime NULL DEFAULT '1900-01-01 00:00:00' COMMENT '上次登录时间',
	LoginIP text COMMENT '登录IP',
	SearchRecord text COMMENT '搜索内容',
	ChangePwdTime text COMMENT '修改密码时间',
	PRIMARY KEY (UserName)
)