package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.DAO.iplm.BillDetailDAO;
import com.example.case_study_md3_demo.model.*;
import com.example.case_study_md3_demo.service.iplm.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "BillServlet", value = "/bills")
public class BillServlet extends HttpServlet {
    private CartManage cartManage;
    private AccountManage accountManage;
    private CartDetailManage cartDetailManage;
    private BillManage billManage;
    private BillDetailManage billDetailManage;
    private ProductManage productManage;

    @Override
    public void init() throws ServletException {
        cartManage = new CartManage();
        cartDetailManage = new CartDetailManage();
        accountManage = AccountManage.getAccountManage();
        billManage = new BillManage();
        billDetailManage = new BillDetailManage();
        productManage = new ProductManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "pay":
                payBill(request, response);
                break;
            case "display_bill":
                displayBill(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void displayBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strId = request.getParameter("id_user");
        HttpSession session = request.getSession();
        if (!strId.equals("")) {
            int id_user = Integer.parseInt(strId);
            Account account = accountManage.findById(id_user);
            Cart cart = cartManage.findByIdAccount(id_user);
            List<CartDetail> cartDetails = cartDetailManage.findByIdCart(cart.getId_cart());
            if (!cartDetails.isEmpty()) {
                double total = 0;
                for (CartDetail cartDetail : cartDetails) {
                    total += cartDetail.getTotal_product();
                }
                session.setAttribute("total", total);
                session.setAttribute("userLogin", account);
                session.setAttribute("discount", total * 0.05);
                session.setAttribute("cart", cart);
                session.setAttribute("cartDetails", cartDetails);
                response.sendRedirect("display_bill.jsp");
            } else {
                session.setAttribute("flag", true);
                session.setAttribute("message", "Your shopping cart is empty. Please add product to cart!");
                response.sendRedirect("carts?action=&&id_user=" + strId);
            }

        }

    }

    private void payBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strId = request.getParameter("id_user");
        HttpSession session = request.getSession();
        if (!strId.equals("")) {
            int id_user = Integer.parseInt(strId);
            Account account = accountManage.findById(id_user);
            Cart cart = cartManage.findByIdAccount(id_user);
            // check bill, chưa có thì tạo bill mới
            // đẩy id_bill sang để tạo mới bill_detail
            // trừ số lượng của sản phẩm trong list và xóa sản phẩm khỏi cartDetail
            Bill bill = billManage.findByCart(cart.getId_cart());
            if (bill.getId_bill() == 0) {
                bill = new Bill(cart, 0);
                billManage.create(bill);
            }
            List<CartDetail> cartDetails = cartDetailManage.findByIdCart(cart.getId_cart());
            for (CartDetail cartDetail : cartDetails) {
                Product product = productManage.findById(cartDetail.getProduct().getId_product());
                billDetailManage.create(new BillDetail(product, bill, cartDetail.getPrice(), cartDetail.getQuantity(), cartDetail.getTotal_product() - (cartDetail.getTotal_product()*0.05), LocalDateTime.now()));
                product.setQuantity(product.getQuantity() - cartDetail.getQuantity());
                productManage.update(product);
                cartDetailManage.deleteCartDetail(cartDetail.getId_cartDetail());
            }
            session.setAttribute("message", "Payment success!");
            session.setAttribute("userLogin", account);
            response.sendRedirect("carts?action=&&id_user=" + strId);
        }
    }
}