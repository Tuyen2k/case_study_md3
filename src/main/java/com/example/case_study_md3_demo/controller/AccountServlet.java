package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.*;
import com.example.case_study_md3_demo.service.iplm.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    private AccountManage accountManage;
    private ProductManage productManage;
    private CategoryManage categoryManage;
    private BrandManage brandManage;
    private RoleManage roleManage;

    @Override
    public void init() throws ServletException {
        accountManage =AccountManage.getAccountManage();
        roleManage =new RoleManage();
        productManage = new ProductManage();
        categoryManage = CategoryManage.getCategoryManage();
        brandManage = BrandManage.getBrandManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register" :
                registerGet(request,response);
                break;
            default:
                loginGet(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginPost(request, response);
                break;
            case "create":
                registerPost(request,response);
                break;
        }
    }
    private void registerGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("signup.jsp");
    }

    private void registerPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        String phone = request.getParameter("phone");
        String email =request.getParameter("email");
        String address =request.getParameter("address");
        HttpSession session = request.getSession();
        if (password.equals(re_password)) {
            Role role = roleManage.findById(2);
            Account account = new Account(username, password, phone,email,address,role );
            accountManage.create(account);
            session.setAttribute("message", "Register success!");
            response.sendRedirect("login.jsp");
        } else {
            session.setAttribute("message", "Repeat your password not matching!");
            response.sendRedirect("accounts");
        }
    }
    private void loginGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");

    }

    private void loginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<Account> accounts = accountManage.findAll();
        Account userLogin = new Account();
        HttpSession session = request.getSession();
        for (Account account :accounts ) {
            if (account.getUsername().equals(username)
                    && account.getPassword().equals(password)) {
                userLogin = account;
                flag = true;
                break;
            }
        }
        if (flag) {
            session.setAttribute("message", "Login Success!");
            session.setAttribute("userLogin", userLogin);
            Role role = roleManage.findById(userLogin.getRole().getId_role());
            session.setAttribute("role", role);
            response.sendRedirect("products");
        } else {
            session.setAttribute("message", "Login Not Success!");
            response.sendRedirect("login.jsp");
        }
    }

}