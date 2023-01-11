package repository;

import model.Facility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {


    @Override
    public List<Facility> selectAllFacility() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from dich_vu");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma_dich_vu = resultSet.getInt("ma_dich_vu");
                String ten_dich_vu = resultSet.getString("ten_dich_vu");
                int dien_tich = resultSet.getInt("dien_tich");
                double chi_phi_thue = resultSet.getDouble("chi_phi_thue");
                int so_nguoi_toi_da = resultSet.getInt("so_nguoi_toi_da");
                int ma_kieu_thue = resultSet.getInt("ma_kieu_thue");
                int ma_loai_dich_vu = resultSet.getInt("ma_loai_dich_vu");
                String tieu_chuan_phong = resultSet.getString("tieu_chuan_phong");
                String mo_ta_tien_nghi_khac = resultSet.getString("mo_ta_tien_nghi_khac");
                double dien_tich_ho_boi = resultSet.getDouble("dien_tich_ho_boi");
                int so_tang = resultSet.getInt("so_tang");
                String dich_vu_mien_phi_di_kem = resultSet.getString("dich_vu_mien_phi_di_kem");
                Facility facility = new Facility(ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue,
                        ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem);
                facilityList.add(facility);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facilityList;
    }

    @Override
    public Facility selectFacility(int ma_dich_vu) {
        Connection connection = BaseRepository.getConnectDB();
        Facility facility = null ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue," +
                    "ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,dich_vu_mien_phi_di_kem from dich_vu where ma_dich_vu = ?");
            preparedStatement.setInt(1, ma_dich_vu);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String ten_dich_vu = resultSet.getString("ten_dich_vu");
                int dien_tich = resultSet.getInt("dien_tich");
                double chi_phi_thue = resultSet.getDouble("chi_phi_thue");
                int so_nguoi_toi_da = resultSet.getInt("so_nguoi_toi_da");
                int ma_kieu_thue = resultSet.getInt("ma_kieu_thue");
                int ma_loai_dich_vu = resultSet.getInt("ma_loai_dich_vu");
                String tieu_chuan_phong = resultSet.getString("tieu_chuan_phong");
                String mo_ta_tien_nghi_khac = resultSet.getString("mo_ta_tien_nghi_khac");
                double dien_tich_ho_boi = resultSet.getDouble("dien_tich_ho_boi");
                int so_tang = resultSet.getInt("so_tang");
                String dich_vu_mien_phi_di_kem = resultSet.getString("dich_vu_mien_phi_di_kem");
                facility = new Facility(ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue,
                        ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facility;
    }

    @Override
    public boolean insertFacility(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into dich_vu(ma_dich_vu," +
                    " ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue,\n" +
                    "                        ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac," +
                    " dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem)values(?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, facility.getMa_dich_vu());
            preparedStatement.setString(2, facility.getTen_dich_vu());
            preparedStatement.setInt(3, facility.getDien_tich());
            preparedStatement.setDouble(4, facility.getChi_phi_thue());
            preparedStatement.setInt(5, facility.getSo_nguoi_toi_da());
            preparedStatement.setInt(6, facility.getMa_kieu_thue());
            preparedStatement.setInt(7, facility.getMa_loai_dich_vu());
            preparedStatement.setString(8, facility.getTieu_chuan_phong());
            preparedStatement.setString(9, facility.getMo_ta_tien_nghi_khac());
            preparedStatement.setDouble(10, facility.getDien_tich_ho_boi());
            preparedStatement.setInt(11, facility.getSo_tang());
            preparedStatement.setString(12, facility.getDich_vu_mien_phi_di_kem());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateFacility(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update dich_vu set ten_dich_vu = ?, dien_tich = ?, chi_phi_thue = ?, so_nguoi_toi_da = ?, ma_kieu_thue = ?, ma_loai_dich_vu = ?, " +
                    "tieu_chuan_phong = ?, mo_ta_tien_nghi_khac = ?, dien_tich_ho_boi = ?, so_tang = ?, dich_vu_mien_phi_di_kem = ? where ma_dich_vu = ?");
            preparedStatement.setString(1, facility.getTen_dich_vu());
            preparedStatement.setInt(2, facility.getDien_tich());
            preparedStatement.setDouble(3, facility.getChi_phi_thue());
            preparedStatement.setInt(4, facility.getSo_nguoi_toi_da());
            preparedStatement.setInt(5, facility.getMa_kieu_thue());
            preparedStatement.setInt(6, facility.getMa_loai_dich_vu());
            preparedStatement.setString(7, facility.getTieu_chuan_phong());
            preparedStatement.setString(8, facility.getMo_ta_tien_nghi_khac());
            preparedStatement.setDouble(9, facility.getDien_tich_ho_boi());
            preparedStatement.setInt(10, facility.getSo_tang());
            preparedStatement.setString(11, facility.getDich_vu_mien_phi_di_kem());
            preparedStatement.setInt(12, facility.getMa_dich_vu());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteFacility(int ma_dich_vu) {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from dich_vu where ma_dich_vu = ? ");
            preparedStatement.setInt(1,ma_dich_vu);
           return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
