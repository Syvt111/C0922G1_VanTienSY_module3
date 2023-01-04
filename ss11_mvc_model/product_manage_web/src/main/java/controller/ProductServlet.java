package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceImpl;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("Id"));
        String name = request.getParameter("Name") ;
        double price = Double.parseDouble(request.getParameter("Price"));
        String description = request.getParameter("Description");
        String maker = request.getParameter("Maker");

        Product product = new Product(id,name,price,description,maker);
        this.productService.createNewProduct(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp") ;
        request.setAttribute("message","New product was created");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("Id"));
        String name = request.getParameter("Name") ;
        double price = Double.parseDouble(request.getParameter("Price"));
        String description = request.getParameter("Description");
        String maker = request.getParameter("Maker");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setMaker(maker);
            this.productService.updateProduct(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher ;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.productService.deleteProduct(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productService.showAllProducts();
        request.setAttribute("products", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("view/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("view/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("view/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}