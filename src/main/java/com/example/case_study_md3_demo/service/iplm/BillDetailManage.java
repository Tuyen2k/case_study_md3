package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.BillDetailDAO;
import com.example.case_study_md3_demo.model.BillDetail;

public class BillDetailManage {
    private BillDetailDAO billDetailDAO;
    public BillDetailManage(){
        billDetailDAO = new BillDetailDAO();
    }
    public void create(BillDetail billDetail){
        billDetailDAO.create(billDetail);
    }
}
