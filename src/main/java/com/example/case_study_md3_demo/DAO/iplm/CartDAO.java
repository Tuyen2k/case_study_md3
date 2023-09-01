package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.ICartDAO;
import com.example.case_study_md3_demo.DAO.IGenerateDAO;
import com.example.case_study_md3_demo.model.Cart;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    private MyConnection myConnection = MyConnection.getMyConnection();
    private Connection connection;
    private AccountDAO accountDAO;

    public CartDAO() {
        connection = myConnection.getConnection();
        accountDAO = new AccountDAO();
    }

    private String SELECT_ALL_CART = "select * from cart;";
    private String SELECT_CART_BY_ID = "select * from cart where id_cart = ?;";
    private String SELECT_CART_BY_IDACCOUNT = "select * from cart where id_account = ?;";
    private String SELECT_NEW_CART = "select * from cart order by id_cart desc limit 1;";
    private String INSERT_INTO = "insert into cart(id_account,total) value(?, ?);";
    private String UPDATE_CART = "update cart set total = ? where id_cart = ?";

    @Override
    public List<Cart> findAll() {
        List<Cart> carts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CART)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_cart = resultSet.getInt("id_cart");
                int id_product = resultSet.getInt("id_account");
                double total = resultSet.getDouble("total");
                carts.add(new Cart(id_cart,accountDAO.findById(id_product),total));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carts;
    }

    private Cart getDataDB(ResultSet resultSet) throws SQLException {
        Cart cart = new Cart();
        while (resultSet.next()){
            int id_cart = resultSet.getInt("id_cart");
            int id_product = resultSet.getInt("id_account");
            double total = resultSet.getDouble("total");
            cart = new Cart(id_cart,accountDAO.findById(id_product),total);
            return cart;
        }
        return null;
    }
    @Override
    public Cart findById(int id) {
        Cart cart = new Cart();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            cart = getDataDB(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }
    public Cart findByIdAccount(int id) {
        Cart cart = new Cart();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_IDACCOUNT)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            cart = getDataDB(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public void create(Cart cart) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1,cart.getAccount().getId_account());
            preparedStatement.setDouble(2,cart.getTotal());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cart cart) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART)) {
            preparedStatement.setDouble(1,cart.getTotal());
            preparedStatement.setInt(2,cart.getId_cart());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Cart findNewCart(){
        Cart cart = new Cart();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEW_CART)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_cart = resultSet.getInt("id_cart");
                int id_product = resultSet.getInt("id_account");
                double total = resultSet.getDouble("total");
                cart = new Cart(id_cart,accountDAO.findById(id_product),total);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }
}
