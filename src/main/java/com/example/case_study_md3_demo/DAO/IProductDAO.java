package com.example.case_study_md3_demo.DAO;

import com.example.case_study_md3_demo.model.Product;

import java.util.List;

public interface IProductDAO extends IGenerateDAO<Product> {
    void delete(int id);
    List<Product> findProduct(String search);

    List<Product> findAllByCategory(int id);
    List<Product> findAllByBrand(int id);
}
