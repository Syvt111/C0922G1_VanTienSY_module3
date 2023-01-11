package controller;

import model.Facility;
import service.FacilityService;
import service.IFacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    String mess;
    IFacilityService facilityService = new FacilityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFacility(request, response);
                break;
            case "edit":
                showEditFacility(request, response);
                break;
            default:
                listAllFacility(request, response);
                break;
        }

    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int ma_dich_vu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        if (facilityService.deleteFacility(ma_dich_vu)){
            mess = "Xóa Thành Công";
        }else mess = "Xóa Không Thành Công" ;

        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList",facilityList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/serviceList.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditFacility(HttpServletRequest request, HttpServletResponse response) {
        int ma_dich_vu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        Facility facility = facilityService.selectFacility(ma_dich_vu);
        request.setAttribute("facility",facility);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/editFacility.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateFacility(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/createFacility.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listAllFacility(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.selectAllFacility();
        request.setAttribute("facilityList", facilityList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/serviceList.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewFacility(request, response);
                break;
            case "edit":
                updateFacility(request, response);
                break;
            case "delete":
                deleteFacility(request,response);
                break;
            default:
                listAllFacility(request,response);
                break;
        }
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) {
        int ma_dich_vu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        String ten_dich_vu = request.getParameter("ten_dich_vu");
        int dien_tich = Integer.parseInt(request.getParameter("dien_tich"));
        double chi_phi_thue = Double.parseDouble(request.getParameter("chi_phi_thue"));
        int so_nguoi_toi_da = Integer.parseInt(request.getParameter("so_nguoi_toi_da"));
        int ma_kieu_thue = Integer.parseInt(request.getParameter("ma_kieu_thue"));
        int ma_loai_dich_vu = Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String tieu_chuan_phong = request.getParameter("tieu_chuan_phong");
        String mo_ta_tien_nghi_khac = request.getParameter("mo_ta_tien_nghi_khac");
        double dien_tich_ho_boi = Double.parseDouble(request.getParameter("dien_tich_ho_boi"));
        int so_tang = Integer.parseInt(request.getParameter("so_tang"));
        String dich_vu_mien_phi_di_kem = request.getParameter("dich_vu_mien_phi_di_kem");
        Facility facility = new Facility(ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue,
                ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem);
        if (facilityService.updateFacility(facility)){
            mess =" Sửa thành công" ;
        }else mess = "Sửa không thành công" ;
        request.setAttribute("mess",mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/editFacility.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNewFacility(HttpServletRequest request, HttpServletResponse response) {
        int ma_dich_vu = Integer.parseInt(request.getParameter("ma_dich_vu"));
        String ten_dich_vu = request.getParameter("ten_dich_vu");
        int dien_tich = Integer.parseInt(request.getParameter("dien_tich"));
        double chi_phi_thue = Double.parseDouble(request.getParameter("chi_phi_thue"));
        int so_nguoi_toi_da = Integer.parseInt(request.getParameter("so_nguoi_toi_da"));
        int ma_kieu_thue = Integer.parseInt(request.getParameter("ma_kieu_thue"));
        int ma_loai_dich_vu = Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String tieu_chuan_phong = request.getParameter("tieu_chuan_phong");
        String mo_ta_tien_nghi_khac = request.getParameter("mo_ta_tien_nghi_khac");
        double dien_tich_ho_boi = Double.parseDouble(request.getParameter("dien_tich_ho_boi"));
        int so_tang = Integer.parseInt(request.getParameter("so_tang"));
        String dich_vu_mien_phi_di_kem = request.getParameter("dich_vu_mien_phi_di_kem");
        Facility facility = new Facility(ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue,
                ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem);
        if (facilityService.insertFacility(facility)) {
            mess = "Thêm mới thành công";
        } else mess = "Thêm mới khoong thành công ";
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/createFacility.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }


    }

}
