package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.DAO.iplm.ProductDAO;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.iplm.ProductManage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductManage productManage;

    @Override
    public void init() throws ServletException {
        productManage = new ProductManage();
    }

    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

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
            case "home_product":
                 homeProduct(request, response);
                break;
            default:
                displayProduct(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productDAO.findAll();
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);
    }

    private void displayOneProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        Product product = productDAO.findById(id_product);
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("product", product);
        request.setAttribute("categories", categories);
        RequestDispatcher rq = request.getRequestDispatcher("display_one_product.jsp");
        rq.forward(request, response);
    }

    private void homeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("home_product.jsp");
    }
}