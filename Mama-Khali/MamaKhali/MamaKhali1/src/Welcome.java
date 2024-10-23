package com.mykhali.project;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {

    public Welcome() {
        initComponents();  // Initialize the components of the JFrame
    }

    private void initComponents() {
        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 204));  // Set a soft yellow background color

        // Set layout to BoxLayout for vertical alignment of components
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create and configure JLabel for welcome message
        JLabel welcomeLabel = new JLabel("Welcome to Mama Khali?");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 32));  // Use a stylish font for the welcome message
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center-align the label

        // Add some padding around the welcome label
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Create and configure JButton for login
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Set button font and size
        loginButton.setBackground(new Color(0, 102, 204));  // Set button background color
        loginButton.setForeground(Color.WHITE);  // Set button text color to white for visibility
        loginButton.setOpaque(true);  // Ensure the background color is painted
        loginButton.setBorderPainted(false);  // Remove button border for a cleaner look
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center-align the button
        loginButton.addActionListener(evt -> loginButtonActionPerformed(evt));  // Set action listener

        // Add components to the JPanel
        panel.add(welcomeLabel);
        panel.add(loginButton);

        // Add JPanel to the JFrame
        this.add(panel);

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the application when window is closed
        setTitle("Mama Khali?");
        setSize(400, 250);  // Adjust window size to fit new layout
        setLocationRelativeTo(null);  // Center the window
    }

    // Action performed method for the "Login" button
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Please login to continue.");  // Show a dialog when the button is clicked
    }

    // Main method to run the application
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Welcome().setVisible(true);  // Create and display the Welcome window
        });
    }
}
