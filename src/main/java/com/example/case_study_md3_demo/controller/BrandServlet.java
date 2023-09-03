package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.BrandDAO;
import com.example.case_study_md3_demo.model.Brand;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.service.iplm.BrandManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BrandServlet", value = "/brands")
public class BrandServlet extends HttpServlet {
    private BrandManage brandManage ;
    private BrandDAO brandDAO ;

    @Override
    public void init() throws ServletException {
        brandManage =new BrandManage();
        brandDAO =new BrandDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                displayBrand(request, response);
                break;
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
                postCreate(request,response);
                break;
            case "update":
                postUpdateBrand(request,response);
                break;

        }
    }
    private void displayBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Brand> brands = brandManage.findAll();
        HttpSession session = request.getSession();
        if (!brands.isEmpty()) {
            session.setAttribute("brands", brands);
            response.sendRedirect("home_brand.jsp");
        } else {
            boolean flag = true;
            session.setAttribute("message", "There are no brands!");
            session.setAttribute("flag", flag);
            response.sendRedirect("home_brand.jsp");
        }
    }

    private void postCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_brand");
        boolean isDuplicate = brandDAO.checkForDuplicates(name);
        if (isDuplicate) {
            response.getWriter().println("Data already exists. Cannot be added");
        } else {
        Brand brand = new Brand(name);
        brandManage.create(brand);
        response.sendRedirect("brands");
    }
    }
    private void postUpdateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_brand =Integer.parseInt( request.getParameter("id_brand"));
        String name =request.getParameter("name_brand");
        boolean isDuplicate = brandDAO.checkForDuplicates(name);
        if (isDuplicate) {
            response.getWriter().println("Dữ liệu đã tồn tại. Không thể thêm vào.");
        } else {
        Brand brand =new Brand(name);
        brand.setId_brand(id_brand);
        brandManage.update(brand);
        response.sendRedirect("brands");
    }
}
}
