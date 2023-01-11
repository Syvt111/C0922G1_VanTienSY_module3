package service;

import repository.CustomerTypeRepository;
import repository.ICustomerTypeRepository;

import java.util.List;

public class CustomerType implements ICustomerType {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<model.CustomerType> selectAllCustomerType() {
        return customerTypeRepository.selectAllCustomerType() ;
    }
}
