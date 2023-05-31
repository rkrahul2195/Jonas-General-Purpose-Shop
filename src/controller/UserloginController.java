/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DB.userLoginDB;
import View.user_login;
import View.userProduct;
import model.Person;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rkrah
 */
public class UserloginController {

    private user_login viewlogin;
    private userProduct ProductPage;
    private userLoginDB modelData;
    private Person usermodel;
    private ProductOrderController controllerProduct;

    public UserloginController(user_login viewlogin) {
        try {
            this.viewlogin = viewlogin;
            this.ProductPage = new userProduct();
            
            this.modelData = new userLoginDB();
            this.usermodel = new Person();
        } catch (SQLException ex) {
            Logger.getLogger(UserloginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userSystemLogin() {
        
        usermodel.setEmail(viewlogin.getTextUserEmail().getText());
        usermodel.setPassword(viewlogin.getTextUserPassword().getText());

        boolean userLogin = modelData.userLogin(usermodel.getEmail(), usermodel.getPassword());

        if (userLogin) {
            ProductPage.TextEmail.setText(usermodel.getEmail().toString());
            ProductPage.setVisible(true);
            viewlogin.dispose();
        } else {
            System.out.println("Login Error and Check password and Email");
        }
    }
    
    public String getUserEmail(){
        return usermodel.getEmail();
    }

}
