package com.example.case_study_md3_demo.model;

import java.time.LocalDate;

public class BillDetail {
    private int id_billDetail;
    private Product product; //--> lấy ra name product
    private Bill bill;
    private double price;
    private int quantity;
    private double total_bill;
    private LocalDate timePurchase;

    public BillDetail() {
    }

    public BillDetail(Product product, Bill bill, double price, int quantity, double total_bill, LocalDate timePurchase) {
        this.product = product;
        this.bill = bill;
        this.price = price;
        this.quantity = quantity;
        this.total_bill = total_bill;
        this.timePurchase = timePurchase;
    }

    public BillDetail(int id_billDetail, Product product, Bill bill, double price, int quantity, double total_bill, LocalDate timePurchase) {
        this.id_billDetail = id_billDetail;
        this.product = product;
        this.bill = bill;
        this.price = price;
        this.quantity = quantity;
        this.total_bill = total_bill;
        this.timePurchase = timePurchase;
    }

    public int getId_billDetail() {
        return id_billDetail;
    }

    public void setId_billDetail(int id_billDetail) {
        this.id_billDetail = id_billDetail;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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
