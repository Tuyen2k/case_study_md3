package com.example.case_study_md3_demo.model;

public class Cart {
    private int id_cart;
    private int id_account;
    private double total;

    public Cart(int id_cart, int id_account, double total) {
        this.id_cart = id_cart;
        this.id_account = id_account;
        this.total = total;
    }

    public Cart(int id_account, double total) {
        this.id_account = id_account;
        this.total = total;
    }

    public Cart() {
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
