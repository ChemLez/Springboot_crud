DROP TABLE if EXISTS 'tbl_emp'
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
	d_id INTEGER(11),
	CONSTRAINT emp_dept_fk FOREIGN KEY (d_id) references tbl_dept(dept_id)
);

SELECT e.*,d.dept_id,dept_name
FROM tbl_emp e left join tbl_dept d
on e.d_id=d.dept_id

SELECT e.*,d.dept_id,dept_name
FROM tbl_emp e,tbl_dept d
WHERE e.d_id=d.dept_id
AND emp_id = 100


Drop TABLE if EXISTS tbl_admin;
CREATE TABLE tbl_admin(
 admin_user_id INTEGER(11) PRIMARY KEY auto_increment,
 login_user_name VARCHAR(32) NOT NULL UNIQUE,
 login_user_password VARCHAR(32) NOT NULL,
 nick_name VARCHAR(32) NOT NULL  UNIQUE
)


DELETE FROM  tbl_emp WHERE emp_id>2223;


	
	

