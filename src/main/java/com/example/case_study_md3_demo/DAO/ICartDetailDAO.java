package com.example.case_study_md3_demo.DAO;

import com.example.case_study_md3_demo.model.CartDetail;

import java.util.List;

public interface ICartDetailDAO extends IGenerateDAO<CartDetail> {
    List<CartDetail> sortPriceIn(int id);
    List<CartDetail> sortPriceDe(int id);
}
