package repository;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static final String SELECT_ALL_CUSTOMER = "select * from khach_hang";
    private static final String SELECT_CUSTOMER_BY_ID = "select ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh," + "so_cmnd,so_dien_thoai,email,dia_chi from khach_hang where ma_khach_hang=?";
    private static final String INSERT_INTO_CUSTOMER = "insert into khach_hang(ma_khach_hang,ma_loai_khach,ho_ten," + "ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi)values(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_CUSTOMER = "update khach_hang set ma_loai_khach=?,ho_ten =?,ngay_sinh=?,gioi_tinh=?,so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=?where ma_khach_hang = ?";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from khach_hang where ma_khach_hang =?";

    @Override
    public boolean insertUser(Customer customer) throws SQLDataException {
        boolean check;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);

            preparedStatement.setInt(1, customer.getMa_khach_hang());
            preparedStatement.setInt(2, customer.getMa_loai_khach());
            preparedStatement.setString(3, customer.getHo_ten());
            preparedStatement.setString(4, customer.getNgay_sinh());
            preparedStatement.setByte(5, customer.getGioi_tinh());
            preparedStatement.setString(6, customer.getSo_cmnd());
            preparedStatement.setString(7, customer.getSo_dien_thoai());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getDia_chi());
            check = preparedStatement.executeUpdate() > 0;
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma_khach_hang = resultSet.getInt("ma_khach_hang");
                int ma_loai_khach = resultSet.getInt("ma_loai_khach");
                String ho_ten = resultSet.getString("ho_ten");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                byte gioi_tinh = Byte.parseByte(resultSet.getString("gioi_tinh"));
                String so_cmnd = resultSet.getString("so_cmnd");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String dia_chi = resultSet.getString("dia_chi");
                Customer customer = new Customer(ma_khach_hang, ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerList;
    }


    @Override
    public boolean updateCustomer(Customer customer) throws SQLDataException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getMa_loai_khach());
            preparedStatement.setString(2, customer.getHo_ten());
            preparedStatement.setString(3, customer.getNgay_sinh());
            preparedStatement.setByte(4, customer.getGioi_tinh());
            preparedStatement.setString(5, customer.getSo_cmnd());
            preparedStatement.setString(6, customer.getSo_dien_thoai());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getDia_chi());
            preparedStatement.setInt(9, customer.getMa_khach_hang());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCustomer(int ma_khach_hang) throws SQLDataException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, ma_khach_hang);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer selectCustomer(int ma_khach_hang) {
        Connection connection = BaseRepository.getConnectDB();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, ma_khach_hang);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma_loai_khach = resultSet.getInt("ma_loai_khach");
                String ho_ten = resultSet.getString("ho_ten");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                byte gioi_tinh = resultSet.getByte("gioi_tinh");
                String so_cmnd = resultSet.getString("so_cmnd");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String dia_chi = resultSet.getString("dia_chi");
                customer = new Customer(ma_khach_hang, ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }


}
