package repository;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static final String SELECT_ALL_CUSTOMER = "select * from khach_hang";
    private static final String INSERT_INTO_CUSTOMER = "insert into khach_hang(ma_khach_hang,ma_loai_khach,ho_ten," +
            "ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi)values(?,?,?,?,?,?,?,?,?)";

    @Override
    public void insertUser(Customer customer) throws SQLDataException {

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
            preparedStatement.setInt(1, customer.getMa_khach_hang());
            preparedStatement.setInt(2, customer.getMa_loai_khach());
            preparedStatement.setString(3, customer.getHo_ten());
            preparedStatement.setString(4, customer.getNgay_sinh());
            preparedStatement.setString(5, customer.getGioi_tinh());
            preparedStatement.setString(6, customer.getSo_cmnd());
            preparedStatement.setString(7, customer.getSo_dien_thoai());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getDia_chi());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>() ;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
         ResultSet resultSet = preparedStatement.executeQuery() ;
            while (resultSet.next()) {
                 int ma_khach_hang = resultSet.getInt("ma_khach_hang");
                 int ma_loai_khach = resultSet.getInt("ma_loai_khach");
                 String ho_ten = resultSet.getString("ho_ten");
                 String ngay_sinh = resultSet.getString("ngay_sinh");
                 String gioi_tinh = resultSet.getString("gioi_tinh") ;
                 String so_cmnd= resultSet.getString("so_cmnd");
                 String so_dien_thoai= resultSet.getString("so_dien_thoai");
                 String email= resultSet.getString("email");
                 String dia_chi= resultSet.getString("dia_chi");
                 Customer customer = new Customer(ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi) ;
                 customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerList ;
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }


    @Override
    public boolean deleteCustomer(int id) throws SQLDataException {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLDataException {
        return false;
    }

}
