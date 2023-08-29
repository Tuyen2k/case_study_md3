package com.example.case_study_md3_demo.model;

public class Role {
    private int id_role;
    private int name;

    public Role(int id_role, int name) {
        this.id_role = id_role;
        this.name = name;
    }

    public Role(int name) {
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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
