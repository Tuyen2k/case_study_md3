package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.CartDetailDAO;
import com.example.case_study_md3_demo.model.Cart;
import com.example.case_study_md3_demo.model.CartDetail;
import com.example.case_study_md3_demo.service.ICartDetailService;

import java.util.List;

public class CartDetailManage implements ICartDetailService {
    private CartDetailDAO cartDetailDAO;
    public CartDetailManage(){
        cartDetailDAO = new CartDetailDAO();
    }
    @Override
    public List<CartDetail> findAll() {
        return cartDetailDAO.findAll();
    }

    @Override
    public CartDetail findById(int id) {
        return cartDetailDAO.findById(id);
    }
    public CartDetail findByIdCart(int id_cart) {
        return cartDetailDAO.findByIdCart(id_cart);
    }
    public CartDetail findByIdProduct(int id_product) {
        return cartDetailDAO.findByIdProduct(id_product);
    }

    @Override
    public void create(CartDetail cartDetail) {
        cartDetailDAO.create(cartDetail);
    }

    @Override
    public void update(CartDetail cartDetail) {
        cartDetailDAO.update(cartDetail);
    }
}
