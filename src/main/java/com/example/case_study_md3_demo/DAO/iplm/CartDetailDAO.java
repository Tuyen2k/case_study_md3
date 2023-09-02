package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.ICartDetailDAO;
import com.example.case_study_md3_demo.model.CartDetail;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDetailDAO implements ICartDetailDAO {
    private MyConnection myConnection = MyConnection.getMyConnection();
    private Connection connection;
    private CartDAO cartDAO;
    private ProductDAO productDAO;
    private String SELECT_ALL = "select * from cart_detail;";
    private String SELECT_CARTDETAIL_BY_ID = "select * from cart_detail where id_cartDetail = ?;";
    private String SELECT_CARTDETAIL_BY_IDCART = "select * from cart_detail where id_cart = ?;";
    private String SELECT_CARTDETAIL_BY_IDPRODUCT = "select * from cart_detail where id_product = ?;";
    private String INSERT_INTO = "insert into cart_detail(id_cart, id_product, price, quantity, total_product) value(?, ?, ?, ?, ?);";
    private String UPDATE_CART = "update cart_detail set price = ?, quantity = ?, total_product = ? where id_cartDetail = ?;";

    public CartDetailDAO() {
        connection = myConnection.getConnection();
        cartDAO = new CartDAO();
        productDAO = new ProductDAO();
    }

    @Override
    public List<CartDetail> findAll() {
        List<CartDetail> cartDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            cartDetails = getListDataDB(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartDetails;
    }
    public List<CartDetail> findByIdCart(int id) {
        List<CartDetail> cartDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARTDETAIL_BY_IDCART)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            cartDetails = getListDataDB(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartDetails;
    }

    private CartDetail getDataDB(ResultSet resultSet) throws SQLException {
        CartDetail cartDetail = new CartDetail();
        while (resultSet.next()) {
            int id_cartDetail = resultSet.getInt("id_cartDetail");
            int id_cart = resultSet.getInt("id_cart");
            int id_product = resultSet.getInt("id_product");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            double total = resultSet.getDouble("total_product");
            cartDetail = new CartDetail(id_cartDetail, cartDAO.findById(id_cart), productDAO.findById(id_product), price, quantity, total);
            return cartDetail;
        }
        return null;
    }
    private List<CartDetail> getListDataDB(ResultSet resultSet) throws SQLException {
        List<CartDetail> cartDetails = new ArrayList<>();
        while (resultSet.next()) {
            int id_cartDetail = resultSet.getInt("id_cartDetail");
            int id_cart = resultSet.getInt("id_cart");
            int id_product = resultSet.getInt("id_product");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            double total = resultSet.getDouble("total_product");
            cartDetails.add(new CartDetail(id_cartDetail, cartDAO.findById(id_cart), productDAO.findById(id_product), price, quantity, total));
        }
        return cartDetails;
    }

    @Override
    public CartDetail findById(int id) {
        CartDetail cartDetail = new CartDetail();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARTDETAIL_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            cartDetail = getDataDB(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartDetail;
    }

    public CartDetail checkCart(int id) {
        CartDetail cartDetail = new CartDetail();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARTDETAIL_BY_IDCART)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            cartDetail = getDataDB(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartDetail;
    }

    @Override
    public void create(CartDetail cartDetail) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, cartDetail.getCart().getId_cart());
            preparedStatement.setInt(2, cartDetail.getProduct().getId_product());
            preparedStatement.setDouble(3, cartDetail.getPrice());
            preparedStatement.setInt(4, cartDetail.getQuantity());
            preparedStatement.setDouble(5, cartDetail.getTotal_product());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CartDetail cartDetail) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART)) {
            preparedStatement.setDouble(1, cartDetail.getPrice());
            preparedStatement.setInt(2, cartDetail.getQuantity());
            preparedStatement.setDouble(3, cartDetail.getTotal_product());
            preparedStatement.setInt(4, cartDetail.getId_cartDetail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
