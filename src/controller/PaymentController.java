package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import model.DB.OrderHistoryDB;
import model.Order;
import model.Payment;
import View.OrderCart;
import View.PaymentView;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;
import model.DB.ProductDB;
import model.DB.PaymentDB;

public class PaymentController {

    private  OrderCart cartView;
    private final PaymentView view;
    private ProductDB pdData;
    private OrderHistoryDB orderDaoModel;
    private Order Ordermodel;
    private Payment model;
    private PaymentDB paymentDaoModel;

    public PaymentController(OrderCart cartView, PaymentView view) {
        this.cartView = cartView;
        this.view = view;
    }

    public PaymentController(PaymentView view) {
        this.view = view;
    }
    

    public String TransactionCode() {
        model = new Payment();
        Random rand = new Random();
        Random random = new Random();
        int min = 1000;
        int max = 9999;

        int min1 = 10;
        int max1 = 99;

        int id1 = random.nextInt(max1 - min1 + 1) + min1;
        int id = random.nextInt(max - min + 1) + min;

        String[] randomStrings = new String[2];
        String[] randomStringsCapital = new String[2];
        for (int i = 0; i < 2; i++) {
            char[] word = new char[2];
            char[] word1 = new char[2];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
                word1[j] = (char) ('A' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
            randomStringsCapital[i] = new String(word1);
        }
        String Code = id1 + randomStrings[1] + id + randomStringsCapital[1];

        model.setTransactionID(Code);

        return model.getTransactionID();
    }

    public void payment(int userID) {
        try {
//        if(view.checkdata())
            model = new Payment();
            String Tid = TransactionCode();
            double amt = Double.parseDouble(view.getTextPayAmount().getText());

            model.setAmount(amt);
            model.setTransactionID(Tid);
            model.setUserID(userID);
            model.setSender(view.getTextSenderNumber().getText());
            if (amt == Double.parseDouble(view.getTextPayableAmount().getText())) {
                model.setStatus("Yes");
            } else {
                model.setStatus("NO");
            }

            paymentDaoModel = new PaymentDB();

            paymentDaoModel.TransactionRecord(model);

        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void PaymentCheckOut(String email, double Amount) {
        try {
            view.setVisible(true);
            cartView.dispose();

            List<Person> userdata;
            try {
                pdData = new ProductDB();
            } catch (SQLException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            userdata = pdData.UserProfileSetDB(email);

            String FullName = userdata.get(0).getFull_name();
            String id = Integer.toString(userdata.get(0).getId());
            view.getTextUserID().setText(id);
            view.getTextUserFullName().setText(FullName);
            view.getTextBkash().setText("01738250672");
            view.getTextPayAmount().setText(Double.toString(Amount));
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
