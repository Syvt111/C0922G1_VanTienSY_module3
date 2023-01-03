package com.example.bai_tap_1;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Văn Tiến Sỹ", "01/11/1994", "Quảng Trị", "images/bcuo.jpg"));
        customerList.add(new Customer("Phạm Tiến", "8/9/1994", "Đà Nẵng", "images/con-trai-6-tuoi-cua-hotgirl-ly-kute-ngoan-ngoan-song-du-day-trong-can-ho-cao-cap-bo-la-dai-gia-co-nh-tinngan_051953_864935666_1-1663316160-342-width700height933.jpg"));
        customerList.add(new Customer("Thanh Thao", "12/10/1994", "Sài Gòn", "images/Cute-xinh.jpg"));
        customerList.add(new Customer("Hữu Tài", "4/12/1994", "Quảng Trị", "images/kute-puppy-my-neighbor-88642841.jpg"));

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }


}