package controller;

import View.OrderCart;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DB.ProductDB;
import model.product;
import model.Person;
import model.Order;
import View.userProduct;
import View.user_login;
import java.util.Random;
import javax.swing.JTextField;
import model.DB.OrderHistoryDB;

public class ProductOrderController {

    private product model;
    private Order ordermodel;
    private ProductDB pdtDB;
    private final userProduct viewProductUser;
    private OrderHistoryDB orderDao;
    private final OrderCart cartView;

    public ProductOrderController(userProduct viewProductUser, OrderCart cartView) {
        this.viewProductUser = viewProductUser;
        this.cartView = cartView;
    }

    public String OrderCode() {
        model = new product();
        Random rand = new Random();
        Random random = new Random();
        int min = 2222;
        int max = 3333;

        model.setId(random.nextInt(max - min + 1) + min);

        String[] randomStrings = new String[2];
        for (int i = 0; i < 2; i++) {
            char[] word = new char[2];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('O' + random.nextInt(1));
            }
            randomStrings[i] = new String(word);
        }
        String Code = randomStrings[1] + model.getId();

        model.setPCode(Code);

        return model.getPCode();
    }

    public void showProductList() {
        List<product> listProduct;

        try {
            pdtDB = new ProductDB();
            listProduct = pdtDB.ProductSelect();

            if (!listProduct.isEmpty()) {
                String[] line = new String[]{null, null, null, null, null, null};

                DefaultTableModel productData = (DefaultTableModel) viewProductUser.getTableProduct().getModel();

                productData.setNumRows(0);

                for (int i = 0; i < listProduct.size(); i++) {
                    productData.addRow(line);
                    productData.setValueAt(listProduct.get(i).getPCode(), i, 0);
                    productData.setValueAt(listProduct.get(i).getProductName(), i, 1);
                    productData.setValueAt(listProduct.get(i).getProductType(), i, 2);
                    productData.setValueAt(listProduct.get(i).getProductPrice(), i, 3);
                    productData.setValueAt(listProduct.get(i).getProductCapacity(), i, 4);
                    productData.setValueAt(listProduct.get(i).getProductBrand(), i, 5);

                }

            }

        } catch (SQLException e) {
            System.out.println("Error on Product List");
        }

    }

    public void SelectOrder() {
        int selectLine = viewProductUser.getTableProduct().getSelectedRow();

        if (selectLine != -1) {
            viewProductUser.OrderSelect(viewProductUser.getTableProduct().getValueAt(selectLine, 0).toString(),
                    viewProductUser.getTableProduct().getValueAt(selectLine, 1).toString(),
                    viewProductUser.getTableProduct().getValueAt(selectLine, 3).toString());

        }
    }

    public void userProfileSet() {

        String email = viewProductUser.getTextEmail().getText();

        List<Person> userInfo;

        try {
            pdtDB = new ProductDB();
            System.out.println("User Email: " + email);
            userInfo = pdtDB.UserProfileSetDB(email);

            String Fullname = userInfo.get(0).getFull_name();
            int id = userInfo.get(0).getId();
            String Fullname1 = userInfo.get(0).getPassword();

            System.out.println(userInfo.get(0).getFull_name());
            System.out.println(id);
            System.out.println("User Info Size: " + userInfo.size());
            System.out.println(Fullname1);

            viewProductUser.getTextID().setText(String.valueOf(id));
//            viewProductUser.getTextID().setEditable(false);
            viewProductUser.getTextName().setText(Fullname);
//            viewProductUser.getTextName().setEditable(false);

        } catch (SQLException ex) {

            System.out.println("Error : ProductOrderController" + ex);

        }
    }

    public void OrderToCart() throws SQLException {
        ordermodel = new Order();
        String code = OrderCode();

        ordermodel.setOrderID(code);
        ordermodel.setProductCode(viewProductUser.getTextProcuctCode().getText());
        String temp = viewProductUser.getTextQuentity().getText();
        int qt = Integer.parseInt(temp);
        ordermodel.setQuantity(qt);
        String tempID = viewProductUser.getTextID().getText();
        int id = Integer.parseInt(tempID);
        ordermodel.setUserID(id);

        pdtDB = new ProductDB();
        pdtDB.OrderProductCart(ordermodel);
    }

    public double DiscountAmount(int persentage, double amount) {
        double total = (amount * persentage) / 100;
        return total;
    }

    public void OrderCheck(String email) throws SQLException {
        this.cartView.setVisible(true);
        viewProductUser.dispose();
        List<Order> orderCheckHistory;
        orderDao = new OrderHistoryDB();
        orderCheckHistory = orderDao.CartToOrderSet(email);

        if (!orderCheckHistory.isEmpty()) {
            System.out.println(orderCheckHistory.get(0).getProductName());
            System.out.println(orderCheckHistory.get(0).getProductName());

            double subtotalAmount = 0;
            double discountTotalAmount = 0;
            double totalAmount = 0;

            String fullName = orderCheckHistory.get(0).getFullName();
            String emailx = orderCheckHistory.get(0).getEmail();
            String number = orderCheckHistory.get(0).getMobileNumber();

            this.cartView.getTextFullName().setText(fullName);
            this.cartView.getTextEmail().setText(emailx);
            this.cartView.getTextMobileNumber().setText(number);

            String[] lineOrder = new String[]{null, null, null, null, null, null};

            DefaultTableModel orderLineProduct = (DefaultTableModel) this.cartView.getOrderTable().getModel();

            orderLineProduct.setNumRows(0);
            for (int i = 0; i < orderCheckHistory.size(); i++) {
                orderLineProduct.addRow(lineOrder);
                String productCode = orderCheckHistory.get(i).getProductCode();
                String productName = orderCheckHistory.get(i).getProductName();
                String brand = orderCheckHistory.get(i).getProductBrand();
                String capacity = orderCheckHistory.get(i).getProductCapacity();
                int quantity = orderCheckHistory.get(i).getQuantity();
                double price = orderCheckHistory.get(i).getProductPrice();
                double subAmount = quantity * price;

                subtotalAmount += subAmount;

                orderLineProduct.setValueAt(productCode, i, 0);
                orderLineProduct.setValueAt(productName, i, 1);
                orderLineProduct.setValueAt(brand, i, 2);
                orderLineProduct.setValueAt(capacity, i, 3);
                orderLineProduct.setValueAt(quantity, i, 4);
                orderLineProduct.setValueAt(price, i, 5);
                orderLineProduct.setValueAt(subAmount, i, 6);
            }

            this.cartView.getTextSubTotalAmount().setText(Double.toString(subtotalAmount));
            if (subtotalAmount >= 1000.00 && subtotalAmount<1500.00) {
                this.cartView.getTextDiscount().setText("5");
                discountTotalAmount = DiscountAmount(5, subtotalAmount);
                this.cartView.getTextDiscountAmount().setText(Double.toString(discountTotalAmount));
                totalAmount = subtotalAmount - discountTotalAmount;
                this.cartView.getTextTotalAmount().setText(Double.toString(totalAmount));

            } else if (subtotalAmount >= 2000.00 && subtotalAmount<3000.00) {
                this.cartView.getTextDiscount().setText("10");
                discountTotalAmount = DiscountAmount(10, subtotalAmount);
                this.cartView.getTextDiscountAmount().setText(Double.toString(discountTotalAmount));
                totalAmount = subtotalAmount - discountTotalAmount;
                this.cartView.getTextTotalAmount().setText(Double.toString(totalAmount));

            } else if (subtotalAmount >= 3000.00) {
                this.cartView.getTextDiscount().setText("15");
                discountTotalAmount = DiscountAmount(15, subtotalAmount);
                this.cartView.getTextDiscountAmount().setText(Double.toString(discountTotalAmount));
                totalAmount = subtotalAmount - discountTotalAmount;
                this.cartView.getTextTotalAmount().setText(Double.toString(totalAmount));

            } else {
                this.cartView.getTextDiscount().setText("0");
                discountTotalAmount = DiscountAmount(0, subtotalAmount);
                this.cartView.getTextDiscountAmount().setText(Double.toString(discountTotalAmount));
                totalAmount = subtotalAmount - discountTotalAmount;
                this.cartView.getTextTotalAmount().setText(Double.toString(totalAmount));

            }

        }
    }
    
    
    

}
