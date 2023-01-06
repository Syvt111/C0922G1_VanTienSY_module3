package repository;



import model.User;

import java.sql.SQLDataException;
import java.util.List;

public interface IUserRepository {
     void insertUser(User user) throws SQLDataException ;
     User selectUser(int id);
     List<User>selectAllUsers();
     boolean deleteUser(int id) throws SQLDataException;
     boolean updateUser(User user) throws SQLDataException;
    List<User> searchByCountry(String country);
    List<User> sortByName();


}
