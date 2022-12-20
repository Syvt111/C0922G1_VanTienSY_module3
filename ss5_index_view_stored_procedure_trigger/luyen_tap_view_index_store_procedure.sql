create database if not exists view_index_store_procedure;
use view_index_store_procedure;

CREATE TABLE products (
    id int auto_increment primary key,
    product_code VARCHAR(45),
    product_name VARCHAR(45),
    product_price DOUBLE,
    product_amount INT,
    product_description VARCHAR(45),
    product_status BIT
);

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status) values
('HTM123','car',1200,2,'vession 4, black',1),
('HTM124','truck',1800,5,'vession 2s, blue',0),
('HTM125','plane',70000,1,'helicopter, white',1),
('HTM126','bicle',500,15,'normal, black',1);

-- Tạo Unique Index trên bảng Products (sử dụng cột product_code để tạo chỉ mục)
create index unique_i_product_code on products(product_code);
-- drop index unique_i_product_code on products;

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột product_name và product_price)
create index composite_i_name_price on products(product_name,product_price);
-- drop index composite_i_name_price on products; 

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where product_name = 'car';

-- Tạo view lấy về các thông tin: product_code, product_name, product_price, product_status từ bảng products
create view v_products as select p.product_code, p.product_name, p.product_price, p.product_status from products p;
-- Sử dụng view 
select * from v_products ;
-- Cập nhật view
create or replace view v_products as
select  p.id, p.product_code, p.product_name, p.product_price from products p where p.product_name = 'bicle';
-- Sử dụng view 
select * from v_products ;
-- Xóa view
drop view v_products ;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_all_product()
begin 
select * from products ;
end //
delimiter ;

call get_all_product();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(in code varchar(45),in name varchar(45),in price double, in amount int , in description varchar(45), in status bit)
begin 
insert into products( product_code , product_name,product_price,product_amount,product_description,product_status)
value(code, name, price, amount, description, status) ;
end //
delimiter ;

call add_product('HTM127','moto',1000,15,'vip',1) ;


-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_product(in edit_id int,in code varchar(45),in name varchar(45),in price double, in amount int , in description varchar(45), in status bit )
begin 
update products 
set product_code = code , product_name = name,  product_price = price, product_amount = amount, product_description = description , product_status =  status
where id = edit_id ;
end //
delimiter ;

call edit_product(2,'HTM127','moto',1000,15,'vip',1 );

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product(in delete_id int)
begin 
delete from products where id = delete_id ;
end //
delimiter ;

call delete_product(2) ;


select * from products;


