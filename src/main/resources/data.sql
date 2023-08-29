-- Organization
insert into organization(id, name) values(1, 'Org1');
insert into organization(id, name) values(2, 'Org2');
-- Department
insert into department(id, name, organization_id) values(1, 'ddd', 1);
insert into department(id, name, organization_id) values(2, 'ccc', 1);
insert into department(id, name, organization_id) values(3, 'bbb', 2);
insert into department(id, name, organization_id) values(4, 'aaa', 2);
-- Employee
insert into employee(id, name, position, salary, age, department_id, organization_id) values (1, 'Test1', 'Developer', 10000, 25, 1, 1);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (2, 'Test2', 'Developer', 18000, 35, 2, 1);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (3, 'Test3', 'Tester', 10000, 25, 3, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (4, 'Test4', 'Developer', 25000, 45, 1, 1);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (5, 'Test5', 'Architect', 30000, 40, 3, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (6, 'Test6', 'Manager', 20000, 40, 3, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (7, 'Test7', 'Manager', 30000, 40, 4, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (8, 'Test8', 'Architect', 25000, 40, 1, 1);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (9, 'Test9', 'Developer', 30000, 40, 3, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (10, 'Test10', 'Tester', 11000, 40, 3, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (11, 'Test11', 'Developer', 13000, 40, 4, 2);
insert into employee(id, name, position, salary, age, department_id, organization_id) values (12, 'Test12', 'Tester', 7000, 40, 4, 2);