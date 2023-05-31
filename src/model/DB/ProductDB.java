/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DB;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.product;
import model.Person;
import model.Order;
//import model.DB.ConnectionDB;
/**
 *
 * @author rkrah
 */
public class ProductDB {

    private final Connection connection;

    public ProductDB() throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    public void ProductInsert(product pdt) throws SQLException {
        String sql = "INSERT INTO product(pcode,pname,ptype,price,capacity,brand)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt;
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, pdt.getPCode());
        stmt.setString(2, pdt.getProductName());
        stmt.setString(3, pdt.getProductType());
        stmt.setDouble(4, pdt.getProductPrice());
        stmt.setString(5, pdt.getProductCapacity());
        stmt.setString(6, pdt.getProductBrand());

        stmt.execute();
        stmt.close();

    }

    public void OrderProductCart(Order odt) throws SQLException {
        String sql = "INSERT INTO shop_order(orderID,productCode,quantity,userID)"
                + "VALUES (?,?,?,?)";

        PreparedStatement stmt;
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, odt.getOrderID());
        stmt.setString(2, odt.getProductCode());
        stmt.setInt(3, odt.getQuantity());
        stmt.setInt(4, odt.getUserID());
        stmt.execute();
        stmt.close();
    }

    public List<product> ProductSelect() throws SQLException {

        String sql = "SELECT * FROM product";

        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        List<product> listproduct = new ArrayList<>();

        while (rs.next()) {
            product pdt = new product();
            pdt.setPCode(rs.getString("pcode"));
            pdt.setProductName(rs.getString("pname"));
            pdt.setProductType(rs.getString("ptype"));
            pdt.setProductPrice(rs.getDouble("price"));
            pdt.setProductCapacity(rs.getString("capacity"));
            pdt.setProductBrand(rs.getString("brand"));
            listproduct.add(pdt);
        }

        rs.close();
        stmt.close();
        return listproduct;

    }

    public List<Person> UserProfileSetDB(String email) throws SQLException {
        String sql = "SELECT id,full_name, mobile from shop_user WHERE email=?";

        List<Person> userInfo;
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                userInfo = new ArrayList<>();
                while (rs.next()) {
                    Person userData = new Person();
                    userData.setId(rs.getInt("id"));
                    userData.setFull_name(rs.getString("full_name"));
                    userData.setMobile_number(rs.getString("mobile"));
                    userInfo.add(userData);
                }
            }
        }

        return userInfo;

    }

}
