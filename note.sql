select * from address_tbl

insert into address_tbl(id,city,state) values(1,'delehi','delhi');

insert into address_tbl(id,city,state) values(2,'delehi1','delhi1');
insert into address_tbl(id,city,state) values(3,'delehi2','delhi2');
insert into address_tbl(id,city,state) values(4,'delehi2','delhi2');
insert into address_tbl(id,city,state) values(5,'delehi2','delhi2');

select * from employee_tbl

insert into employee_tbl(id,age,email,name) values(1,'20','demo@gmail.com','harish');
insert into employee_tbl(id,age,email,name) values(2,'201','demo4@gmail.com','harish22');

insert into employee_tbl(id,age,email,name) values(3,'203','demo1@gmail.com','harish33');
insert into employee_tbl(id,age,email,name) values(4,'204','demo2@gmail.com','harish555');
insert into employee_tbl(id,age,email,name) values(5,'200','demo3@gmail.com','harish000');

SELECT ea.id,ea.city,ea.state FROM address_tbl ea join employee_tbl e
                    on e.id = ea.id where ea.id=2

