package com.mycompany.mamakhali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setUndecorated(true);

        jPanel1 = new javax.swing.JPanel();
        login = createButton("Login");
        signup = createButton("Signup");
        exitButton = createButton("Exit");

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        String imagePath = "/Users/ziadtahzeeb/Downloads/MamaKhali.jpg"; // Update as needed
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();

        int windowWidth = 800;
        int windowHeight = 500;

        Image scaledImage = image.getScaledInstance(windowWidth, windowHeight, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

        imageLabel.setBounds(0, 0, windowWidth, windowHeight);

        // Centering the buttons
        int baseX = (windowWidth - 300) / 2; // Center horizontally
        int baseY = windowHeight / 2 - 40; // Center vertically

        // Set button positions
        login.setBounds( baseX+200, baseY, 175, 50);
        signup.setBounds(baseX+275, baseY + 95, 185, 50);
        exitButton.setBounds(baseX+365, baseY + 187, 170, 50);

        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(login, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(signup, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(exitButton, JLayeredPane.PALETTE_LAYER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(layeredPane, BorderLayout.CENTER);

        login.addActionListener(this::loginActionPerformed);
        signup.addActionListener(this::signupActionPerformed);
        exitButton.addActionListener(evt -> System.exit(0)); // Close application directly
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(70, 130, 180)); // Set background color
        button.setForeground(Color.WHITE); // Set text color
        button.setFont(new Font("Times new Roman", Font.BOLD, 23)); // Set font size
        button.setFocusPainted(false); // Remove focus painting

        // Adding hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255)); // Change color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180)); // Reset color
            }
        });

        return button;
    }

    private void loginActionPerformed(ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        setVisible(false);
    }

    private void signupActionPerformed(ActionEvent evt) {
        Signup sn = new Signup();
        sn.setVisible(true);
        setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Welcome().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton login;
    private javax.swing.JButton signup;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel1;
}
