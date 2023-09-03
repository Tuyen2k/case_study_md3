package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.model.Cart;
import com.example.case_study_md3_demo.model.CartDetail;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.iplm.AccountManage;
import com.example.case_study_md3_demo.service.iplm.CartDetailManage;
import com.example.case_study_md3_demo.service.iplm.CartManage;
import com.example.case_study_md3_demo.service.iplm.ProductManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/carts")
public class CartServlet extends HttpServlet {
    private AccountManage accountManage;
    private CartManage cartManage;
    private CartDetailManage cartDetailManage;
    private ProductManage productManage;

    @Override
    public void init() throws ServletException {
        accountManage = AccountManage.getAccountManage();
        cartManage = new CartManage();
        cartDetailManage = new CartDetailManage();
        productManage = new ProductManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "delete_product_in_cart":
                deleteInCart(request, response);
                break;
            case "update_product_in_cart":
                updateProductInCart(request, response);
                break;
            case "sort_in":
                sortPriceIn(request, response);
                break;
            case "sort_de":
                sortPriceDe(request, response);
                break;
            default:
                displayCart(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id_user");
        HttpSession session = request.getSession();
        if (!strId.equals("")) {
            int id_account = Integer.parseInt(strId);
            Account account = accountManage.findById(id_account);
            Cart cart = cartManage.findByIdAccount(account.getId_account());
            List<CartDetail> cartDetails = cartDetailManage.findByIdCart(cart.getId_cart());
            double total = 0;
            for (CartDetail cartDetail : cartDetails) {
                total += cartDetail.getTotal_product();
            }
            session.setAttribute("cartDetails", cartDetails);
            session.setAttribute("total", total);
            session.setAttribute("userLogin", account);
            session.setAttribute("discount", total * 0.05);
            response.sendRedirect("display_cart.jsp");
        } else {
            session.setAttribute("message", "You need to log in to your account first!");
            session.setAttribute("flag", true);
            response.sendRedirect("products");
        }

    }

    protected void deleteInCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id_cartDetail");
        if (strId != null) {
            int id_cartDetail = Integer.parseInt(strId);
            int id_account = Integer.parseInt(request.getParameter("id_user"));
            cartDetailManage.deleteCartDetail(id_cartDetail);
            request.setAttribute("message", "Delete success!");
            RequestDispatcher rq = request.getRequestDispatcher("carts?action=&&id_user" + id_account);
            rq.forward(request, response);
        }
    }

    protected void updateProductInCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id_cartDetail");
        if (strId != null) {
            int id_cartDetail = Integer.parseInt(strId);
            CartDetail cartDetail = cartDetailManage.findById(id_cartDetail);
            int id_account = Integer.parseInt(request.getParameter("id_user"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0) {
                cartDetailManage.deleteCartDetail(id_cartDetail);
                request.setAttribute("message", "Delete success!");
            } else {
                double total = cartDetail.getPrice() * quantity;
                cartDetail.setQuantity(quantity);
                cartDetail.setTotal_product(total);
                cartDetailManage.update(cartDetail);
                request.setAttribute("message", "Update success!");
            }
            RequestDispatcher rq = request.getRequestDispatcher("carts?action=&&id_user" + id_account);
            rq.forward(request, response);
        }
    }

    public void sortPriceIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_account = Integer.parseInt(request.getParameter("id_user"));
        Cart cart = cartManage.findByIdAccount(id_account);
        List<CartDetail> cartDetails = cartDetailManage.sortPriceIn(cart.getId_cart());
        Account account = accountManage.findById(id_account);
        HttpSession session = request.getSession();
        double total = 0;
        for (CartDetail cartDetail : cartDetails) {
            total += cartDetail.getTotal_product();
        }
        session.setAttribute("cartDetails", cartDetails);
        session.setAttribute("total", total);
        session.setAttribute("userLogin", account);
        session.setAttribute("discount", total * 0.05);
        response.sendRedirect("display_cart.jsp");
    }
    public void sortPriceDe(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_account = Integer.parseInt(request.getParameter("id_user"));
        Cart cart = cartManage.findByIdAccount(id_account);
        List<CartDetail> cartDetails = cartDetailManage.sortPriceDe(cart.getId_cart());
        Account account = accountManage.findById(id_account);
        HttpSession session = request.getSession();
        double total = 0;
        for (CartDetail cartDetail : cartDetails) {
            total += cartDetail.getTotal_product();
        }
        session.setAttribute("cartDetails", cartDetails);
        session.setAttribute("total", total);
        session.setAttribute("userLogin", account);
        session.setAttribute("discount", total * 0.05);
        response.sendRedirect("display_cart.jsp");
    }
}