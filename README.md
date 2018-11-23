# SpringMVCHibernate
Spring MVC + Hibernate + EhCache

This is demo project for Spring MVC and Hibernate with EhCache

-----------------------
Technology Used 
-----------------------
Spring 4
Hibernate 4
Oracle 11g
Maven 4

-----------------------
Installation Steps
-----------------------
1. Build the project
2. Execute the below query -

CREATE TABLE EMPLOYEE
   (	EMP_ID NUMBER NOT NULL ENABLE, 
	EMP_NAME VARCHAR2(2000 BYTE), 
	 CONSTRAINT EMPLOYEE_PK PRIMARY KEY (EMP_ID)
   );

CREATE SEQUENCE EMP_ID_SEQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
3. Update db.properties file

