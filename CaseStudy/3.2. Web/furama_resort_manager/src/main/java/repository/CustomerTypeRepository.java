package repository;

import model.Customer;
import model.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from loai_khach";

    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ma_loai_khach = resultSet.getInt("ma_loai_khach");
                String ten_loai_khach_hang = resultSet.getString("ten_loai_khach_hang");
                CustomerType customerType = new CustomerType(ma_loai_khach, ten_loai_khach_hang);
                customerTypeList.add(customerType);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerTypeList ;
    }
}
