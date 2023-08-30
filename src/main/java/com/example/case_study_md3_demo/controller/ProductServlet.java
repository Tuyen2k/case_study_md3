package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.iplm.ProductManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductManage productManage = new ProductManage();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productManage.findAll();
        HttpSession session = request.getSession();
        if (!products.isEmpty()){
            session.setAttribute("products",products);
            response.sendRedirect("home_product.jsp");
        }
        else {
            boolean flag = true;
            session.setAttribute("message","There are no products");
            session.setAttribute("flag",flag);
            response.sendRedirect("home_product.jsp");
        }
    }

}