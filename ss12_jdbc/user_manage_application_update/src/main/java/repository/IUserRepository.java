package repository;

import model.User;

import java.sql.SQLDataException;
import java.util.List;

public interface IUserRepository {

    public void insertUser(User user) throws SQLDataException ;
    public User selectUser(int id);
    public List<User>selectAllUsers();
    public boolean deleteUser(int id) throws SQLDataException;
    public boolean updateUser(User user) throws SQLDataException;

}
