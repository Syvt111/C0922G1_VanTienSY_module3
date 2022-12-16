create database if not exists sales_management_database_ss3;
use sales_management_database_ss3;

create table customer(
c_id int primary key ,
c_name varchar(45),
c_age int
);

CREATE TABLE oder (
    o_id INT PRIMARY KEY,
    c_id INT,
    o_date DATETIME,
    o_total_price DOUBLE,
    FOREIGN KEY (c_id)
        REFERENCES customer (c_id)
);

create table product(
p_id int primary key ,
p_name varchar(45),
p_price double
);

create table oder_detail(
o_id int,
p_id int,
primary key(o_id,p_id),
od_qty int,
foreign key(o_id)references oder(o_id),
foreign key(p_id) references product(p_id)
);

insert into customer(c_id,c_name,c_age) value 
(1,"Minh Quan",10),
(2,"Ngoc Oanh",20),
(3,"Hong Ha",50);

insert into oder (o_id,c_id,o_date,o_total_price) value
 (1,1,"2006-03-21",null),
 (2,2,"2006-03-23",null),
 (3,1,"2006-03-16",null);

insert into product(p_id,p_name,p_price) value
(1,"May Giat",3),
(2,"Tu Lanh",5),
(3,"Dieu Hoa",7),
(4,"Quat",1),
(5,"Bep Dien",2) ;

insert into oder_detail(o_id,p_id,od_qty) value
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
 select oder.o_id, oder.o_date, oder.o_total_price from oder;     
 
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
 select oder.o_id, customer.c_id, customer.c_name, product.p_id, product.p_name, product.p_price
 from oder_detail
 inner join oder on oder_detail.o_id = oder.o_id
 inner join product on product.p_id = oder_detail.p_id
 inner join customer on oder.c_id = customer.c_id
 where customer.c_id in (select oder.c_id from oder)
 order by o_id
 ;     
 
 select * from customer;
 
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.c_name from customer c where c_id  not in (select oder.c_id from oder);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
select oder.o_id, oder.o_date, sum(oder_detail.od_qty * product.p_price) as oder_total_price
from oder_detail
join oder on oder_detail.o_id = oder.o_id
join product on product.p_id = oder_detail.p_id
join customer on customer.c_id = oder.c_id
group by o_id;



