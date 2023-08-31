package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.DAO.iplm.ProductDAO;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.model.Role;
import com.example.case_study_md3_demo.service.iplm.AccountManage;
import com.example.case_study_md3_demo.service.iplm.CategoryManage;
import com.example.case_study_md3_demo.service.iplm.ProductManage;
import com.example.case_study_md3_demo.service.iplm.RoleManage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductManage productManage;
   private CategoryManage categoryManage;
    AccountManage accountManage;
    RoleManage roleManage ;

    @Override
    public void init() throws ServletException {
        productManage = new ProductManage();
        accountManage =new AccountManage();
        categoryManage =new CategoryManage();
        roleManage = new RoleManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "display_one":
                displayOneProduct(request, response);
                break;

            default:
                displayProduct(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {


    }
    }



    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productManage.findAll();
        List<Category> categories = categoryManage.findAll();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);
    }

    private void displayOneProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        Product product = productManage.findById(id_product);
        List<Category> categories = categoryManage.findAll();
        request.setAttribute("product", product);
        request.setAttribute("categories", categories);
        RequestDispatcher rq = request.getRequestDispatcher("display_one_product.jsp");
        rq.forward(request, response);
    }


}