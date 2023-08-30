package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IProductDAO;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    MyConnection myConnection = MyConnection.getMyConnection();
    Connection connection;
    public ProductDAO(){
        connection = myConnection.getConnection();
    }
    @Override
    public List<Product> findAll() {
        String select = "select * from product;";
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double sale_price = resultSet.getDouble("sale_price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int isActive = resultSet.getInt("isActive");
                int id_category =resultSet.getInt("id_category");
                int id_brand = resultSet.getInt("id_brand");
                products.add(new Product(id, name, price, sale_price, quantity, description, image,isActive,id_category,id_brand));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }
}
