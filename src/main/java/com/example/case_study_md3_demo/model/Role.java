package com.example.case_study_md3_demo.model;

public class Role {
    private int id_role;
    private String name;

    public Role(int id_role, String name) {
        this.id_role = id_role;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
