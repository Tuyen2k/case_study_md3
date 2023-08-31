package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.IAccountDAO;
import com.example.case_study_md3_demo.DAO.iplm.AccountDAO;
import com.example.case_study_md3_demo.DAO.iplm.BrandDAO;
import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.service.IAccountService;

import java.util.List;

public class AccountManage implements IAccountService {
    private AccountDAO accountDAO;
    private static AccountManage accountManage;

    public AccountManage() {
        accountDAO = new AccountDAO();
    }


    public static AccountManage getAccountManage() {
        if (accountManage == null) {
            accountManage = new AccountManage();
        }
        return accountManage;
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountDAO.findById(id);
    }

    @Override
    public void create(Account account) {
        accountDAO.create(account);
    }

    @Override
    public void update(Account account) {
        accountDAO.update(account);
    }
}
