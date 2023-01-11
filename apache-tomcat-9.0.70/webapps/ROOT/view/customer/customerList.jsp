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
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body>

<div class="row header ">
    <div class="row bg-danger ">
        <div class="col-md-2">
            <a class="navbar-brand d-flex justify-content-between" href="home.jsp"
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
<div class="row body bg-light ">
    <p class="text-center my-3">LIST CUSTOMER </p>
    <div>
        <button type="submit" class="btn btn-light" name="action" value="create"><a href="/customer?action=create">ADD NEW
            Customer</a></button>
    </div>
    <c:if test="${requestScope['mess'] != null}">
        <span style="color: red">${mess}</span>
    </c:if>
    <table id="tableCustomer" class="table  table-striped table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>Mã Khách Hàng</th>
            <th>Mã Loại Khách</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Giới Tính</th>
            <th>Số CMND</th>
            <th>Điện Thoại</th>
            <th>Email</th>
            <th>Địa Chỉ</th>
            <th></th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach var="customer" items="${CustomerList}">
            <th>${customer.ma_khach_hang}</th>
            <td>${customer.ma_loai_khach}</td>
            <td>${customer.ho_ten}</td>
            <td>${customer.ngay_sinh}</td>
            <c:if test="${customer.gioi_tinh==1}">
                <td>Nam</td>
            </c:if>
            <c:if test="${customer.gioi_tinh==0}">
                <td>Nữ</td>
            </c:if>
            <td>${customer.so_cmnd}</td>
            <td>${customer.so_dien_thoai}</td>
            <td>${customer.email}</td>
            <td>${customer.dia_chi}</td>
            <td>
                <button type="submit" class="btn btn-primary"><a style="color: #b6d4fe"
                                                                 href="/customer?action=edit&ma_khach_hang=${customer.ma_khach_hang}">EDIT</a>
                </button>
            </td>
            <td>
                <!-- Button trigger modal -->
                <button onclick="deleteCustomer('${customer.ma_khach_hang}','${customer.ho_ten}')" type="button"
                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteCustomer">
                    DELETE
                </button>
                <!-- Modal -->
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="modal fade" id="deleteCustomer" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <form action="/customer?action=delete" method="post" >
                    <div class="modal-body">
                        <input hidden type="text" id="deleteId" name="ma_khach_hang">
                        <span>You want delete Customer</span>
                        <span style="color:red;" id="deleteName"></span>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary"
                                data-bs-dismiss="modal">
                            Có
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Không</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <a class="col d-flex justify-content-center">Footer</a>
</div>


</body>
<script>
    function deleteCustomer(ma_khach_hang, ho_ten) {
        document.getElementById("deleteId").value = ma_khach_hang;
        document.getElementById("deleteName").innerText = ho_ten;
    }
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 7
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

</html>
