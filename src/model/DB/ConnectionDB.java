/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DB;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rkrah
 */
public class ConnectionDB {

    public static Connection getConnection() throws SQLException {
        try {
            Connection sqlconn = null;
            String username = "root";
            String password = "Rahul2195";
            String DBconnectURL = "jdbc:mysql://localhost:3306/jonasshop";

            System.out.println("Connecting to the database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlconn = DriverManager.getConnection(DBconnectURL, username, password);
            System.out.println("Connection successful!");
            return sqlconn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error connecting to the database:");
            ex.printStackTrace();
            throw new SQLException(ex);
        }
    }

}
