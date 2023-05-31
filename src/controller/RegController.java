/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.*;
import View.user_registration;
import model.Person;
import model.DB.RegistrationDB;
/**
 *
 * @author rkrah
 */
public class RegController {
    
    private final user_registration viewSignUp;
    private Person usermodel;
    private RegistrationDB regDB;

    public RegController(user_registration viewSignUp) {
        this.viewSignUp = viewSignUp;
    }
    
    
    public void add(){
//        viewSignUp.showMessage(viewSignUp.checkData());
        
        if(viewSignUp.checkData()){
            usermodel = new Person();
            
            
            
            usermodel.setFull_name(viewSignUp.getTextFullName().getText());
            usermodel.setUser_name(viewSignUp.getTextUserName().getText());
            usermodel.setPassword(viewSignUp.getTextPassword().getText());
            usermodel.setMobile_number(viewSignUp.getTextMobileNumber().getText());
            usermodel.setEmail(viewSignUp.getTextEmail().getText());
            usermodel.setDistrict(viewSignUp.getTextDistrict().getText());
            usermodel.setPost_code(viewSignUp.getTextPostCode().getText());
            
            try{
                
                
                regDB = new RegistrationDB();
                
                 
                regDB.INSERT(usermodel);
                
                viewSignUp.showMessage("Registration Successfull!");
                viewSignUp.CleanField();  //Clean field
                
                
                
            }catch(SQLException ex){
                viewSignUp.showMessage("Error When you Registrer!");
            }
        }
    }
    
}
