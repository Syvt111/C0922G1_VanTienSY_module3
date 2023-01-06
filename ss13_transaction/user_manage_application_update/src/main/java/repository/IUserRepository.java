package repository;


import model.User;

import java.sql.SQLDataException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLDataException;

    User selectUser(int id);

    List<User> searchByCountry(String country);

    List<User> sortByName();

    List<User> showAllUsersByProcedure();

    boolean updateUserByProcedure(User user);

    boolean deleteUserByProcedure(int id);


}
