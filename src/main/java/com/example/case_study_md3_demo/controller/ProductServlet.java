package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.iplm.ProductManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
private ProductManage productManage;
List<Product>products ;

    @Override
    public void init() throws ServletException {
        productManage =new ProductManage();
        products =new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       displayProductOne(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void  displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        products =productManage.findAll();
        request.setAttribute("products",products);
        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request,response);
    }
    public  void  displayProductOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product =productManage.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher rq = request.getRequestDispatcher("displayProductOne.jsp");
        rq.forward(request,response);

    }


}