package com.example.case_study_md3_demo.DAO;

import com.example.case_study_md3_demo.model.Product;

public interface IProductDAO extends IGenerateDAO<Product> {
    void delete(int id);
}
