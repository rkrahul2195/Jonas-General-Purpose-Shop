/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import model.ComplainBox;
import model.DB.ComplainDB;
import View.UserComplain;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ComplainController {

    private ComplainBox model;
    private ComplainDB modelDB;
    private final UserComplain view;
    public ComplainController(UserComplain view) {
        this.view = view;
    }
    
    public void userComplain(){
        try {
            model = new ComplainBox();
            
            model.setUsername(view.getTextFullName().getText());
            model.setEmail(view.getTextEmail().getText());
            model.setSubject(view.getTextSubject().getText());
            model.setMessage(view.getTextMessage().getText());
            
            modelDB = new ComplainDB();
            modelDB.ComplainInsert(model);
        } catch (SQLException ex) {
            Logger.getLogger(ComplainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
