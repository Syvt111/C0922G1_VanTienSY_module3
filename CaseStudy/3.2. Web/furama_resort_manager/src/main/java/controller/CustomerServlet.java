package controller;

import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.ICustomerService;
import service.ICustomerType;

import java.io.*;
import java.sql.SQLDataException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerType customerType = new service.CustomerType();
    String mess;

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
                showEditCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }

    }

    private void showAddNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerType.selectAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerType.selectAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);

        int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        Customer customer = customerService.selectCustomer(ma_khach_hang);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/editCustomer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
            default:
                listCustomer(request, response);
                break;
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        try {
            if (customerService.deleteCustomer(ma_khach_hang)){
                mess = "Xóa Thành Công";
            }else mess="Xóa Không Thành Công";
            request.setAttribute("mess",mess);

            List<Customer> customerList = customerService.selectAllCustomer();
            request.setAttribute("CustomerList", customerList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLDataException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertUser(HttpServletRequest request, HttpServletResponse response) {

        int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String ho_ten = request.getParameter("ho_ten");
        String ngay_sinh = request.getParameter("ngay_sinh");
        byte gioi_tinh = Byte.parseByte(request.getParameter("gioi_tinh"));
        String so_cmnd = request.getParameter("so_cmnd");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        Customer newCustomer = new Customer(ma_khach_hang, ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi);

        try {
            if (customerService.insertUser(newCustomer)) {
                mess = "Thêm mới thành công";
            } else mess = "Thêm mới không thành công";
            request.setAttribute(mess, "message");
            showAddNewForm(request, response);
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

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String ho_ten = request.getParameter("ho_ten");
        String ngay_sinh = request.getParameter("ngay_sinh");
        byte gioi_tinh = Byte.parseByte(request.getParameter("gioi_tinh"));
        String so_cmnd = request.getParameter("so_cmnd");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        Customer customer = new Customer(ma_khach_hang, ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi);
        try {
            if (customerService.updateCustomer(customer)) {
                mess = "Sửa thành công";
            } else mess = "Sửa không thành công";
            request.setAttribute("mess", mess);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/editCustomer.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
    }

}