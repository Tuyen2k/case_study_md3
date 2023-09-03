package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.ICategoryDAO;
import com.example.case_study_md3_demo.model.Category;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    private final MyConnection myConnection;
    private final Connection connection;
    private String SELECT_CATEGORIES_LIST = "select * from category;";
    private final String SELECT_CATEGORY_BY_ID = "select * from category where id_category = ?;";
    private final String INSERT_INTO_CATEGORY = "insert into category(name) value(?);";
    private final String UPDATE_CATEGORY = "update category set name = ? where id_category = ?;";
    private final String CHECK = "SELECT COUNT(*) FROM category WHERE name = ?;";
    public CategoryDAO(){
        myConnection = MyConnection.getMyConnection();
        connection = myConnection.getConnection();
    }
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORIES_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_category = resultSet.getInt("id_category");
                String name = resultSet.getString("name");
                categories.add(new Category(id_category,name));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                category = new Category(id,name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void create(Category category) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CATEGORY)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        try(PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_CATEGORY)){
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2,category.getId_category());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean checkForDuplicates(String name)  {
        boolean isDuplicate = false;
        try(PreparedStatement preparedStatement = connection.prepareStatement(CHECK)) {
            preparedStatement.setString(1,name);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    isDuplicate = true;
                }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return  isDuplicate;
    }
}
