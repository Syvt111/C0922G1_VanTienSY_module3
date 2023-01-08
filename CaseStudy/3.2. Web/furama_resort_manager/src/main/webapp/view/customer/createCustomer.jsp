<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 1/6/2023
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Furama Resort Manager</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<body>

<div class="row">
  <div class="row header bg-danger " style="height: 15%">
    <div class="col-md-2">
      <a class="navbar-brand d-flex justify-content-between" href="/furama"
         style="font-family: Broadway,serif">Furama</a>
    </div>
    <div class="col-md-8">

    </div>
    <div class="col-md-2 d-flex justify-content-center " style="margin-top: 35px; ">
      <a class="nav-link active d-flex justify-content-between" href="/furama/syvt">Van Tien Sy</a>
    </div>

  </div>
  <div class="row header-link ">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <div class="col-md-2 ms-3">
                <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="employee.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Employee
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="/furama" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Customer
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="service.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Service
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link dropdown-toggle" href="contract.jsp" role="button"
                 data-bs-toggle="dropdown"
                 aria-expanded="false">
                Contract
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          </form>
        </div>
      </div>
    </nav>
  </div>
  <div class="row body " style="height: 60%; padding: 2%">
    <div class="col-md-4 bg-light">
    </div>
    <h1 class="text-center my-3"> Thêm Mới Khách Hàng </h1>
    <p>
      <a href="customerList.jsp">List All Customer</a>
    </p>
    <form method="post">
      <table class="table table-striped">

        <tr>
          <th>Mã Loại Khách :</th>
          <td>
            <input type="text" name="ma_loai_khach" id="ma_loai_khach" />
          </td>
        </tr>
        <tr>
          <th>Họ Tên :</th>
          <td>
            <input type="text" name="ho_ten" id="ho_ten" />
          </td>
        </tr>
        <tr>
          <th>Ngày Sinh :</th>
          <td>
            <input type="text" name="ngay_sinh" id="ngay_sinh" s>
          </td>
        </tr> <tr>
          <th>Giới Tính :</th>
          <td>
            <input type="text" name="gioi_tinh" id="gioi_tinh" />
          </td>
        </tr></tr>
        <tr>
          <th>Số CMND :</th>
          <td>
            <input type="text" name="so_cmnd" id="so_cmnd" />
          </td>
        </tr> <tr>
          <th>Số Điện Thoại :</th>
          <td>
            <input type="text" name="so_dien_thoai" id="so_dien_thoai" />
          </td>
        </tr>
        <tr>
          <th>Email :</th>
          <td>
            <input type="text" name="email" id="email" />
          </td>
        </tr>
        <tr>
          <th>Địa Chỉ :</th>
          <td>
            <input type="text" name="dia_chi" id="dia_chi"/>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="Save"/>
          </td>
        </tr>
      </table>
    </form>

  </div>
  <div class="row footer ">
    <a class="col d-flex justify-content-center">Footer</a>
  </div>
</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>
