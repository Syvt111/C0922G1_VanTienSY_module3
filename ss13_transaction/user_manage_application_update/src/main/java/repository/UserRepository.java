package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/user_manage_database"; // sửa lại tên của csdl
    private static final String USER = "root";// mặc định của mysql
    private static final String PASS = "123456";// do cài đặt khi cài đặt mysql

    public static Connection getConnectDB() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static final String INSERT_USERS_SQL = "insert into users(name,email,country)values(?,?,?);";
    private static final String SELECT_USERS_BY_ID = "select id, name, email,country from users where id=?";
    private static final String SELECT_USER_BY_COUNTRY = "select id,name,email,country from users where country =?";
    private static final String SELECT_USERS_SORTED_BY_NAME = " select * from users order by name;";
    private static final String SHOW_USERS_BY_PROCEDURE = "call show_user_infomation_procedure()";
    private static final String UPDATE_USERS_BY_PROCEDURE = "call update_user_procedure(?,?,?,?)";
    private static final String DELETE_USERS_BY_PROCEDURE = "call delete_user_procedure(?)";


    @Override
    public void insertUser(User user) {
        Connection connection = getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = UserRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = getConnectDB();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                user = new User(id, name, email, country);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public List<User> sortByName() {
        User user;
        List<User> userList = new ArrayList<>();

        Connection connection = getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SORTED_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    @Override
    public List<User> showAllUsersByProcedure() {
        List<User> userList = new ArrayList<>();

        Connection connection = getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SHOW_USERS_BY_PROCEDURE);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public boolean updateUserByProcedure(User user) {
        Connection connection = getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_BY_PROCEDURE);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUserByProcedure(int id) {
        Connection connection = getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_USERS_BY_PROCEDURE);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String addUserTransaction() throws SQLException {
        String message = "OK, transaction successfully!";
        Connection connection = getConnectDB();
        Savepoint savepoint1 = null;
        Savepoint savepoint2 = null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement psUser = connection.prepareStatement("insert into users(name,email,country)values(?,?,?);");
            psUser.setString(1, "Owen");
            psUser.setString(2, "Owen@123");
            psUser.setString(3, "England");
            int rowUpdated = psUser.executeUpdate();
            savepoint1 = connection.setSavepoint();

            PreparedStatement psStaft = connection.prepareStatement("insert into staft(name)values(?);");
            psStaft.setString(1, "Jon");

            rowUpdated += psStaft.executeUpdate();
            savepoint2 = connection.setSavepoint();
            if (rowUpdated ==2){
                connection.commit();
            }else{
                message ="rollback try";
            }

        } catch (SQLException e) {

            message =  "rollback" ;
            try {
                connection.rollback(savepoint1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            connection.commit();
        }
        return message ;
    }

}
