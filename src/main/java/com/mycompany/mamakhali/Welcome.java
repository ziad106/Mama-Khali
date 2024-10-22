package com.mycompany.mamakhali;

import javax.swing.*;
import java.awt.*;
//hello
public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        JLabel imageLabel = new JLabel();

        // Path to your image
        String imagePath = "/Users/ziadtahzeeb/Desktop/Screenshot 2024-10-20 at 2.50.47 PM.png";
        
        // Load and resize the image (600x400 can be adjusted to your preferred size)
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));

        // Set the layout manager
        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(Color.WHITE);  // Set the panel background to white

        // Add the image to the center of the panel
        jPanel1.add(imageLabel, BorderLayout.CENTER);

        // Create the buttons panel for alignment
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.setBackground(Color.WHITE);  // Set buttons panel background to white

        // Customize login button (ensure the text color is visible)
        login.setText("Login");
        login.setBackground(Color.LIGHT_GRAY);  // Set background color
        login.setForeground(Color.BLACK);  // Ensure text color is visible (Black text)
        login.setFont(new Font("MV Boli", Font.PLAIN, 16));  // Set custom font size
        buttonsPanel.add(login);

        // Customize signup button
        signup.setText("Signup");
        signup.setBackground(Color.LIGHT_GRAY);  // Set background color
        signup.setForeground(Color.BLACK);  // Set text color to Black
        signup.setFont(new Font("Arial", Font.PLAIN, 16));  // Set custom font size
        buttonsPanel.add(signup);

        // Customize finish button
        jButton1.setText("Finish");
        jButton1.setBackground(Color.LIGHT_GRAY);  // Set background color
        jButton1.setForeground(Color.BLACK);  // Set text color to Black
        jButton1.setFont(new Font("Arial", Font.PLAIN, 16));  // Set custom font size
        buttonsPanel.add(jButton1);

        // Add the buttons panel at the bottom
        jPanel1.add(buttonsPanel, BorderLayout.SOUTH);

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       

        // Set up the frame layout
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
       

        // Assign action listeners to the buttons here
        login.addActionListener(evt -> loginActionPerformed(evt));
        signup.addActionListener(evt -> signupActionPerformed(evt));
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
    }

    // Event handlers for the buttons
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);  // Open the Login window
        setVisible(false);    // Hide the Welcome window
    }

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {
        Signup sn = new Signup();
        sn.setVisible(true);  // Open the Signup window
        setVisible(false);    // Hide the Welcome window
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);    // Close the Welcome window
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Welcome().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton login;
    private javax.swing.JButton signup;
    private javax.swing.JButton jButton1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JPanel jPanel1;
}
