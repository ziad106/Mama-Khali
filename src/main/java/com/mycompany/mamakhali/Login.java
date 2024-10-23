package com.mycompany.mamakhali;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends javax.swing.JFrame {
    
    private Image backgroundImage;

    public Login() {
        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("/Users/mohaiminul/Downloads/Ju_aest.png")); // Set your image path here
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new BackgroundPanel(); // Custom JPanel with a background image
        uname = new javax.swing.JTextField();
        upass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Modify the panel background color to make it transparent
        jPanel1.setLayout(null);

        // Username Label
        jLabel1.setText("Username");
        jLabel1.setForeground(Color.BLACK); // Text color to contrast with the background
        jLabel1.setBounds(50, 50, 100, 30);
        jPanel1.add(jLabel1);

        // Username TextField
        uname.setBounds(150, 50, 150, 30);
        jPanel1.add(uname);

        // Password Label
        jLabel2.setText("Password");
        jLabel2.setForeground(Color.BLACK); // Text color to contrast with the background
        jLabel2.setBounds(50, 100, 100, 30);
        jPanel1.add(jLabel2);

        // Password TextField
        upass.setBounds(150, 100, 150, 30);
        jPanel1.add(upass);

        // Login Button
        jButton1.setText("Login");
        jButton1.setBounds(150, 150, 150, 30);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    // BackgroundPanel class to set the background image
    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = uname.getText();
        String pass = new String(upass.getPassword());

        if (name.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please insert user name and password");
            return;
        }

        Connect connect = new Connect();
        try (Connection connection = connect.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM regi")) {

            boolean loginSuccess = false;

            while (rs.next()) {
                String getId = rs.getString("name");
                String getPass = rs.getString("password");
                if (name.equals(getId) && pass.equals(getPass)) {
                    Session.username = name;
                    Session.password = pass;
                    UserPage st = new UserPage();
                    st.setVisible(true);
                    setVisible(false);
                    loginSuccess = true;
                    break;
                }
            }
            if (!loginSuccess) {
                JOptionPane.showMessageDialog(null, "User name or password does not match");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField uname;
    private javax.swing.JPasswordField upass;
}