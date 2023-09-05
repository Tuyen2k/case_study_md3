package com.example.case_study_md3_demo.DAO.iplm;

import com.example.case_study_md3_demo.DAO.IBillDetailDAO;
import com.example.case_study_md3_demo.model.Bill;
import com.example.case_study_md3_demo.model.BillDetail;
import com.example.case_study_md3_demo.model.Product;
import com.example.case_study_md3_demo.myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO implements IBillDetailDAO {
    private MyConnection myConnection =  MyConnection.getMyConnection();
    private  ProductDAO productDAO;
    private BillDAO billDAO;
    private Connection connection;
    private String SELECT_ALL = "select * from bill_detail;";
    private String SELECT_ALL_ID_BILL = "select * from bill_detail where id_bill = ?;";
    private String SELECT_BY_ID = "select * from bill_detail where id_bill = ?;";
    private String INSERT_INTO = "insert into bill_detail(id_product, id_bill, quantity, price, timePurchase, total) value (?,?,?,?,?,?);";
    public BillDetailDAO(){
        connection = myConnection.getConnection();
        productDAO = new ProductDAO();
        billDAO = new BillDAO();
    }
    @Override
    public List<BillDetail> findAll() {
        List<BillDetail> billDetails = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                int id_billDetail = resultSet.getInt("id_billDetail");
                int id_product = resultSet.getInt("id_product");
                int id_bill = resultSet.getInt("id_bill");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getInt("price");
                double total = resultSet.getInt("total");
                LocalDateTime time = resultSet.getObject("timePurchase",LocalDateTime.class);
                Product product = productDAO.findById(id_product);
                Bill bill = billDAO.findById(id_bill);
                billDetails.add(new BillDetail(id_billDetail,product,bill,price,quantity,total,time));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billDetails;
    }
    public List<BillDetail> findAllIdBill(int id_bill) {
        List<BillDetail> billDetails = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ID_BILL)) {
            preparedStatement.setInt(1,id_bill);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_billDetail = resultSet.getInt("id_billDetail");
                int id_product = resultSet.getInt("id_product");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getInt("price");
                double total = resultSet.getInt("total");
                LocalDateTime time = resultSet.getObject("timePurchase",LocalDateTime.class);
                Product product = productDAO.findById(id_product);
                Bill bill = billDAO.findById(id_bill);
                billDetails.add(new BillDetail(id_billDetail,product,bill,price,quantity,total,time));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billDetails;
    }

    @Override
    public BillDetail findById(int id) {
        BillDetail billDetail = new BillDetail();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                int id_billDetail = resultSet.getInt("id_billDetail");
                int id_product = resultSet.getInt("id_product");
                int id_bill = resultSet.getInt("id_bill");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getInt("price");
                double total = resultSet.getInt("total");
                LocalDateTime time = resultSet.getObject("timePurchase",LocalDateTime.class);
                Product product = productDAO.findById(id_product);
                Bill bill = billDAO.findById(id_bill);
                billDetail = new BillDetail(id_billDetail,product,bill,price,quantity,total,time);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billDetail;
    }

    @Override
    public void create(BillDetail billDetail) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1,billDetail.getProduct().getId_product());
            preparedStatement.setInt(2,billDetail.getBill().getId_bill());
            preparedStatement.setInt(3,billDetail.getQuantity());
            preparedStatement.setDouble(4,billDetail.getPrice());
            preparedStatement.setString(5,billDetail.getTimePurchase().toString());
            preparedStatement.setDouble(6,billDetail.getTotal_bill());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(BillDetail billDetail) {

    }
}
