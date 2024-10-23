package com.mycompany.mamakhali;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setUndecorated(true);

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        // Window size
        int windowWidth = 500;
        int windowHeight = 500;

        // Background image setup
        String imagePath = "/Users/ziadtahzeeb/Downloads/FinalWelcome.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(windowWidth, windowHeight, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(0, 0, windowWidth, windowHeight);

        // Custom button class for unique look
        class StylishButton extends JButton {
            private Color hoverColor;
            private Color normalColor;
            private String buttonType;

            public StylishButton(String text, Color normalColor, Color hoverColor, String buttonType) {
                super(text);
                this.normalColor = normalColor;
                this.hoverColor = hoverColor;
                this.buttonType = buttonType;
                setupButton();
            }

            private void setupButton() {
                setContentAreaFilled(false);
                setFocusPainted(false);
                setBorderPainted(false);
                setOpaque(false);

                // Custom font based on button type
                if ("login".equals(buttonType)) {
                    setFont(new Font("Segoe UI", Font.BOLD, 16));
                } else if ("signup".equals(buttonType)) {
                    setFont(new Font("Segoe UI", Font.BOLD, 15));
                } else {
                    setFont(new Font("Segoe UI", Font.BOLD, 14));
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Get current background color based on hover state
                Color currentColor = getModel().isRollover() ? hoverColor : normalColor;

                // Create gradient paint
                GradientPaint gp = new GradientPaint(0, 0, 
                    new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), 240),
                    0, getHeight(),
                    new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), 180));
                g2.setPaint(gp);

                // Draw rounded rectangle background
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 20, 20));

                // Add subtle border
                g2.setColor(new Color(255, 255, 255, 100));
                g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 20, 20));

                // Add shadow effect
                if ("login".equals(buttonType)) {
                    g2.setColor(new Color(0, 0, 0, 30));
                    g2.fill(new RoundRectangle2D.Double(2, 2, getWidth() - 1, getHeight() - 1, 20, 20));
                }

                g2.dispose();

                super.paintComponent(g);
            }
        }

        // Create buttons with unique styles
        login = new StylishButton("Login", new Color(70, 130, 180), new Color(100, 149, 237), "login");
        signup = new StylishButton("Signup", new Color(60, 179, 113), new Color(46, 139, 87), "signup");
        jButton1 = new StylishButton("Exit", new Color(205, 92, 92), new Color(220, 20, 60), "exit");

        // Set text colors
        login.setForeground(Color.WHITE);
        signup.setForeground(Color.WHITE);
        jButton1.setForeground(Color.WHITE);

        // Adjust button sizes
        Dimension buttonSize = new Dimension(110, 40);
        login.setPreferredSize(buttonSize);
        signup.setPreferredSize(buttonSize);
        jButton1.setPreferredSize(buttonSize);

        // Position buttons in staircase pattern (moved more to the left)
        int startX = windowWidth - 250; // Starting X position moved left
        int startY = windowHeight / 2 - 20; // Slightly higher starting position
        int stepX = 30; // Horizontal step between buttons
        int stepY = 55; // Vertical step between buttons

        login.setBounds(startX, startY, 110, 40);
        signup.setBounds(startX + stepX, startY + stepY, 110, 40);
        jButton1.setBounds(startX + (2 * stepX), startY + (2 * stepY), 110, 40);

        // Add components
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(login, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(signup, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(jButton1, JLayeredPane.PALETTE_LAYER);

        // Window setup
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(layeredPane, BorderLayout.CENTER);

        // Add action listeners
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
    private JButton login;
    private JButton signup;
    private JButton jButton1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JPanel jPanel1;
}