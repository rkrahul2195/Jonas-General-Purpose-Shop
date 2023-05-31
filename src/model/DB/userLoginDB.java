/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DB;

import java.sql.*;
import model.Person;

/**
 *
 * @author rkrah
 */
public class userLoginDB {

    private final Connection connection;

    public userLoginDB() throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    public boolean userLogin(String email, String password) {
        try {
            String sql = "SELECT * from shop_user WHERE email=? AND password=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            
            return rs.next();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }

}
