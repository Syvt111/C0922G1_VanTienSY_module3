package controller;

import model.User;
import service.IUserService;
import service.UserService;
import java.io.*;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "usersServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService=new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }  try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "find":
                    findUser(request, response);
                    break;
                case "sort":
                    sortUser(request, response);
                    break;
                case "testTransaction" :
                        testUseTran(request,response);
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException | ServletException ex) {
            try {
                throw new ServletException(ex);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.sortByName();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/sort.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void findUser(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> userList = userService.searchByCountry(country);
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/find.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);

        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request, response);
}

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit" :
                    updateUser(request, response);
                    break;
            }
        }
    }
    public void insertUser(HttpServletRequest request, HttpServletResponse response)  {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        try {
            userService.insertUser(newUser);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        try {
            userService.updateUser(book);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        try {
            dispatcher.forward(request, response) ;
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        try {
            userService.addUserTransaction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}