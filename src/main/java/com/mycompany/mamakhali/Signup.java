package com.mycompany.mamakhali;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;  // <-- Import for EmptyBorder

public class Signup extends javax.swing.JFrame {
    
    private JPanel imagePanel;  // <-- Declare imagePanel

    public Signup() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sign Up");
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Create main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));  // Two columns layout
        
        // Create image panel
        imagePanel = new JPanel() {  // <-- Initialize imagePanel here
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the image
                ImageIcon imageIcon = new ImageIcon("/Users/mohaiminul/Downloads/Signup.png");
                if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                    Image image = imageIcon.getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        // Create form panel
        formPanel = new JPanel();
        formPanel.setLayout(null);  // Absolute positioning
        formPanel.setBackground(new Color(40, 40, 40));  // Dark background
        
        // Initialize components with modern styling
        user = new JTextField();
        pass = new JPasswordField();
        email = new JTextField();
        phone = new JTextField();
        save = new JButton("Sign Up");
        
        // Style labels
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        jLabel1 = new JLabel("Username");
        jLabel2 = new JLabel("Password");
        jLabel3 = new JLabel("Email");
        jLabel4 = new JLabel("Phone");
        
        // Apply styles to labels
        for (JLabel label : new JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4}) {
            label.setFont(labelFont);
            label.setForeground(Color.WHITE);
        }
        
        // Style text fields
        for (JTextField field : new JTextField[]{user, pass, email, phone}) {
            field.setBackground(Color.WHITE);
            field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(8, 12, 8, 12)  // <-- Use EmptyBorder here
            ));
            field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
        
        // Style signup button
        save.setBackground(new Color(255, 69, 0));  // Orange-red color
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Segoe UI", Font.BOLD, 14));
        save.setBorder(new EmptyBorder(10, 30, 10, 30));  // <-- Use EmptyBorder here
        save.setFocusPainted(false);
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.addActionListener(evt -> saveActionPerformed(evt));
        
        // Position components
        int startY = 150;
        int labelX = 50;
        int fieldX = 150;
        int spacing = 60;
        
        // Set bounds for all components
        jLabel1.setBounds(labelX, startY, 80, 25);
        user.setBounds(fieldX, startY, 200, 35);
        
        jLabel2.setBounds(labelX, startY + spacing, 80, 25);
        pass.setBounds(fieldX, startY + spacing, 200, 35);
        
        jLabel3.setBounds(labelX, startY + spacing * 2, 80, 25);
        email.setBounds(fieldX, startY + spacing * 2, 200, 35);
        
        jLabel4.setBounds(labelX, startY + spacing * 3, 80, 25);
        phone.setBounds(fieldX, startY + spacing * 3, 200, 35);
        
        save.setBounds(150, startY + spacing * 4, 200, 45);
        
        // Add components to form panel
        formPanel.add(jLabel1);
        formPanel.add(user);
        formPanel.add(jLabel2);
        formPanel.add(pass);
        formPanel.add(jLabel3);
        formPanel.add(email);
        formPanel.add(jLabel4);
        formPanel.add(phone);
        formPanel.add(save);
        
        // Add panels to main panel
        mainPanel.add(imagePanel);
        mainPanel.add(formPanel);
        
        // Set frame properties
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel);
        setSize(800, 500);
    }

private void saveActionPerformed(java.awt.event.ActionEvent evt) {
    Connect connect = new Connect();
    try (Connection connection = connect.getConnection()) {
        String sname = user.getText();
        String spass = new String(pass.getPassword());
        String semail = email.getText();
        String sphone = phone.getText();

        // Validate that all fields are filled
        if (sname.isEmpty() || spass.isEmpty() || semail.isEmpty() || sphone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required");
            return;
        }

        // Default values
        int balance = 100;  // Default balance
        int numofrid = 0;   // Default number of rides

        // SQL query for regi table
        String sql = "INSERT INTO regi (name, password, email, phone, balance, numofrid) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sname);
            pstmt.setString(2, spass);
            pstmt.setString(3, semail);
            pstmt.setString(4, sphone);
            pstmt.setInt(5, balance);
            pstmt.setInt(6, numofrid);
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            
            // Optionally clear the fields after successful registration
            user.setText("");
            pass.setText("");
            email.setText("");
            phone.setText("");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, 
            "Error during registration: " + ex.getMessage(), 
            "Registration Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}


    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new Signup().setVisible(true));
    }

    // Variables declaration
    private JPanel mainPanel;
    private JPanel formPanel;
    private JTextField user;
    private JPasswordField pass;
    private JTextField email;
    private JTextField phone;
    private JButton save;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
}
