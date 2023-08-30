package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.IBrandDAO;
import com.example.case_study_md3_demo.DAO.iplm.BrandDAO;
import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.model.Brand;

import java.util.List;

public class BrandManage implements IBrandDAO {
    private BrandDAO brandDAO;
    private static BrandManage brandManage;

    public BrandManage() {
        brandDAO = new BrandDAO();
    }


    public static BrandManage getBrandManage() {
        if (brandManage == null) {
            brandManage = new BrandManage();
        }
        return brandManage;
    }

    @Override
    public List<Brand> findAll() {
        return brandDAO.findAll();
    }

    @Override
    public Brand findById(int id) {
        return brandDAO.findById(id);
    }

    @Override
    public void create(Brand brand) {
        brandDAO.create(brand);
    }

    @Override
    public void update(Brand brand) {
        brandDAO.update(brand);
    }
}
