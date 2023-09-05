package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.DAO.iplm.ProductDAO;
import com.example.case_study_md3_demo.model.*;
import com.example.case_study_md3_demo.service.iplm.*;

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
    AccountManage accountManage;
    RoleManage roleManage;

    @Override
    public void init() throws ServletException {
        productManage = new ProductManage();
        accountManage = new AccountManage();
        categoryManage = CategoryManage.getCategoryManage();
        roleManage = new RoleManage();
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
            case "display_by_category":
                displayByCategory(request, response);
                break;
            case "display_by_brand":
                displayByBrand(request, response);
                break;
            case "home_product":
                homeProduct(request, response);
                break;
            case "update_product":
                updateGet(request, response);
                break;
            case "delete_product":
                delete(request, response);
                break;
            case "sort_price":
                sortByPrice(request, response);
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
            case "find_product":
                findProduct(request, response);
                break;
            default:
                displayProduct(request, response);
        }
    }


    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productManage.findAll();
        List<Category> categories = categoryManage.findAll();
        List<Brand> brands = brandManage.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        session.setAttribute("categories", categories);
        session.setAttribute("brands", brands);
        response.sendRedirect("display_product.jsp");
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
        response.sendRedirect("home_product.jsp");
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
        Product product = new Product(name, price, sale_price, quantity, description, image, 1, category, brand);
        productManage.create(product);
        HttpSession session = request.getSession();
        session.setAttribute("message", "Create product success!");
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
        session.setAttribute("product", product);
        response.sendRedirect("update_product.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double sale_price = Double.parseDouble(request.getParameter("sale_price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        if (quantity > 0) {
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            int id_category = Integer.parseInt(request.getParameter("category"));
            int id_brand = Integer.parseInt(request.getParameter("brand"));
            Category category = categoryManage.findById(id_category);
            Brand brand = brandManage.findById(id_brand);
            Product product = new Product(id, name, price, sale_price, quantity, description, image, 1, category, brand);
            productManage.update(product);
            session.setAttribute("message", "Create product success!");
            response.sendRedirect("products?action=home_product");
        }
        else {
            productManage.delete(id);
            session.setAttribute("message", "The product has been deleted!");
            response.sendRedirect("products?action=home_product");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));
        productManage.delete(id);
        HttpSession session = request.getSession();
        session.setAttribute("message", "Delete success!");
        response.sendRedirect("products?action=home_product");
    }

    private void displayByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id_category"));

        List<Product> products = productManage.findAllByCategory(categoryId);
        List<Category> categories = categoryManage .findAll();
        List<Brand> brands = brandManage.findAll();

        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);

        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);
    }

    private void displayByBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int brandId= Integer.parseInt(request.getParameter("id_brand"));

        List<Product> products = productManage.findAllByBrand(brandId);
        List<Category> categories = categoryManage .findAll();
        List<Brand> brands = brandManage.findAll();

        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);

        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);
    }

    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        List<Product> products = productManage.findProduct(keyword);
        List<Category> categories = categoryManage.findAll();
        List<Brand> brands = brandManage.findAll();

        request.setAttribute("products", products);
        request.setAttribute("category", categories);
        request.setAttribute("brands", brands);

        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);
    }
    private void sortByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strValue = request.getParameter("value");
        if (strValue.equals("in")){
            List<Product>products = productManage.sortByProductDecrease();
            request.setAttribute("products", products);
        } else if (strValue.equals("de")){
            List<Product>products = productManage.sortByProductAscending();
            request.setAttribute("products", products);
        }
        List<Category> categories = categoryManage.findAll();
        List<Brand> brands = brandManage.findAll();
        request.setAttribute("category", categories);
        request.setAttribute("brands", brands);
        RequestDispatcher rq = request.getRequestDispatcher("display_product.jsp");
        rq.forward(request, response);

    }

}