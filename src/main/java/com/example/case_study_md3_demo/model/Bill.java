package com.example.case_study_md3_demo.model;

public class Bill {
    private int id_bill;
    private Account account;
    private double total;

    public Bill(int id_bill, Account account, double total) {
        this.id_bill = id_bill;
        this.account = account;
        this.total = total;
    }

    public Bill(Account account, double total) {
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
