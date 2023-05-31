
package controller;
import View.admin.admin_login;

public class AdminLoginController {
    private final  admin_login view;

    public AdminLoginController(admin_login view) {
        this.view = view;
    }
    
   public void login(){
       
       if("Admin".equals(view.getTextAdminUserName().getText()) && "root".equals(view.getTextAdminPassword().getText())){
           System.out.println("Login Successfull");
           
       }else{
           System.out.println("Wrong Password");
           
       }
      
   }
   
  
    
}
