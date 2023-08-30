package com.example.case_study_md3_demo.myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private final String URL = "jdbc:mysql://localhost:3306/case_study_md3?useSSL=false";
    private final String username = "root";
    private final String password = "12345678";
    private static MyConnection myConnection;
    private MyConnection(){
    }

    public static MyConnection getMyConnection(){
        if (myConnection == null){
            myConnection = new MyConnection();
        }
        return myConnection;
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,username,password);
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
