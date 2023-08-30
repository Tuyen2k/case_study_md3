package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IProductDAO;
import com.example.case_study_md3_demo.model.Brand;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private final MyConnection myConnection;
    private final Connection connection;
    private String SELECT_PRODUCT_LIST = "select * from product;";
    private final String SELECT_PRODUCT_BY_ID = "select * from product where id_product = ?;";

    private CategoryDAO categoryDAO = new CategoryDAO();


    public ProductDAO(){
        myConnection = MyConnection.getMyConnection();
        connection = myConnection.getConnection();
    }

//    public List<Product> findAll() {
////        List<Product> productList = new ArrayList<>();
////        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_LIST)) {
////            ResultSet resultSet = preparedStatement.executeQuery();
////            while (resultSet.next()) {
////                int id = resultSet.getInt("id_product");
////                String name = resultSet.getString("name");
////                double price = resultSet.getDouble("price");
////                double salePrice = resultSet.getDouble("sale_price");
////                int quantity = resultSet.getInt("quantity");
////                String description = resultSet.getString("description");
////                String image = resultSet.getString("image");
////                int isActive = resultSet.getInt("isActive");
////                int categoryId = resultSet.getInt("id_category");
////                int brandId = resultSet.getInt("id_brand");
////
////                Category category = categoryDAO.findById(categoryId);
//////                Brand brand = brandDAO.findById(brandId);
////
////
////                productList.add(new Product(id, name, price, salePrice, quantity, description, image, isActive, category, brand));
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return productList;
//    }

    @Override
    public List<Product> findAll() {
        return null;
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
        String sql = "insert into product (name, price, sale_price, quantity, description, image, isActive, category, brand) values(?,?,?,?,?,?,?,?,?);";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getSale_price());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getImage());
            preparedStatement.setInt(7, product.getIsActive());
            preparedStatement.setInt(8, product.getCategory().getId_category());
            preparedStatement.setInt(9, product.getCategory().getId_category());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET name=?, price=?, sale_price=?, quantity=?, description=?, image=?, isActive=?, category=?, brand=? WHERE id=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getSale_price());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getImage());
            preparedStatement.setInt(7, product.getIsActive());
            preparedStatement.setInt(8, product.getCategory().getId_category());
            preparedStatement.setInt(9, product.getCategory().getId_category());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}