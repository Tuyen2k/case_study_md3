package com.example.case_study_md3_demo.model;

public class CartDetail {
    private int id_cartDetail;
    private Cart cart;
    private Product product;
    private double price;
    private int quantity;
    private double total_product;

    public CartDetail(int id_cartDetail, Cart cart, Product product, double price, int quantity, double total_product) {
        this.id_cartDetail = id_cartDetail;
        this.cart = cart;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.total_product = total_product;
    }

    public CartDetail(Cart cart, Product product, double price, int quantity, double total_product) {
        this.cart = cart;
        this.product = product;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
