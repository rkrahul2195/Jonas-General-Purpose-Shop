package View;

import javax.swing.JTextField;
import controller.PaymentController;



public class PaymentView extends javax.swing.JFrame {
    private final PaymentController controller;
//    private final OrderCart viewcart;
    
    public PaymentView() {
        initComponents();
//        viewcart = new OrderCart();
        controller = new PaymentController( this);
    }

    public JTextField getTextBkash() {
        return TextBkash;
    }

    public void setTextBkash(JTextField TextBkash) {
        this.TextBkash = TextBkash;
    }

    public JTextField getTextPayAmount() {
        return TextPayAmount;
    }

    public void setTextPayAmount(JTextField TextPayAmount) {
        this.TextPayAmount = TextPayAmount;
    }

    public JTextField getTextPayableAmount() {
        return TextPayableAmount;
    }

    public void setTextPayableAmount(JTextField TextPayableAmount) {
        this.TextPayableAmount = TextPayableAmount;
    }

    public JTextField getTextReference() {
        return TextReference;
    }

    public void setTextReference(JTextField TextReference) {
        this.TextReference = TextReference;
    }

    public JTextField getTextSenderNumber() {
        return TextSenderNumber;
    }

    public void setTextSenderNumber(JTextField TextSenderNumber) {
        this.TextSenderNumber = TextSenderNumber;
    }

    public JTextField getTextUserFullName() {
        return TextUserFullName;
    }

    public void setTextUserFullName(JTextField TextUserFullName) {
        this.TextUserFullName = TextUserFullName;
    }

    public JTextField getTextUserID() {
        return TextUserID;
    }

    public void setTextUserID(JTextField TextUserID) {
        this.TextUserID = TextUserID;
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextUserID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextBkash = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TextUserFullName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TextPayAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TextSenderNumber = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TextPayableAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TextReference = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JGPS - Forgate Password");

        jPanel1.setBackground(new java.awt.Color(246, 135, 18));

        btnExit.setBackground(new java.awt.Color(236, 242, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 51, 51));
        btnExit.setText(" Exit");

        btnHome.setBackground(new java.awt.Color(236, 242, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(0, 51, 51));
        btnHome.setText("   Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );

        jPanel3.setBackground(new java.awt.Color(244, 242, 242));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/image/JGPS rahul.png"))); // NOI18N
        jLabel1.setText("Jonas General Purpose Shop");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 22, 444, 241));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Payment ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, 36));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("User ID");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 56, 26));
        jPanel3.add(TextUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 271, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Receiver Bkash/Nogod");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 508, 174, 26));
        jPanel3.add(TextBkash, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 549, 271, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Sender Bkash/Nogod");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 155, 26));
        jPanel3.add(TextUserFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 468, 271, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Payable Amount");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 132, 26));
        jPanel3.add(TextPayAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 630, 271, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Amount");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 89, 26));
        jPanel3.add(TextSenderNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 549, 301, -1));

        btnPayment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPayment.setIcon(new javax.swing.ImageIcon("C:\\Users\\rkrah\\OneDrive\\Desktop\\BKash-Logo.wine_1_150x40.png")); // NOI18N
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        jPanel3.add(btnPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 670, 210, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Full Name");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 83, 26));
        jPanel3.add(TextPayableAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 301, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Reference No");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, -1, 26));
        jPanel3.add(TextReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 468, 301, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        
        int id = Integer.parseInt(getTextUserID().getText());
        controller.payment(id);
        
    }//GEN-LAST:event_btnPaymentActionPerformed

  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaymentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBkash;
    private javax.swing.JTextField TextPayAmount;
    private javax.swing.JTextField TextPayableAmount;
    private javax.swing.JTextField TextReference;
    private javax.swing.JTextField TextSenderNumber;
    private javax.swing.JTextField TextUserFullName;
    private javax.swing.JTextField TextUserID;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPayment;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
