insert into Employee(id,name,delete_in) values(1,'Vin',0);
insert into Employee(id,name,delete_in) values(2,'Mah',1);

insert into Projects(id,project_name,employee_id) values(1,'Hlth',1);
insert into Projects(id,project_name,employee_id) values(2,'Dntl',1);
insert into Projects(id,project_name,employee_id) values(3,'Vsn',1);

insert into Projects(id,project_name,employee_id) values(4,'Fed',2);
insert into Projects(id,project_name,employee_id) values(5,'State',2);

insert into Sprints(id,sprint_no,projects_id) values(1,'Zero',1);
insert into Sprints(id,sprint_no,projects_id) values(2,'One',4);