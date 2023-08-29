package com.example.case_study_md3_demo.model;

public class CartDetail {
    private int id_cartDetail;
    private int id_cart;
    private int id_product;
    private double price;
    private int quantity;
    private double total_product;

    public CartDetail(int id_cartDetail, int id_cart, int id_product, double price, int quantity, double total_product) {
        this.id_cartDetail = id_cartDetail;
        this.id_cart = id_cart;
        this.id_product = id_product;
        this.price = price;
        this.quantity = quantity;
        this.total_product = total_product;
    }

    public CartDetail(int id_cart, int id_product, double price, int quantity, double total_product) {
        this.id_cart = id_cart;
        this.id_product = id_product;
        this.price = price;
        this.quantity = quantity;
        this.total_product = total_product;
    }

    public CartDetail() {
    }

    public int getId_cartDetail() {
        return id_cartDetail;
    }

    public void setId_cartDetail(int id_cartDetail) {
        this.id_cartDetail = id_cartDetail;
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_product() {
        return total_product;
    }

    public void setTotal_product(double total_product) {
        this.total_product = total_product;
    }
}
