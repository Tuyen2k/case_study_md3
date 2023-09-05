package com.example.case_study_md3_demo.controller;

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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductManage productManage;
    private CategoryManage categoryManage;
    private BrandManage brandManage;
    AccountManage accountManage;
    RoleManage roleManage;
    private CartManage cartManage;
    private CartDetailManage cartDetailManage;

    @Override
    public void init() throws ServletException {
        productManage = new ProductManage();
        accountManage = new AccountManage();
        categoryManage = CategoryManage.getCategoryManage();
        roleManage = new RoleManage();
        brandManage = BrandManage.getBrandManage();
        cartManage = new CartManage();
        cartDetailManage = new CartDetailManage();
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
            case "add_cart":
                addCart(request, response);
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
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int id_category = Integer.parseInt(request.getParameter("category"));
        int id_brand = Integer.parseInt(request.getParameter("brand"));
        Category category = categoryManage.findById(id_category);
        Brand brand = brandManage.findById(id_brand);
        Product product = new Product(id, name, price, sale_price, quantity, description, image, 1, category, brand);
        productManage.update(product);
        HttpSession session = request.getSession();
        session.setAttribute("message", "Create product success!");
        response.sendRedirect("products?action=home_product");
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

    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String strId = request.getParameter("id_user");
        if (!strId.equals("")) {
            int id_user = Integer.parseInt(strId);
            Account account = accountManage.findById(id_user);
            int id_product = Integer.parseInt(request.getParameter("id_product"));
            Product product = new Product();
            if (account != null) {
                product = productManage.findById(id_product);
                Cart cart = cartManage.findByIdAccount(account.getId_account());
                if (cart.getId_cart() == 0) {
                    cart = new Cart(account);
                    cartManage.create(cart);
                    cart = cartManage.findNewCart();
                }
                List<CartDetail> cartDetails = cartDetailManage.checkCart(cart.getId_cart());
                if (cartDetails.isEmpty()) {
                    double price = product.getSale_price();
                    double total = price * 1;
                    cart.setTotal(total);
                    CartDetail cartDetail = new CartDetail(cart, product, price, 1, total);
                    cartDetailManage.create(cartDetail);
                } else {
                    boolean flag = false;
                    CartDetail cartTemp = new CartDetail();
                    for (CartDetail cartDetail : cartDetails){
                        if (cartDetail.getProduct().getId_product() == product.getId_product()){
                            flag = true;
                            cartTemp = cartDetail;
                            break;
                        }
                    }
                    if (flag) {
                        int quantity = cartTemp.getQuantity() + 1;
                        double price = product.getSale_price();
                        double total = price * quantity;
                        cartTemp.setPrice(price);
                        cartTemp.setQuantity(quantity);
                        cartTemp.setTotal_product(total);
                        cartDetailManage.update(cartTemp);
                    } else {
                        double price = product.getSale_price();
                        double total = price * 1;
                        cartTemp = new CartDetail(cart, product, price, 1, total);
                        cartDetailManage.create(cartTemp);
                    }
                }
                session.setAttribute("flag", true);
                session.setAttribute("message", "Add to cart success!");
                response.sendRedirect("products");
            }
        } else {
            session.setAttribute("flag", true);
            session.setAttribute("confirm_user", "You need to log in to your account first!");
            response.sendRedirect("products");
        }

    }

    private boolean checkUser(int id_user) {
        boolean flag = false;
        List<Account> accounts = accountManage.findAll();
        for (Account account : accounts) {
            if (account.getId_account() == id_user) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}