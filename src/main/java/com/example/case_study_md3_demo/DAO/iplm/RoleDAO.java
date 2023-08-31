package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IBrandDAO;
import com.example.case_study_md3_demo.DAO.IRoleDAO;
import com.example.case_study_md3_demo.model.Role;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {
    private MyConnection myConnection = MyConnection.getMyConnection();;
    private Connection connection;
    private String SELECT_ROLE_LIST = "select * from role;";
    private final String SELECT_ROLE_BY_ID = "select * from role where id = ?;";
    private final String INSERT_INTO_ROLE = "insert into role(name) value(?);";

    public RoleDAO(){
        connection = myConnection.getConnection();
    }
    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_role = resultSet.getInt("id_role");
                int name = Integer.parseInt(resultSet.getString("name"));
                roles.add(new Role(id_role,name));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role findById(int id) {
        Role role = new Role();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int name =Integer.parseInt(resultSet.getString("name"));
                role = new Role(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void create(Role role) {

    }

    @Override
    public void update(Role role) {

    }
}
