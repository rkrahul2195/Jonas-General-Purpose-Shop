package model.DB;

import model.ComplainBox;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComplainDB {

    private final Connection connection;

    public ComplainDB() throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    public void ComplainInsert(ComplainBox cb) {
        try {
            String sql = "INSERT INTO complaint (username,email,subject,message)"
                    + "VALUES (?,?,?,?)";
            
            PreparedStatement stmt;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cb.getUsername());
            stmt.setString(2, cb.getEmail());
            stmt.setString(3, cb.getSubject());
            stmt.setString(4, cb.getMessage());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComplainDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
