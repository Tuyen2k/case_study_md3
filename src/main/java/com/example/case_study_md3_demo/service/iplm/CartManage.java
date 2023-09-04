package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.CartDAO;
import com.example.case_study_md3_demo.model.Cart;
import com.example.case_study_md3_demo.service.ICartService;

import java.util.List;

public class CartManage implements ICartService {
    private final CartDAO cartDAO;
    public CartManage(){
        cartDAO = new CartDAO();
    }

    @Override
    public List<Cart> findAll() {
        return cartDAO.findAll();
    }

    @Override
    public Cart findById(int id) {
        return cartDAO.findById(id);
    }
    public Cart findByIdAccount(int id_account) {
        return cartDAO.findByIdAccount(id_account);
    }

    @Override
    public void create(Cart cart) {
        cartDAO.create(cart);
    }

    @Override
    public void update(Cart cart) {
        cartDAO.update(cart);
    }
    public Cart findNewCart(){
        return cartDAO.findNewCart();
    }

}
