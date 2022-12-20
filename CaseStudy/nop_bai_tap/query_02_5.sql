create database if not exists furama_database;
use furama_database ;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT 
    *
FROM
    nhan_vien
WHERE
    (ho_ten LIKE 'H%' OR ho_ten LIKE 'T%'
        OR ho_ten LIKE 'K%')
        AND LENGTH(ho_ten) < 17;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    *
FROM
    khach_hang
WHERE
    ((YEAR(CURDATE()) - YEAR(ngay_sinh)) - (RIGHT(CURDATE(), 5) - RIGHT(ngay_sinh, 5)) >= 18
        AND (YEAR(CURDATE()) - YEAR(ngay_sinh)) - (RIGHT(CURDATE(), 5) - RIGHT(ngay_sinh, 5)) <= 50)
        AND (dia_chi LIKE '% Đà Nẵng'
        OR dia_chi LIKE '% Quảng Trị');
        
-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT 
    kh.ma_khach_hang,
    kh.ho_ten,
    COUNT(hd.ma_hop_dong) AS so_lan_dat_phong
FROM
    khach_hang kh
        JOIN
    hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
        JOIN
    loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE
    lk.ten_loai_khach_hang = 'Diamond'
GROUP BY kh.ma_khach_hang , hd.ma_khach_hang , kh.ho_ten
ORDER BY so_lan_dat_phong ASC;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT 

    kh.ma_khach_hang ,
    kh.ho_ten,
    lk.ten_loai_khach_hang,
    hd.ma_hop_dong,
    dv.ten_dich_vu,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    SUM(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) AS tong_tien
FROM
    
    loai_khach lk  
       left JOIN
    khach_hang kh ON kh.ma_loai_khach = lk.ma_loai_khach
       left JOIN
    hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
       left JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        left JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
       left  JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY kh.ma_khach_hang , kh.ho_ten , lk.ten_loai_khach_hang , hd.ma_hop_dong , dv.ten_dich_vu , hd.ngay_lam_hop_dong , hd.ngay_ket_thuc , hdct.ma_hop_dong_chi_tiet
;

