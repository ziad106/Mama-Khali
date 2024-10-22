package com.mycompany.mamakhali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Payment extends javax.swing.JFrame {
    private int fare;

    public Payment(int fare) {
        initComponents();
        this.fare = fare;
        displayFare();
        setLocationRelativeTo(null);
    }

    private void displayFare() {
        fareLabel.setText("Your fare is: " + fare + " Taka");
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fareLabel = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("Payment");

        fareLabel.setText("Fare: ");

        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fareLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(18, 18, 18)
                                .addComponent(payButton)))
                        .addGap(64, 64, 64))
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(fareLabel)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payButton)
                    .addComponent(backButton))
                .addGap(60, 60, 60)
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
        setLocationRelativeTo(null);
    }

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int fareAmount = fare;
        String username = Session.username;
        String password = Session.password;

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please insert username and password");
            return;
        }

        Connect connect = new Connect();
        try (Connection connection = connect.getConnection()) {
            String selectQuery = "SELECT balance FROM regi WHERE name = ? AND password = ?";
            try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int currentBalance = rs.getInt("balance");
                    int newBalance = currentBalance - fareAmount;

                    String updateQuery = "UPDATE regi SET balance = ? WHERE name = ? AND password = ?";
                    try (PreparedStatement updatePs = connection.prepareStatement(updateQuery)) {
                        updatePs.setInt(1, newBalance);
                        updatePs.setString(2, username);
                        updatePs.setString(3, password);
                        int rowsUpdated = updatePs.executeUpdate();

                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(this, "Payment Successful! Your updated balance is: " + newBalance);
                        } else {
                            JOptionPane.showMessageDialog(this, "No records updated. Username or password not found.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username or Password does not match");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error processing payment: " + ex.getMessage());
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Destination dest = new Destination();
        dest.setVisible(true);
        setVisible(false);
    }

    private javax.swing.JLabel fareLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}
