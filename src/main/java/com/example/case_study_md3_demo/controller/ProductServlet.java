package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.DAO.iplm.ProductDAO;
import com.example.case_study_md3_demo.model.Brand;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.iplm.BrandManage;
import com.example.case_study_md3_demo.service.iplm.CategoryManage;
import com.example.case_study_md3_demo.service.iplm.ProductManage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductManage productManage;
    private CategoryManage categoryManage;
    private BrandManage brandManage;

    @Override
    public void init() throws ServletException {
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
            case "display_one":
                displayOneProduct(request, response);
                break;
            case "home_product":
                 homeProduct(request, response);
                break;
            case "update_product":
                updateGet(request, response);
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
            case "create":
                create(request, response);
                break;
            case "update_product":
                update(request, response);
                break;
            default:
                displayProduct(request, response);
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

    private void homeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productManage.findAll();
        List<Category> categories = categoryManage.findAll();
        List<Brand> brands = brandManage.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        session.setAttribute("categories", categories);
        session.setAttribute("brands", brands);
        response.sendRedirect("test.jsp");
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double sale_price = Double.parseDouble(request.getParameter("sale_price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int id_category = Integer.parseInt(request.getParameter("category"));
        int id_brand = Integer.parseInt(request.getParameter("brand"));
        Category category = categoryManage.findById(id_category);
        Brand brand = brandManage.findById(id_brand);
        Product product = new Product(name,price,sale_price,quantity,description,image,1,category,brand);
        productManage.create(product);
        HttpSession session = request.getSession();
        session.setAttribute("message","Create product success!");
        response.sendRedirect("products?action=home_product");
    }
    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));
        Product product = productManage.findById(id);
        List<Category> categories = categoryManage.findAll();
        List<Brand> brands = brandManage.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("categories", categories);
        session.setAttribute("brands", brands);
        session.setAttribute("product",product);
        response.sendRedirect("update_product.jsp");
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double sale_price = Double.parseDouble(request.getParameter("sale_price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int id_category = Integer.parseInt(request.getParameter("category"));
        int id_brand = Integer.parseInt(request.getParameter("brand"));
        Category category = categoryManage.findById(id_category);
        Brand brand = brandManage.findById(id_brand);
        Product product = new Product(id,name,price,sale_price,quantity,description,image,1,category,brand);
        productManage.update(product);
        HttpSession session = request.getSession();
        session.setAttribute("message","Create product success!");
        response.sendRedirect("products?action=home_product");
    }
}