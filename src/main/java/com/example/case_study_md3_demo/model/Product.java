package com.example.case_study_md3_demo.model;

public class Product {
    private int id_product;
    private String name;
    private double price;
    private double sale_price;
    private int quantity;
    private String description;
    private String image;
    private int isActive; // 0 là false, 1 là true
    private int id_category;
    private int id_brand;

    public Product(int id_product, String name, double price, double sale_price, int quantity, String description, String image, int isActive, int id_category, int id_brand) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.sale_price = sale_price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.isActive = isActive;
        this.id_category = id_category;
        this.id_brand = id_brand;
    }

    public Product(String name, double price, double sale_price, int quantity, String description, String image, int isActive, int id_category, int id_brand) {
        this.name = name;
        this.price = price;
        this.sale_price = sale_price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.isActive = isActive;
        this.id_category = id_category;
        this.id_brand = id_brand;
    }

    public Product() {
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }
}
