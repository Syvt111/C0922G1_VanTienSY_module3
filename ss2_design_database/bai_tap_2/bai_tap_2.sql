create database if not exists sales_management_database;
use sales_management_database;

create table customer(
cId int primary key ,
cNam varchar(45),
cAge varchar(45)
);

create table oder(
oId int primary key,
cId int ,
oDate datetime ,
oTotalPrince double,
foreign key(cId)references customer(cId)
);

create table product(
pId int primary key ,
pNam varchar(45),
pPrice double
);

create table oder_detail(
oId int,
pId int,
primary key(oId,pId),
odQTY int,
foreign key(oId)references oder(oId),
foreign key(pId) references product(pId)
);