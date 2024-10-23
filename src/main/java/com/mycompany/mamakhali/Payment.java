package com.mycompany.mamakhali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Payment extends javax.swing.JFrame {
    private int fare;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel fareLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton rechargeButton; // New recharge button

    public Payment(int fare) {
        this.fare = fare;
        initComponents();
        displayFare();
        setLocationRelativeTo(null);
        
        JLabel background = new JLabel(new ImageIcon("/Users/ziadtahzeeb/Downloads/Payment.png"));
        background.setBounds(0, 0, 400, 300);
        mainPanel.add(background);
    }

    private void displayFare() {
        fareLabel.setText("Your fare is: " + fare + " Taka");
    }

    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        fareLabel = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        rechargeButton = new javax.swing.JButton(); // Initialize recharge button

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        mainPanel.setLayout(null);

        // Configure labels
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        titleLabel.setText("Payment");
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setBounds(50, 40, 300, 30);
        mainPanel.add(titleLabel);

        fareLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        fareLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fareLabel.setBounds(50, 100, 300, 30);
        mainPanel.add(fareLabel);

        // Configure buttons
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        backButton.setText("Back");
        backButton.setBounds(85, 170, 100, 35);
        backButton.addActionListener(evt -> backButtonActionPerformed(evt));
        mainPanel.add(backButton);

        payButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        payButton.setText("Pay");
        payButton.setBounds(215, 170, 100, 35);
        payButton.addActionListener(evt -> payButtonActionPerformed(evt));
        payButton.setFocusPainted(true);
        mainPanel.add(payButton);

        // Configure recharge button (initially invisible)
        rechargeButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        rechargeButton.setText("Recharge Balance");
        rechargeButton.setBounds(130, 220, 140, 35);
        rechargeButton.addActionListener(evt -> rechargeButtonActionPerformed(evt));
        rechargeButton.setVisible(false); // Initially hidden
        mainPanel.add(rechargeButton);

        getContentPane().add(mainPanel);
        pack();
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
                    
                    if (newBalance < 0) {
                        JOptionPane.showMessageDialog(this, 
                            "Insufficient balance. Your current balance is: " + currentBalance + " Taka\n" +
                            "Please recharge your balance to continue.");
                        rechargeButton.setVisible(true); // Show recharge button
                        return;
                    }
                    
                    String updateQuery = "UPDATE regi SET balance = ? WHERE name = ? AND password = ?";
                    
                    try (PreparedStatement updatePs = connection.prepareStatement(updateQuery)) {
                        updatePs.setInt(1, newBalance);
                        updatePs.setString(2, username);
                        updatePs.setString(3, password);
                        int rowsUpdated = updatePs.executeUpdate();

                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(this, "Payment Successful!\nYour updated balance is: " + newBalance + " Taka");
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Payment failed. Please try again.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Authentication failed. Please check your credentials.");
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

    private void rechargeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserPage userPage = new UserPage();
        userPage.setVisible(true);
        setVisible(false);
    }
}