package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IBillDAO;
import com.example.case_study_md3_demo.model.Bill;
import com.example.case_study_md3_demo.model.Cart;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillDAO implements IBillDAO {
    private MyConnection myConnection =  MyConnection.getMyConnection();
    private CartDAO  cartDAO;
    private Connection connection;
    public BillDAO(){
        connection = myConnection.getConnection();
        cartDAO = new CartDAO();
    }
    private String FIND_BY_CART = "select * from bill where id_cart = ?;";
    private String SELECT_ALL = "select * from bill;";
    private String SELECT_BY_ID = "select * from bill where id_bill = ?;";
    private String INSERT_INTO = "insert into bill(id_cart,total) value (?,?); ";
    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public Bill findById(int id) {
        Bill bill = new Bill();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_cart = resultSet.getInt("id_cart");
                double total = resultSet.getDouble("total");
                Cart cart = cartDAO.findById(id_cart);
                bill = new Bill(id,cart,total);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bill;
    }
    public Bill findById_cart(int id_cart) {
        Bill bill = new Bill();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CART)) {
            preparedStatement.setInt(1,id_cart);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_bill = resultSet.getInt("id_bill");
                double total = resultSet.getDouble("total");
                Cart cart = cartDAO.findById(id_cart);
                bill = new Bill(id_bill,cart,total);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bill;
    }

    @Override
    public void create(Bill bill) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, bill.getCart().getId_cart());
            preparedStatement.setDouble(2, bill.getTotal());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Bill bill) {

    }
}
