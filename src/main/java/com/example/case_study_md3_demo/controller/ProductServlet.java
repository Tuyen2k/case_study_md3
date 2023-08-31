package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.model.Role;
import com.example.case_study_md3_demo.service.iplm.AccountManage;
import com.example.case_study_md3_demo.service.iplm.ProductManage;
import com.example.case_study_md3_demo.service.iplm.RoleManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductManage productManage;
    List<Product> products;
    AccountManage accountManage;
    RoleManage roleManage ;

    @Override
    public void init() throws ServletException {
        productManage = new ProductManage();
        products = new ArrayList<>();
        accountManage =new AccountManage();
        roleManage = new RoleManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        displayProductOne(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        products = productManage.findAll();
        request.setAttribute("products", products);
        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);
    }

    public void displayProductOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productManage.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher rq = request.getRequestDispatcher("displayProductOne.jsp");
        rq.forward(request, response);

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
            response.sendRedirect("products?action=login");
        }
    }
}