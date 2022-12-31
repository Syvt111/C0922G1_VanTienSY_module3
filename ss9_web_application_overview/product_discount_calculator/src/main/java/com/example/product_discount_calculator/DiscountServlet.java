package com.example.product_discount_calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "discountServlet", value = "/calculate-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("Product_Description");
        double listPrice = Double.parseDouble(request.getParameter("List_Price"));
        double discountPercent = Double.parseDouble(request.getParameter("Discount_Percent"));
        double discountAmount = (listPrice * discountPercent) * 0.01;
        double discountPrice = listPrice - discountAmount;
        request.setAttribute("Product_Description", productDescription);
        request.setAttribute("List_Price", listPrice);
        request.setAttribute("Discount_Amount", discountAmount);
        request.setAttribute("Discount_Price", discountPrice);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);

    }

}