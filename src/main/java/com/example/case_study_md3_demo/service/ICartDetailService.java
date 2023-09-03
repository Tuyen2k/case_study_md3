package com.example.case_study_md3_demo.service;

import com.example.case_study_md3_demo.model.CartDetail;

import java.util.List;

public interface ICartDetailService extends IGenerateService<CartDetail> {
    List<CartDetail> sortPriceIn(int id);
    List<CartDetail> sortPriceDe(int id);
}
