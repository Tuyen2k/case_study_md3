package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IBrandDAO;
import com.example.case_study_md3_demo.model.Brand;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements IBrandDAO  {
    private final MyConnection myConnection;
    private final Connection connection;
    private String SELECT_BRANDS_LIST = "select * from brand;";
    private final String SELECT_BRANDS_BY_ID = "select * from brand where id_brand = ?;";
    private final String INSERT_INTO_BRANDS = "insert into brand(name) value(?);";
    private final String UPDATE_BRANDS = "update brand set name = ? where id_brand = ?;";

    public BrandDAO() {
        myConnection = MyConnection.getMyConnection();
        connection = myConnection.getConnection();
    }
    @Override
    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BRANDS_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_brand = resultSet.getInt("id_brand");
                String name = resultSet.getString("name");
                brands.add(new Brand(id_brand,name));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public Brand findById(int id) {
        Brand brand = new Brand();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BRANDS_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                brand = new Brand(id,name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return brand;
    }

    @Override
    public void create(Brand brand) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BRANDS)) {
            preparedStatement.setString(1, brand.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Brand brand) {
        try(PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_BRANDS)){
            preparedStatement.setString(1,brand.getName());
            preparedStatement.setInt(2,brand.getId_brand());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}

