package com.example.bai_tap_2;
import modle.Calculator;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "calculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("firstOperand"));
        float secondOperand = Integer.parseInt(request.getParameter("secondOperand"));
        char operator = request.getParameter("operator").charAt(0);
        float result = Calculator.calculate(firstOperand, secondOperand, operator);

        request.setAttribute("FirstOperand", firstOperand);
        request.setAttribute("SecondOperand", secondOperand);
        request.setAttribute("Operator", operator);
        request.setAttribute("Result ", result);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);

    }

}