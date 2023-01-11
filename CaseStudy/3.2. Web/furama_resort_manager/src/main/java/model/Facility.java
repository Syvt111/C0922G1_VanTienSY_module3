package model;

public class Facility {
    private int ma_dich_vu;
    private String ten_dich_vu;
    private int dien_tich;
    private double chi_phi_thue;
    private int so_nguoi_toi_da;
    private int ma_kieu_thue;
    private int ma_loai_dich_vu;
    private String tieu_chuan_phong;
    private String mo_ta_tien_nghi_khac;
    private double dien_tich_ho_boi;
    private int so_tang;
    private String dich_vu_mien_phi_di_kem;


    public Facility() {
    }

    public Facility(int ma_dich_vu, String ten_dich_vu, int dien_tich, double chi_phi_thue, int so_nguoi_toi_da, int ma_kieu_thue,
                    int ma_loai_dich_vu, String tieu_chuan_phong, String mo_ta_tien_nghi_khac, double dien_tich_ho_boi, int so_tang,
                    String dich_vu_mien_phi_di_kem) {
        this.ma_dich_vu = ma_dich_vu;
        this.ten_dich_vu = ten_dich_vu;
        this.dien_tich = dien_tich;
        this.chi_phi_thue = chi_phi_thue;
        this.so_nguoi_toi_da = so_nguoi_toi_da;
        this.ma_kieu_thue = ma_kieu_thue;
        this.ma_loai_dich_vu = ma_loai_dich_vu;
        this.tieu_chuan_phong = tieu_chuan_phong;
        this.mo_ta_tien_nghi_khac = mo_ta_tien_nghi_khac;
        this.dien_tich_ho_boi = dien_tich_ho_boi;
        this.so_tang = so_tang;
        this.dich_vu_mien_phi_di_kem = dich_vu_mien_phi_di_kem;
    }

    public int getMa_dich_vu() {
        return ma_dich_vu;
    }

    public String getTen_dich_vu() {
        return ten_dich_vu;
    }

    public int getDien_tich() {
        return dien_tich;
    }

    public double getChi_phi_thue() {
        return chi_phi_thue;
    }

    public int getSo_nguoi_toi_da() {
        return so_nguoi_toi_da;
    }

    public int getMa_kieu_thue() {
        return ma_kieu_thue;
    }

    public int getMa_loai_dich_vu() {
        return ma_loai_dich_vu;
    }

    public String getTieu_chuan_phong() {
        return tieu_chuan_phong;
    }

    public String getMo_ta_tien_nghi_khac() {
        return mo_ta_tien_nghi_khac;
    }

    public double getDien_tich_ho_boi() {
        return dien_tich_ho_boi;
    }

    public int getSo_tang() {
        return so_tang;
    }

    public String getDich_vu_mien_phi_di_kem() {
        return dich_vu_mien_phi_di_kem;
    }

    public void setMa_dich_vu(int ma_dich_vu) {
        this.ma_dich_vu = ma_dich_vu;
    }

    public void setTen_dich_vu(String ten_dich_vu) {
        this.ten_dich_vu = ten_dich_vu;
    }

    public void setDien_tich(int dien_tich) {
        this.dien_tich = dien_tich;
    }

    public void setChi_phi_thue(double chi_phi_thue) {
        this.chi_phi_thue = chi_phi_thue;
    }

    public void setSo_nguoi_toi_da(int so_nguoi_toi_da) {
        this.so_nguoi_toi_da = so_nguoi_toi_da;
    }

    public void setMa_kieu_thue(int ma_kieu_thue) {
        this.ma_kieu_thue = ma_kieu_thue;
    }

    public void setMa_loai_dich_vu(int ma_loai_dich_vu) {
        this.ma_loai_dich_vu = ma_loai_dich_vu;
    }

    public void setTieu_chuan_phong(String tieu_chuan_phong) {
        this.tieu_chuan_phong = tieu_chuan_phong;
    }

    public void setMo_ta_tien_nghi_khac(String mo_ta_tien_nghi_khac) {
        this.mo_ta_tien_nghi_khac = mo_ta_tien_nghi_khac;
    }

    public void setDien_tich_ho_boi(double dien_tich_ho_boi) {
        this.dien_tich_ho_boi = dien_tich_ho_boi;
    }

    public void setSo_tang(int so_tang) {
        this.so_tang = so_tang;
    }

    public void setDich_vu_mien_phi_di_kem(String dich_vu_mien_phi_di_kem) {
        this.dich_vu_mien_phi_di_kem = dich_vu_mien_phi_di_kem;
    }
}
