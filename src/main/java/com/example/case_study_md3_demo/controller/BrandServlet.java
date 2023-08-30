package com.example.case_study_md3_demo.controller;

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

    @Override
    public void init() throws ServletException {
        brandManage =new BrandManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                getUpdateBrand(request,response);
                break;
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
            session.setAttribute("message", "There are no categories");
            session.setAttribute("flag", flag);
            response.sendRedirect("home_brand.jsp");
        }
    }

    public void postCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_brand");
        Brand brand = new Brand(name);
        brandManage.create(brand);
        response.sendRedirect("brands");
    }
    public void getUpdateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_brand = Integer.parseInt(request.getParameter("id_brand"));
        Brand brand = brandManage.findById(id_brand);
        request.setAttribute("brand", brand);
        RequestDispatcher rq = request.getRequestDispatcher("home_brand.jsp");
        rq.forward(request, response);
    }
    public void postUpdateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_brand =Integer.parseInt( request.getParameter("id_brand"));
        String name =request.getParameter("name_brand");
        Brand brand =new Brand(name);
        brand.setId_brand(id_brand);
        brandManage.update(brand);
        response.sendRedirect("brands");
    }
}
