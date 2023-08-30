package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.ProductDAO;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.IProductService;

import java.util.List;

public class ProductManage implements IProductService {
    private final ProductDAO productDAO;

    public ProductManage() {
        productDAO =new ProductDAO();
    }

    @Override
    public List<Product> findAll() {
        return  productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }
}
