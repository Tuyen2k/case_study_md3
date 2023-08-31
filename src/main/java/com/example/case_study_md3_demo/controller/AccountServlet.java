package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.model.Role;
import com.example.case_study_md3_demo.service.iplm.AccountManage;
import com.example.case_study_md3_demo.service.iplm.RoleManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/accounts")
public class AccountServlet extends HttpServlet {
    private AccountManage accountManage;
    RoleManage roleManage;

    @Override
    public void init() throws ServletException {
        accountManage =AccountManage.getAccountManage();
        roleManage =new RoleManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                registerGet(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                registerPost(request, response);
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
            response.sendRedirect("products");
        } else {
            session.setAttribute("message", "Repeat your password not matching!");
            response.sendRedirect("accounts");
        }
    }
}