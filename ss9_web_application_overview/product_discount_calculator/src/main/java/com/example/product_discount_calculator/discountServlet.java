package com.example.product_discount_calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "discountServlet", value = "/calculate-discount")
public class discountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("Product_Description") ;
        double listPrice = Double.parseDouble(request.getParameter("List_Price")) ;
        double discountPercent = Double.parseDouble(request.getParameter("Discount_Percent")) ;
        double discountAmount = (listPrice*discountPercent)*0.01 ;
        double discountPrice = listPrice - discountAmount ;
       request.setAttribute("Product_Description",productDescription);
       request.setAttribute("List_Price",listPrice);
       request.setAttribute("Discount_Amount",discountAmount);
       request.setAttribute("Discount_Price",discountPrice);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp") ;
        requestDispatcher.forward(request,response);
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Product Description: " + product_description + "</h1>");
//        writer.println("<h1>List Price: " + list_price + "</h1>");
//        writer.println("<h1>Discount Percent: " + discount_percent + "</h1>");
//        writer.println("<h1>Discount Amount: " + discount_amount + "</h1>");
//        writer.println("<h1>Discount Price: " + discount_price + "</h1>");
//        writer.println("</html>")
    }

}