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
public class RegistrationDB {

    private final Connection connection;

    public RegistrationDB() throws SQLException {
       
        this.connection = ConnectionDB.getConnection();
    }

    public void INSERT(Person reg) throws SQLException {
        
       
        try{
       
        String sql = "INSERT INTO shop_user(full_name,user_name,password,mobile,email,district,post_code)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?) ";

        PreparedStatement stmt;
        stmt = connection.prepareCall(sql);

        stmt.setString(1, reg.getFull_name());
        stmt.setString(2, reg.getUser_name());
        stmt.setString(3, reg.getPassword());
        stmt.setString(4, reg.getMobile_number());
        stmt.setString(5, reg.getEmail());
        stmt.setString(6, reg.getDistrict());
        stmt.setString(7,reg.getPost_code());
        
        stmt.execute();
        stmt.close();
        }catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

}
