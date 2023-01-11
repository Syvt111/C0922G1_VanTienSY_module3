package service;

import model.Customer;

import java.sql.SQLDataException;
import java.util.List;

public interface ICustomerService {
    boolean insertUser(Customer customer) throws SQLDataException;
    Customer selectCustomer(int id);
    List<Customer> selectAllCustomer();
    boolean deleteCustomer(int id) throws SQLDataException;
    boolean updateCustomer(Customer customer) throws SQLDataException;
}
