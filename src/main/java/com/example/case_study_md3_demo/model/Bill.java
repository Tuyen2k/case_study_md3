package com.example.case_study_md3_demo.model;

import java.time.LocalDate;

public class Bill {
    private int id_bill;
    private int id_product; //--> lấy ra name product
    private double price;
    private int quantity;
    private double total_bill;
    private LocalDate timePurchase;

    public Bill() {
    }

    public Bill(int id_product, double price, int quantity, double total_bill, LocalDate timePurchase) {
        this.id_product = id_product;
        this.price = price;
        this.quantity = quantity;
        this.total_bill = total_bill;
        this.timePurchase = timePurchase;
    }

    public Bill(int id_bill, int id_product, double price, int quantity, double total_bill, LocalDate timePurchase) {
        this.id_bill = id_bill;
        this.id_product = id_product;
        this.price = price;
        this.quantity = quantity;
        this.total_bill = total_bill;
        this.timePurchase = timePurchase;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
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

    public double getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(double total_bill) {
        this.total_bill = total_bill;
    }

    public LocalDate getTimePurchase() {
        return timePurchase;
    }

    public void setTimePurchase(LocalDate timePurchase) {
        this.timePurchase = timePurchase;
    }
}
