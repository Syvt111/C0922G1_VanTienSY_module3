package service;

import model.User;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user) throws SQLDataException;
    public User selectUser(int id);
    public List<User> selectAllUsers();
    public boolean deleteUser(int id) throws SQLDataException;
    public boolean updateUser(User user) throws SQLDataException;
    List<User> searchByCountry(String country);
    List<User> sortByName();
    String addUserTransaction() throws SQLException;
}
