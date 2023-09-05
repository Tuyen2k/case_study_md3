package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.BillDAO;
import com.example.case_study_md3_demo.model.Bill;

public class BillManage {
    private BillDAO billDAO;
    public BillManage(){
        billDAO = new BillDAO();
    }
    public Bill findByCart(int id_cart){
        return billDAO.findById_cart(id_cart);
    }
    public void create (Bill bill){
        billDAO.create(bill);
    }
}
