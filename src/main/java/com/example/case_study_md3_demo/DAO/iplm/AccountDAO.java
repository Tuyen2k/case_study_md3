package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IAccountDAO;
import com.example.case_study_md3_demo.model.Account;
import com.example.case_study_md3_demo.model.Role;
import com.example.case_study_md3_demo.myConnection.MyConnection;
import com.example.case_study_md3_demo.service.iplm.RoleManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    private final MyConnection myConnection;
    private final Connection connection;
    RoleManage roleManage ;
    private String SELECT_ACCOUNT_LIST = "select * from account";
    private final String SELECT_ACCOUNT_BY_ID = "select * from account where id = ?";
    private final String INSERT_INTO_ACCOUNT = "insert into account(username,password,phone,email,address,role) value(?,?,?,?,?,?);";
    private final String UPDATE_ACCOUNT = "update account set name = ? where id = ?";

    public AccountDAO() {
      myConnection =MyConnection.getMyConnection();
      connection = myConnection.getConnection();;
      roleManage =new RoleManage();

    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_LIST);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_account = resultSet.getInt("id_account");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email =resultSet.getString("email");
                String address =resultSet.getString("address");
                int id_role = resultSet.getInt("id_role");
                Role role = roleManage.findById(id_role);
                Account account = new Account(id_account, username, password, phone,email,address,role);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email =resultSet.getString("email");
                String address =resultSet.getString("address");
                int id_role = resultSet.getInt("id_role");
                Role role = roleManage.findById(id_role);
                account = new Account( username, password,phone,email,address,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void create(Account account) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_ACCOUNT)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getPhone());
            preparedStatement.setString(4,account.getEmail());
            preparedStatement.setString(5,account.getAddress());
            preparedStatement.setInt(6,account.getRole().getId_role());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setInt(2,account.getId_account());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
