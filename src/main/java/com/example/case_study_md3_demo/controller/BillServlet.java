package com.example.case_study_md3_demo.controller;

import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.service.iplm.AccountManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BillServlet", value = "/bills")
public class BillServlet extends HttpServlet {
    private AccountManage accountManage;

    @Override
    public void init() throws ServletException {
        accountManage = AccountManage.getAccountManage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "pay":
                break;
            default: displayBill(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void displayBill(HttpServletRequest request, HttpServletResponse response){
        String strId = request.getParameter("id_user");
        if (!strId.equals("")){
            int id_user = Integer.parseInt(strId);
            Account account = accountManage.findById(id_user);

        }

    }
}