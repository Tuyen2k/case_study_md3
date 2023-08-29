package com.example.case_study_md3_demo.model;

public class Brand {
    private int id_brand;
    private String name;

    public Brand(int id_brand, String name) {
        this.id_brand = id_brand;
        this.name = name;
    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
