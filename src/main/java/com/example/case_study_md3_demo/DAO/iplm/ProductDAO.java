package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IProductDAO;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.myConnection.MyConnection;
import com.example.case_study_md3_demo.service.iplm.BrandManage;
import com.example.case_study_md3_demo.service.iplm.CategoryManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private final Connection connection;
    CategoryManage categoryManage ;
    BrandManage brandManage ;
    private MyConnection myConnection = new MyConnection();
    private final String SELECT_ALL = "select* from product;";
    private final String SELECT_BY_ID = "select*from product where id=?;";

    public ProductDAO() {
        connection = myConnection.getConnection();
        categoryManage = new CategoryManage();
        brandManage =new BrandManage();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double sale_price = resultSet.getDouble("sale_price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int isActive = resultSet.getInt("isActive");
                int id_category =resultSet.getInt("id_category");
                int id_brand = resultSet.getInt("id_brand");
                product =new Product(id1,name,price,sale_price,quantity,description,image,isActive,id_category,id_brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }
}
