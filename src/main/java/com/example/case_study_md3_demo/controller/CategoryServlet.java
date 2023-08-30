package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.service.iplm.CategoryManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {
    private CategoryManage categoryManage;

    @Override
    public void init() throws ServletException {
        categoryManage = CategoryManage.getCategoryManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                getUpdateCategory(request,response);
                break;
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
                postCreate(request,response);
                break;
            case "update":
                postUpdateCategory(request,response);
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
        Category category = new Category(name);
        categoryManage.create(category);
        response.sendRedirect("categories");
    }
    public void getUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        Category category = categoryManage.findById(id_category);
        request.setAttribute("category", category);
        RequestDispatcher rq = request.getRequestDispatcher("home_category.jsp");
        rq.forward(request, response);
}
    public void postUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_category =Integer.parseInt( request.getParameter("id_category"));
        String name =request.getParameter("name_category");
        Category category =new Category(name);
        category.setId_category(id_category);
        categoryManage.update(category);
        response.sendRedirect("categories");
    }
}