package com.mycompany.mamakhali;

import javax.swing.*;
import java.awt.*;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setUndecorated(true);

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        String imagePath = "/Users/ziadtahzeeb/Downloads/MamaKhali.jpg";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        
        int windowWidth = 800;
        int windowHeight = 500;
        
        Image scaledImage = image.getScaledInstance(windowWidth, windowHeight, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        
        imageLabel.setBounds(0, 0, windowWidth, windowHeight);
        
        login = new JButton("Login");
        signup = new JButton("Signup");
        jButton1 = new JButton("Exit");

        Color buttonColor = new Color(200, 200, 200, 200);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Dimension buttonSize = new Dimension(120, 40);
        
        for (JButton button : new JButton[]{login, signup, jButton1}) {
            button.setBackground(buttonColor);
            button.setForeground(Color.BLACK);
            button.setFont(buttonFont);
            button.setPreferredSize(buttonSize);
            button.setSize(buttonSize);
            button.setBorder(BorderFactory.createRaisedBevelBorder());
            button.setFocusPainted(false);
            button.setOpaque(true);
        }

        // Adjusted button positions:
        // Login highest and leftmost (but still on right side of screen)
        // Signup lower and more right
        // Exit lowest and rightmost
        int baseX = windowWidth - 450; // Starting more towards the right side
        int baseY = windowHeight - 300; // Higher base position
        
        // Login button - highest and leftmost
        login.setBounds(baseX, baseY, 120, 40);
        
        // Signup button - middle position, moved right and down
        signup.setBounds(baseX + 150, baseY + 80, 120, 40);
        
        // Exit button - lowest and rightmost
        jButton1.setBounds(baseX + 300, baseY + 160, 120, 40);

        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(login, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(signup, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(jButton1, JLayeredPane.PALETTE_LAYER);

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(layeredPane);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(layeredPane, BorderLayout.CENTER);

        login.addActionListener(evt -> loginActionPerformed(evt));
        signup.addActionListener(evt -> signupActionPerformed(evt));
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        setVisible(false);
    }

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {
        Signup sn = new Signup();
        sn.setVisible(true);
        setVisible(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
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