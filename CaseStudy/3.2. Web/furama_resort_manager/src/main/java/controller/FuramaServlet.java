package controller;

import model.Customer;
import service.CustomerService;
import service.ICustomerService;

import java.io.*;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FuramaServlet", value = "/furama")
public class FuramaServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }

        switch (action) {
            case "create":
                showAddNewForm(request, response);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "find":

                break;
            case "sort":
                break;
            default:
                listCustomer(request, response);
                break;
        }

    }

    private void showAddNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("CustomerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                break;
        }

    }

    public void insertUser(HttpServletRequest request, HttpServletResponse response) {
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String ho_ten = request.getParameter("ho_ten");
        String ngay_sinh = request.getParameter("ngay_sinh");
        String gioi_tinh = request.getParameter("gioi_tinh");
        String so_cnmd = request.getParameter("so_cnmd");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        Customer newCustomer = new Customer(ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cnmd, so_dien_thoai, email, dia_chi);
        try {
            customerService.insertUser(newCustomer);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}