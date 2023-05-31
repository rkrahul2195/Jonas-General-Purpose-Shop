package model.DB;
import model.Payment;
import java.sql.*;
import model.Person;



public class PaymentDB {
    private final Connection connection;

    public PaymentDB() throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }
    
    public void TransactionRecord(Payment pt) throws SQLException{
        String sql= "INSERT INTO payment(TransactionID, userID, sender, amount, status)"
                + "VALUES(?, ?, ?, ?, ?) ";
        
        PreparedStatement stmt;
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, pt.getTransactionID());
        stmt.setInt(2, pt.getUserID());
        stmt.setString(3, pt.getSender());
        stmt.setDouble(4, pt.getAmount());
        stmt.setString(5, pt.getStatus());
        
        stmt.execute();
        stmt.close();
    }
}
