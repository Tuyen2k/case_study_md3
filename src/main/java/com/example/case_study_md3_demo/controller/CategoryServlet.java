package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.service.iplm.CategoryManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {
    private CategoryManage categoryManage;
    CategoryDAO categoryDAO ;


    @Override
    public void init() throws ServletException {
        categoryManage = CategoryManage.getCategoryManage();
        categoryDAO =new CategoryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                displayCategory(request, response);
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
                postCreate(request, response);
                break;
            case "update":
                postUpdateCategory(request, response);
                break;

        }
    }

    private void displayCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Category> categories = categoryManage.findAll();
        HttpSession session = request.getSession();
        if (!categories.isEmpty()) {
            session.setAttribute("categories", categories);
            response.sendRedirect("home_category.jsp");
        } else {
            boolean flag = true;
            session.setAttribute("message", "There are no categories");
            session.setAttribute("flag", flag);
            response.sendRedirect("home_category.jsp");
        }
    }

    public void postCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_category");
        boolean isDuplicate = categoryDAO.checkForDuplicates(name);
        if (isDuplicate) {
            response.getWriter().println("Dữ liệu đã tồn tại. Không thể thêm vào.");
        } else {
        Category category = new Category(name);
        categoryManage.create(category);
        response.sendRedirect("categories");
    }
    }

    private void postUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        String name = request.getParameter("name_category");
        Category category = new Category(name);
        category.setId_category(id_category);
        categoryManage.update(category);
        response.sendRedirect("categories");
    }
}