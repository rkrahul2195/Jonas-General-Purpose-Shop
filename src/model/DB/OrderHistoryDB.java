/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DB;

import model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rkrah
 */
public class OrderHistoryDB {

    private final Connection connection;

    public OrderHistoryDB() throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    public List<Order> CartToOrderSet(String email) throws SQLException {

        String sql = "SELECT su.full_name, su.mobile, su.email, p.pcode, p.pname, p.brand, p.capacity, so.quantity, p.price "
                + "FROM shop_user su "
                + "JOIN Shop_order so ON su.id = so.userID "
                + "JOIN product p ON p.pcode = so.productCode "
                + "WHERE su.email = ?;";

        PreparedStatement stmt;
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();
        List<Order> userProductOrder = new ArrayList<>();
        while (rs.next()) {
            Order orderHistory = new Order();
            orderHistory.setFullName(rs.getString("su.full_name"));
            orderHistory.setMobileNumber(rs.getString("su.mobile"));
            orderHistory.setEmail(rs.getString("su.email"));
            orderHistory.setProductCode(rs.getString("p.pcode"));
            orderHistory.setProductName(rs.getString("p.pname"));
            orderHistory.setProductBrand(rs.getString("p.brand"));
            orderHistory.setProductCapacity(rs.getString("p.capacity"));
            orderHistory.setQuantity(rs.getInt("so.quantity"));
            orderHistory.setProductPrice(rs.getDouble("p.price"));
            userProductOrder.add(orderHistory);
        }

        return userProductOrder;
    }

}
