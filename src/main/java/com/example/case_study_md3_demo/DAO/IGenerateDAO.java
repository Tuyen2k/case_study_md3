package com.example.case_study_md3_demo.DAO;

import java.util.List;

public interface IGenerateDAO<E>{
    List<E> findAll();
    E findById(int id);
    void create(E e);
    void update(E e);

}
