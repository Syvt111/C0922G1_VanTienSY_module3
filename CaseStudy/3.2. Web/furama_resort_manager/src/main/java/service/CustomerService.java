package service;

import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.sql.SQLDataException;
import java.util.List;

public class CustomerService implements ICustomerService{

   ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public boolean insertUser(Customer customer) throws SQLDataException {
        return customerRepository.insertUser(customer);
    }

    @Override
    public Customer selectCustomer(int id) {

        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLDataException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLDataException {
        return customerRepository.updateCustomer(customer);
    }

}
