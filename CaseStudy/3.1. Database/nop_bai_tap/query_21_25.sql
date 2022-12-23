use furama_database ;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Nguyên Tất Thành” và 
-- đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “25/04/2021”
CREATE VIEW v_nhan_vien AS
    SELECT 
        nv.*, hd.ma_hop_dong, hd.ngay_lam_hop_dong
    FROM
        nhan_vien nv
            JOIN
        hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
    WHERE
        nv.dia_chi LIKE '%Yên Bái%'
            AND hd.ngay_lam_hop_dong = '2021/04/25' Chiểu”
--  đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này
set sql_safe_updates = 1 ;
UPDATE v_nhan_vien 
SET 
    dia_chi = 'Liên Chiểu'
WHERE
    dia_chi LIKE '%Yên Bái%';
SELECT 
    *
FROM
    v_nhan_vien;

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang 
-- được truyền vào như là 1 tham số của sp_xoa_khach_hang
delimiter //
create procedure sp_xoa_khach_hang(in maKhachHang int)
begin 
delete from khach_hang kh where kh.ma_khach_hang = maKhachHang ;
end //
delimiter  ;

SET FOREIGN_KEY_CHECKS=0 ;
call sp_xoa_khach_hang(10)

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong 
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và 
-- đảm bảo toàn vẹn tham chiếu đến các bảng liên quan

delimiter // 
create procedure sp_them_moi_hop_dong (in maHopDong INT,
    in ngayLamHopDong DATETIME,
    in ngayKetThuc DATETIME,
    in tienDatCoc DOUBLE,
   in maNhanVien INT,
   in maKhachHang INT,
   in maDichVu INT )
begin
if (
 maHopDong not in ( select hd.ma_hop_dong from hop_dong hd ) and
 maNhanVien in ( select nv.ma_nhan_vien from nhan_vien nv) and 
 maKhachHang in ( select kh.ma_khach_hang from khach_hang kh) and 
 maDichVu in (select dv.ma_dich_vu from dich_vu dv)) 
  then 
insert into hop_dong(ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
values (maHopDong, ngayLamHopDong, ngayKetThuc, tienDatCoc, maNhanVien, maKhachHang, maDichVu);
else signal sqlstate '45000' set message_text = 'Thông tin mã hợp đồng đã tồn tại ! '  ;
end if ;
end //
delimiter ;
call sp_them_moi_hop_dong ('13', '2020-12-01', '2020-12-09', '0', '3', '1', '3') ;

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại
--  có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

CREATE TABLE lich_su_xoa_hop_dong (
    ma_hop_dong_da_xoa INT,
    thoi_gian_xoa DATETIME,
    so_hop_dong_con_lai int 
);

DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong
    after DELETE
    ON hop_dong FOR EACH ROW 
BEGIN
    insert into lich_su_xoa_hop_dong(ma_hop_dong_da_xoa, thoi_gian_xoa, so_hop_dong_con_lai ) values
    (old.ma_hop_dong, now(), (select count(ma_hop_dong) from hop_dong));
END //

drop trigger tr_xoa_hop_dong ;
delete from hop_dong where ma_hop_dong = 6 ;
select * from lich_su_xoa_hop_dong ;
