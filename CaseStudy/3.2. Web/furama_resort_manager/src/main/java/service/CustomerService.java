package service;

import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.sql.SQLDataException;
import java.util.List;

public class CustomerService implements ICustomerService{

   ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void insertUser(Customer customer) throws SQLDataException {
        customerRepository.insertUser(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
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
