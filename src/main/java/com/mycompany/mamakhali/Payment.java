package com.mycompany.mamakhali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Payment extends javax.swing.JFrame {

    public Payment() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        paySubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setText("Payment");

        paySubmit.setText("Submit Payment");
        paySubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paySubmitActionPerformed(evt);
            }
        });

        // Layout setup (you can customize it as per your requirements)
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(paySubmit))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(paySubmit)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void paySubmitActionPerformed(java.awt.event.ActionEvent evt) {
        String username = Session.username;
        String password = Session.password;

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Insert user name and password");
            return;
        }

        Connect connect = new Connect();
        try (Connection connection = connect.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM regi")) {

            boolean ok = false;

            while (rs.next()) {
                String getId = rs.getString("name");
                String getPass = rs.getString("password");
                if (username.equals(getId) && password.equals(getPass)) {
                    int tk = rs.getInt("balance") - 10;
                    int rid = rs.getInt("numofrid") + 1;

                    String updateQuery = "UPDATE regi SET balance=?, numofrid=? WHERE name=? AND password=?";
                    try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
                        ps.setInt(1, tk);
                        ps.setInt(2, rid);
                        ps.setString(3, username);
                        ps.setString(4, password);

                        int rowsUpdated = ps.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "Ride has been done\nYour account balance is : " + tk);
                            Welcome wc = new Welcome();
                            wc.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "No records updated. Username or password not found.");
                        }
                    }
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                JOptionPane.showMessageDialog(null, "Username or Password does not match");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Payment().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton paySubmit;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}