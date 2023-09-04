package com.example.case_study_md3_demo.model;

public class Bill {
    private int id_bill;
    private Cart cart;
    private double total;

    public Bill(int id_bill, Cart cart, double total) {
        this.id_bill = id_bill;
        this.cart = cart;
        this.total = total;
    }

    public Bill(Cart cart, double total) {
        this.cart = cart;
        this.total = total;
    }

    public Bill() {
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
