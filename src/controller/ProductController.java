/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author rkrah
 */
import View.admin.addProduct;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import model.product;
import model.DB.ProductDB;
import View.userProduct;

public class ProductController {

    private product model;
    private final addProduct viewProduct;
    private userProduct viewProductUser;
    private ProductDB pdtDB;

    public ProductController(addProduct viewProduct) {
        this.viewProduct = viewProduct;
    }

    public String PCode() {
        model = new product();
        Random rand = new Random();
        Random random = new Random();
        int min = 1000;
        int max = 9999;

        model.setId(random.nextInt(max - min + 1) + min);

        String[] randomStrings = new String[2];
        for (int i = 0; i < 2; i++) {
            char[] word = new char[2];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('A' + random.nextInt(3));
            }
            randomStrings[i] = new String(word);
        }
        String Code = randomStrings[1] + model.getId();

        model.setPCode(Code);

        return model.getPCode();
    }

    public void addProduct() {
        model = new product();
//        ProductController controller = new ProductController();
//        model.setCode(Code);controller.PCode();
        model.setPCode(PCode());
        model.setProductName(viewProduct.getTextProductName().getText());
        model.setProductType(viewProduct.getComboProductType().getSelectedItem().toString());
        double productPrice = Double.parseDouble(viewProduct.getTextProductPrice().getText());
        model.setProductPrice(productPrice);
        model.setProductCapacity(viewProduct.getTextProductCapacity().getText());
        model.setProductBrand(viewProduct.getTextProductBrand().getText());
        try {
            pdtDB = new ProductDB();
            pdtDB.ProductInsert(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    @SuppressWarnings("empty-statement")
    
}
