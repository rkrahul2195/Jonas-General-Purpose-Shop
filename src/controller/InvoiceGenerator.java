package controller;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoiceGenerator {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/jonasshop";
        String username = "root";
        String password = "Rahul2195";

        // SQL query to retrieve invoice data
        String query = "SELECT full_name, mobile, email FROM shop_user";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            // Create PDF document
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\rkrah\\OneDrive\\Desktop\\Amar Bangla.pdf"));
            document.open();

            // Create table with 3 columns
            PdfPTable table = new PdfPTable(3);

            // Set table headers
            table.addCell("FULL NAME");
            table.addCell("MOBILE NUMBER");
            table.addCell("EMAIL");

            // Iterate through the result set and add table rows
            while (rs.next()) {
                String invoiceNumber = rs.getString("full_name");
                String customerName = rs.getString("mobile");
                String totalAmount = rs.getString("email");

                // Add row values to the table
                table.addCell(invoiceNumber);
                table.addCell(customerName);
                table.addCell(String.valueOf(totalAmount));
            }

            // Add table to the document
            document.add(table);

            // Close the document
            document.close();
            writer.close();
            System.out.println("Invoice generated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
