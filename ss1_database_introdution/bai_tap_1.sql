create database if not exists student_management ;
use student_management ;
create table student(
id int primary key,
student_name varchar(45),
age int ,
country varchar(45)
) ;

create table class(
id int primary key,
class_name varchar(45)
);

create table teacher(
id int primary key,
teacher_name varchar(45),
age int,
country varchar(45)
) ;

insert into student values (1,'Sỹ',28,'Việt Nam');
insert into student values (2,'Tiến',28,'Japan');
insert into class values (1,'C0922g1');
insert into class values (2,'C0922g2');
insert into teacher values (1,'Công',32,'Việt Nam');
insert into teacher values (2,'Chánh',34,'Việt Nam');

select * from student ;
select * from class ;
select * from teacher ;
