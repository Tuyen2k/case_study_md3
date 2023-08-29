package com.example.case_study_md3_demo.service;

import java.util.List;

public interface IGenerateService<E>{
    List<E> findAll();
    E findById(int id);
    void create(E e);
    void update(E e);
}
