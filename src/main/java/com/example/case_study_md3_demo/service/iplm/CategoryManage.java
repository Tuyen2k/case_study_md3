package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.CategoryDAO;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.service.ICategoryService;

import java.util.List;

public class CategoryManage implements ICategoryService {
    private CategoryDAO categoryDAO;
    private static CategoryManage categoryManage;

    public CategoryManage() {
        categoryDAO = new CategoryDAO();
    }

    public static CategoryManage getCategoryManage() {
        if (categoryManage == null) {
            categoryManage = new CategoryManage();
        }
        return categoryManage;
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public void create(Category category) {
        categoryDAO.create(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }
}
