package com.example.case_study_md3_demo.model;

public class Cart {
    private int id_cart;
    private Account account;
    private double total;

    public Cart(int id_cart, Account account, double total) {
        this.id_cart = id_cart;
        this.account = account;
        this.total = total;
    }

    public Cart(Account account, double total) {
        this.account = account;
        this.total = total;
    }
    public Cart(Account account) {
        this.account = account;
    }

    public Cart() {
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
