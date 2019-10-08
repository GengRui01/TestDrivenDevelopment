# 建数据库
create DATABASE tdd;
use tdd;

# 建表
DROP TABLE IF EXISTS member;
CREATE TABLE member
(
	member_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	username VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	gender INT(1) NULL DEFAULT NULL COMMENT '性别',
	birthday DATE NULL DEFAULT NULL COMMENT '生日',
	PRIMARY KEY (member_id)
);

# 插入数据
INSERT INTO member (username, gender, birthday) VALUES
('Anne', 1, '2001-01-31'),
('Jack', 0, '1997-11-15'),
('Tom', 0, '1982-03-29'),
('Sandy', 1, '1993-08-07'),
('Billie', 1, '2008-04-06');