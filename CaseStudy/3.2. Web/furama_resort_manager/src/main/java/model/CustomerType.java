package model;

public class CustomerType {
    private int ma_loai_khach ;
    private String ten_loai_khach_hang;

    public CustomerType(int ma_loai_khach, String ma_loai_khach_hang) {
        this.ma_loai_khach = ma_loai_khach;
        this.ten_loai_khach_hang = ma_loai_khach_hang;
    }

    public int getMa_loai_khach() {
        return ma_loai_khach;
    }

    public String getTen_loai_khach_hang() {
        return ten_loai_khach_hang;
    }

    public void setMa_loai_khach(int ma_loai_khach) {
        this.ma_loai_khach = ma_loai_khach;
    }

    public void setTen_loai_khach_hang(String ten_loai_khach_hang) {
        this.ten_loai_khach_hang = ten_loai_khach_hang;
    }
}
