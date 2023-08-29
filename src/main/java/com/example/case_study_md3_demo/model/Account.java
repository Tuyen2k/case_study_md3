package com.example.case_study_md3_demo.model;

public class Account {
    private int id_account;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private int id_role;

    public Account() {
    }

    public Account(int id_account, String username, String password, String phone, String email, String address, int id_role) {
        this.id_account = id_account;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.id_role = id_role;
    }

    public Account(String username, String password, String phone, String email, String address, int id_role) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.id_role = id_role;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
}
