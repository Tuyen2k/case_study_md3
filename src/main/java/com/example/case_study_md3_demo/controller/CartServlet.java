package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.model.Cart;
import com.example.case_study_md3_demo.model.CartDetail;
import com.example.case_study_md3_demo.service.iplm.AccountManage;
import com.example.case_study_md3_demo.service.iplm.CartDetailManage;
import com.example.case_study_md3_demo.service.iplm.CartManage;

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

    @Override
    public void init() throws ServletException {
        accountManage = AccountManage.getAccountManage();
        cartManage = new CartManage();
        cartDetailManage = new CartDetailManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default: displayCart(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id_user");
        HttpSession session = request.getSession();
        if (!strId.equals("")){
            int id_account = Integer.parseInt(strId);
            Account account = accountManage.findById(id_account);
            Cart cart = cartManage.findByIdAccount(account.getId_account());
            List<CartDetail> cartDetails = cartDetailManage.findByIdCart(cart.getId_cart());
            double total = 0;
            for (CartDetail cartDetail : cartDetails){
                total += cartDetail.getTotal_product();
            }
            session.setAttribute("cartDetails", cartDetails);
            session.setAttribute("total", total);
            session.setAttribute("discount", total*0.05);
            response.sendRedirect("display_cart.jsp");
        }else {
            session.setAttribute("message","You need to log in to your account first!");
            session.setAttribute("flag",true);
            response.sendRedirect("products");
        }

    }

}