package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.sql.SQLDataException;
import java.util.List;

public class UserService implements IUserService{
    IUserRepository iUserRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLDataException {
        iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserRepository.showAllUsersByProcedure();
    }

    @Override
    public boolean deleteUser(int id) throws SQLDataException {
        return iUserRepository.deleteUserByProcedure(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLDataException {
        return iUserRepository.updateUserByProcedure(user);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return iUserRepository.searchByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return iUserRepository.sortByName();
    }
}
