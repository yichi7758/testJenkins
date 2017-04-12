
CREATE TABLE COMPANY (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE DEPARTMENT (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE PERSON (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  birthday DATE,
  gender TINYINT,
  phone VARCHAR(255),
  company_id INTEGER,
  department_id INTEGER,
  FOREIGN KEY (company_id) REFERENCES COMPANY(id),
  FOREIGN KEY (department_id) REFERENCES DEPARTMENT(id)
);



/*
CREATE TABLE REF_COMPANY_PERSON (
  company_id INTEGER NOT NULL,
  person_id INTEGER NOT NULL,
  FOREIGN KEY (company_id) REFERENCES COMPANY(id),
  FOREIGN KEY (person_id) REFERENCES PERSON(id)
);
*/

INSERT INTO COMPANY(id, name) values(1, 'lenovo');
INSERT INTO COMPANY(id, name) values(2, 'huawei');
INSERT INTO COMPANY(id, name) values(3, 'neusoft');
INSERT INTO COMPANY(id, name) values(4, 'chinasoft');
INSERT INTO COMPANY(id, name) values(5, 'inspur');
INSERT INTO COMPANY(id, name) values(6, 'hasee');

INSERT INTO DEPARTMENT(id, name) values(1, 'finance');
INSERT INTO DEPARTMENT(id, name) values(2, 'enterprise');
INSERT INTO DEPARTMENT(id, name) values(3, 'market');
INSERT INTO DEPARTMENT(id, name) values(4, 'development');
INSERT INTO DEPARTMENT(id, name) values(5, 'test');
INSERT INTO DEPARTMENT(id, name) values(6, 'maintain');

INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(1, 'zhangsan', '1985-01-01', 0, '00000000001', 1, 1);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(2, 'wangsi', '1984-02-01', 0, '00000000002', 1, 2);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(3, 'songwu', '1987-03-01', 0, '00000000003', 2, 3);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(4, 'wangliu', '1976-04-01', 0, '00000000004', 2, 4);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(5, 'liqi', '1985-05-01', 1, '00000000005', 3, 2);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(6, 'chenba', '1975-06-01', 1, '00000000006', 4, 3);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(7, 'wangjiu', '1985-07-01', 1, '00000000007', 5, 5);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(8, 'zhangyier', '1985-01-01', 0, '00000000008', 1, 1);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(9, 'wangsiwu', '1994-02-01', 0, '00000000009', 1, 2);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(10, 'songwuliu', '1977-03-01', 0, '00000000010', 2, 3);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(11, 'wangliuqi', '1976-04-01', 0, '00000000011', 2, 4);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(12, 'liqiba', '1995-05-01', 1, '00000000012', 3, 2);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(13, 'chensan', '1985-06-01', 1, '00000000013', 4, 3);
INSERT INTO PERSON(id, name, birthday, gender, phone, company_id, department_id) values(14, 'wangerjiu', '1975-07-01', 1, '00000000014', 5, 5);