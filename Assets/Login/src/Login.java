package com.mycompany.mamakhali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    // Declare components
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;
    private JButton exitButton;
    private Image backgroundImage;

    public Login() {
        // Load the background image
        backgroundImage = new ImageIcon("D:/Looming/Mama-Khali/Assets/BG.jpeg").getImage();
        initComponents();
    }

    private void initComponents() {
        // Set up the frame
        setTitle("Mama Khali? Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        mainPanel = new BackgroundPanel(); // Custom panel with background image
        titleLabel = new JLabel("Mama Khali?");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");

        // Set fonts
        Font titleFont = new Font("SansSerif", Font.BOLD, 24);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);

        titleLabel.setFont(titleFont);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        loginButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Set text color to white
        titleLabel.setForeground(Color.WHITE);
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        loginButton.setForeground(Color.WHITE);
        backButton.setForeground(Color.WHITE);
        exitButton.setForeground(Color.WHITE);

        // Layout and add components to panel
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Center the title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        // Layout for buttons
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);
        buttonPanel.add(exitButton);
        mainPanel.add(buttonPanel, gbc);

        // Make button panel background transparent
        buttonPanel.setOpaque(false);

        // Add main panel to frame
        add(mainPanel);

        // Action listeners for buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Handle login logic here
                JOptionPane.showMessageDialog(null, "Login button clicked");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle back action
                JOptionPane.showMessageDialog(null, "Back button clicked");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Custom JPanel class to paint the background image
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
