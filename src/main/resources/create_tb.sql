DROP TABLE IF EXISTS tbl_dept;
CREATE TABLE tbl_dept(
	dept_id INTEGER(11) PRIMARY KEY auto_increment,
	dept_name VARCHAR(255) NOT NULL
);
DROP TABLE if EXISTS tbl_emp;
CREATE TABLE tbl_emp(
	emp_id INTEGER(11) PRIMARY KEY auto_increment,
	emp_name VARCHAR(255) NOT NULL,
	gender CHAR(1),
	email VARCHAR(255),
	d_id INTEGER(11)
-- 	CONSTRAINT emp_dept_fk FOREIGN KEY (d_id) references tbl_dept(dept_id)
);


Drop TABLE if EXISTS tbl_admin;
CREATE TABLE tbl_admin(
 admin_user_id INTEGER(11) PRIMARY KEY auto_increment,
 login_user_name VARCHAR(32) NOT NULL UNIQUE,
 login_user_password VARCHAR(32) NOT NULL,
 nick_name VARCHAR(32) NOT NULL  UNIQUE
);

-- 下面的SQL只能运行运行一次即可 目的是给 插入部门信息 和 管理员信息
-- INSERT INTO tbl_dept VALUES(NULL,'测试部'),(NULL,'开发部');
-- INSERT INTO tbl_admin VALUES(NULL,'admin','admin','admin')

