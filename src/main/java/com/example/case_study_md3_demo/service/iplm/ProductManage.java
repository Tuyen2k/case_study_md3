package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.service.IProductService;
import com.example.case_study_md3_demo.DAO.IProductDAO;
import com.example.case_study_md3_demo.DAO.iplm.ProductDAO;

import java.util.List;

public class ProductManage implements IProductService {
    private ProductDAO productDAO;


    public ProductManage() {
        this.productDAO = new ProductDAO();
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }
    @Override
    public List<Product> findProduct(String search) {
        return productDAO.findProduct(search);
    }
    @Override
    public List<Product> findAllByCategory(int id) {
        return productDAO.findAllByCategory(id);
    }
    @Override
    public List<Product> findAllByBrand(int id) {
        return productDAO.findAllByBrand(id);
    }
    public List<Product> sortByProductDecrease() {
        return  productDAO.sortByProductDecrease();

    }
    public List<Product> sortByProductAscending() {
        return productDAO.sortByProductAscending();
    }
}