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
  <div class="row header bg-danger ">
    <div class="col-md-2">
      <a class="navbar-brand d-flex justify-content-between" href="/home.jsp"
         style="font-family: Broadway,serif">Furama</a>
    </div>
    <div class="col-md-8">

    </div>
    <div class="col-md-2 d-flex justify-content-center " style="margin-top: 35px; ">
      <a class="nav-link active d-flex justify-content-between" href="/furama/syvt">Van Tien Sy</a>
    </div>
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
            <a class="nav-link dropdown-toggle" href="/customer" role="button"
               data-bs-toggle="dropdown"
               aria-expanded="false">
              Customer
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/customer">Action</a></li>
              <li><a class="dropdown-item" href="/customer">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="/customer">Something else here</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link dropdown-toggle" href="/facility" role="button"
               data-bs-toggle="dropdown"
               aria-expanded="false">
              Service
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/facility">Action</a></li>
              <li><a class="dropdown-item" href="/facility">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="/facility">Something else here</a></li>
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
<div class="row body ">
  <div class="col-md-4 bg-light">
  </div>
  <h1 class="text-center my-3"> Sửa Dich Vụ </h1>
  <p>
    <a href="/facility">List All Facility</a>
  </p>
  <c:if test="${requestScope['mess'] != null}">
    <span style="color: red">${mess}</span>
  </c:if>
  <form action="/facility?action=edit" method="post">
    <table id="tableCustomer" class="table  table-striped table-bordered" style="width: 100%">
      <tr>
        <th>Mã Dịch Vụ</th>
        <td><input type="number" name="ma_dich_vu" id="ma_dich_vu" value="${requestScope['facility'].ma_dich_vu}"></td>
      </tr>
      <tr>
        <th>Tên Dịch Vụ</th>
        <td><input type="text"name="ten_dich_vu"id="ten_dich_vu"value="${requestScope['facility'].ten_dich_vu}"></td>
      </tr>
      <tr>
        <th>Diện Tích</th>
        <td>
          <input type="number" name="dien_tich" id="dien_tich"value="${requestScope['facility'].dien_tich}">
        </td>
      </tr>
      <tr>
        <th>Chi Phí Thuê</th>
        <td>
          <input type="number" name="chi_phi_thue"id="chi_phi_thue"value="${requestScope['facility'].chi_phi_thue}">
        </td>
      </tr>
      <tr>
        <th>Số Người Tối Đa</th>
        <td>
          <input type="number"name="so_nguoi_toi_da"id="so_nguoi_toi_da"value="${requestScope['facility'].so_nguoi_toi_da}">
        </td>
      </tr>
      <tr>
        <th>Mã Kiểu Thuê</th>
        <td>
          <input type="number"name="ma_kieu_thue"id="ma_kieu_thue"value="${requestScope['facility'].ma_kieu_thue}">
        </td>
      </tr>
      <tr>
        <th>Mã Loại Dịch Vụ</th>
        <td>
          <input type="number"name="ma_loai_dich_vu"id="ma_loai_dich_vu"value="${requestScope['facility'].ma_loai_dich_vu}">
        </td>
      </tr>
      <tr>
        <th>Tiêu Chuẩn Phòng</th>
        <td>
          <input type="text"name="tieu_chuan_phong"id="tieu_chuan_phong"value="${requestScope['facility'].tieu_chuan_phong}">
        </td>
      </tr>
      <tr>
        <th>MT Tiện Nghi Khác</th>
        <td>
          <input type="text"name="mo_ta_tien_nghi_khac"id="mo_ta_tien_nghi_khac"value="${requestScope['facility'].mo_ta_tien_nghi_khac}">
        </td>
      </tr>
      <tr>
        <th>Diện Tích Hồ Bơi</th>
        <td>
          <input type="number"name="dien_tich_ho_boi"id="dien_tich_ho_boi"value="${requestScope['facility'].dien_tich_ho_boi}">
        </td>
      </tr>
      <tr>
        <th>Số Tầng</th>
        <td>
          <input type="number"name="so_tang"id="so_tang"value="${requestScope['facility'].so_tang}">
        </td>
      </tr>
      <tr>
        <th>DV Miễn Phí Đi Kèm</th>
        <td>
          <input type="text"name="dich_vu_mien_phi_di_kem"id="dich_vu_mien_phi_di_kem"value="${requestScope['facility'].dich_vu_mien_phi_di_kem}">
        </td>
      </tr>
      <tr>
        <th colspan="2" align="center">
          <input  type="submit" value="Save">
        </th>
      </tr>
    </table>
  </form>

</div>
<div class="row footer">
  <a class="col d-flex justify-content-center">Footer</a>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</html>
