package com.mycompany.mamakhali;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

// AccountInfoDialog class
class AccountInfoDialog extends JDialog {
    public AccountInfoDialog(Frame parent, String name, String email, String phone, 
                           double balance, int numOfRides, String created_at) {
        super(parent, "Account Information", true);
        
        // Create main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        mainPanel.setBackground(Color.WHITE);

        // Add title
        JLabel titleLabel = new JLabel("Account Details");
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Create info panel
        JPanel infoPanel = new JPanel(new GridLayout(6, 2, 10, 15));
        infoPanel.setBackground(Color.WHITE);

        // Helper method to create styled labels
        Font labelFont = new Font("MV Boli", Font.BOLD, 14);
        Font valueFont = new Font("MV Boli", Font.PLAIN, 14);

        addField(infoPanel, "Name:", name, labelFont, valueFont);
        addField(infoPanel, "Email:", email, labelFont, valueFont);
        addField(infoPanel, "Phone:", phone, labelFont, valueFont);
        addField(infoPanel, "Balance:", String.format("TK%.2f", balance), labelFont, valueFont);
        addField(infoPanel, "Total Rides:", String.valueOf(numOfRides), labelFont, valueFont);
        addField(infoPanel, "Member Since:", created_at.split(" ")[0], labelFont, valueFont);

        mainPanel.add(infoPanel);

        // Add close button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("MV Boli", Font.PLAIN, 14));
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(e -> dispose());
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(closeButton);

        setContentPane(mainPanel);
        setSize(400, 450);
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    private void addField(JPanel panel, String label, String value, Font labelFont, Font valueFont) {
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(labelFont);
        
        JLabel valueComponent = new JLabel(value);
        valueComponent.setFont(valueFont);
        
        panel.add(labelComponent);
        panel.add(valueComponent);
    }
}

// Main UserPage class
public class UserPage extends javax.swing.JFrame {
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JButton requestRideBtn;
    private javax.swing.JButton accountInfoBtn;
    private javax.swing.JButton rechargeBalanceBtn;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel mainPanel;
    private Connect dbConnect;

    public UserPage() {
        initComponents();
        setTitle("Mama Khali - User Page");
        dbConnect = new Connect();
    }

    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        requestRideBtn = new javax.swing.JButton();
        accountInfoBtn = new javax.swing.JButton();
        rechargeBalanceBtn = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        mainPanel.setLayout(null);

        // Welcome Label
        welcomeLabel.setFont(new java.awt.Font("Magnolia Script", 1, 32));
        welcomeLabel.setText("Welcome back, " + Session.getUsername());
        welcomeLabel.setBounds(40, 20, 400, 40);
        mainPanel.add(welcomeLabel);

        // Request Ride Button
        requestRideBtn.setText("Request Ride");
        requestRideBtn.setFont(new java.awt.Font("MV Boli", 1, 13));
        requestRideBtn.setBounds(180, 378, 138, 33);
        requestRideBtn.setBackground(java.awt.Color.BLACK);
        requestRideBtn.setForeground(java.awt.Color.WHITE);
        requestRideBtn.setOpaque(true);
        requestRideBtn.setBorderPainted(false);
        requestRideBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestRideBtnActionPerformed(evt);
            }
        });
        mainPanel.add(requestRideBtn);

        // Account Information Button
        accountInfoBtn.setText("Account Information");
        accountInfoBtn.setFont(new java.awt.Font("MV Boli", 0, 10));
        accountInfoBtn.setBounds(33, 420, 147, 30);
        accountInfoBtn.setBackground(java.awt.Color.BLACK);
        accountInfoBtn.setForeground(java.awt.Color.WHITE);
        accountInfoBtn.setOpaque(true);
        accountInfoBtn.setBorderPainted(false);
        accountInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountInfoBtnActionPerformed(evt);
            }
        });
        mainPanel.add(accountInfoBtn);

        // Recharge Balance Button
        rechargeBalanceBtn.setText("Recharge Balance");
        rechargeBalanceBtn.setFont(new java.awt.Font("MV Boli", 0, 11));
        rechargeBalanceBtn.setBounds(327, 420, 140, 30);
        rechargeBalanceBtn.setBackground(java.awt.Color.BLACK);
        rechargeBalanceBtn.setForeground(java.awt.Color.WHITE);
        rechargeBalanceBtn.setOpaque(true);
        rechargeBalanceBtn.setBorderPainted(false);
        rechargeBalanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechargeBalanceBtnActionPerformed(evt);
            }
        });
        mainPanel.add(rechargeBalanceBtn);

        // Background Label with Image
        backgroundLabel.setIcon(new javax.swing.ImageIcon("/Users/mohaiminul/Downloads/Welcome back, username.png")); 
        backgroundLabel.setBounds(0, 0, 500, 480);
        mainPanel.add(backgroundLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void requestRideBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Destination destinationPage = new Destination();
        destinationPage.setVisible(true);
        this.dispose();
    }

    // In both the accountInfoBtnActionPerformed and rechargeBalanceBtnActionPerformed methods,
// modify the SQL queries to include the WHERE clause for the current user.
// Here are the corrected methods:

private void accountInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        Connection conn = dbConnect.getConnection();
        String query = "SELECT * FROM regi WHERE name = ?";  // Add WHERE clause
        java.sql.PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, Session.getUsername());  // Use session username
        java.sql.ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double balance = rs.getDouble("balance");
            int numOfRides = rs.getInt("numofrid");
            String createdAt = rs.getString("created_at");

            AccountInfoDialog dialog = new AccountInfoDialog(
                this, name, email, phone, balance, numOfRides, createdAt
            );
            dialog.setVisible(true);
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error retrieving account information: " + e.getMessage(),
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

private void rechargeBalanceBtnActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        // First get current balance for the logged-in user
        Connection conn = dbConnect.getConnection();
        String query = "SELECT balance FROM regi WHERE name = ?";  // Add WHERE clause
        java.sql.PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, Session.getUsername());  // Use session username
        java.sql.ResultSet rs = pst.executeQuery();
        
        double currentBalance = 0.0;
        if (rs.next()) {
            currentBalance = rs.getDouble("balance");
        }
        
        // Create custom dialog
        JDialog rechargeDialog = new JDialog(this, "Recharge Balance", true);
        rechargeDialog.setLayout(new BorderLayout());
        
        // Main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        mainPanel.setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel("Recharge Your Balance");
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Current Balance Display
        JLabel currentBalanceLabel = new JLabel(String.format("Current Balance: TK.%.2f", currentBalance));
        currentBalanceLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        currentBalanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(currentBalanceLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 15));
        formPanel.setBackground(Color.WHITE);

        // Components
        JLabel amountLabel = new JLabel("Recharge Amount (TK):");
        JTextField amountField = new JTextField();
        JLabel transactionLabel = new JLabel("Transaction ID:");
        JTextField transactionField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Style labels
        Font labelFont = new Font("MV Boli", Font.BOLD, 14);
        amountLabel.setFont(labelFont);
        transactionLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        // Add components to form
        formPanel.add(amountLabel);
        formPanel.add(amountField);
        formPanel.add(transactionLabel);
        formPanel.add(transactionField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        mainPanel.add(formPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);

        JButton confirmButton = new JButton("Confirm Recharge");
        JButton cancelButton = new JButton("Cancel");

        // Style buttons
        confirmButton.setFont(new Font("MV Boli", Font.PLAIN, 14));
        confirmButton.setBackground(Color.BLACK);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setOpaque(true);
        confirmButton.setBorderPainted(false);

        cancelButton.setFont(new Font("MV Boli", Font.PLAIN, 14));
        cancelButton.setBackground(new Color(200, 200, 200));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setOpaque(true);
        cancelButton.setBorderPainted(false);

        // Add action listeners
        confirmButton.addActionListener(e -> {
            try {
                // Validate amount
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= 0) {
                    throw new NumberFormatException();
                }

                // Validate transaction ID is not empty
                if (transactionField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rechargeDialog,
                        "Please enter a Transaction ID!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password
                String password = new String(passwordField.getPassword());
                String checkPassQuery = "SELECT password FROM regi WHERE name = ?";  // Add WHERE clause
                java.sql.PreparedStatement passCheck = conn.prepareStatement(checkPassQuery);
                passCheck.setString(1, Session.getUsername());  // Use session username
                java.sql.ResultSet passRs = passCheck.executeQuery();

                if (passRs.next() && passRs.getString("password").equals(password)) {
                    // Update balance for the specific user
                    String updateQuery = "UPDATE regi SET balance = balance + ? WHERE name = ?";  // Add WHERE clause
                    java.sql.PreparedStatement updatePst = conn.prepareStatement(updateQuery);
                    updatePst.setDouble(1, amount);
                    updatePst.setString(2, Session.getUsername());  // Use session username
                    updatePst.executeUpdate();

                    // Show success message with new balance
                    String newBalanceQuery = "SELECT balance FROM regi WHERE name = ?";  // Add WHERE clause
                    java.sql.PreparedStatement newBalancePst = conn.prepareStatement(newBalanceQuery);
                    newBalancePst.setString(1, Session.getUsername());  // Use session username
                    java.sql.ResultSet newBalanceRs = newBalancePst.executeQuery();
                    
                    if (newBalanceRs.next()) {
                        double newBalance = newBalanceRs.getDouble("balance");
                        JOptionPane.showMessageDialog(rechargeDialog,
                            String.format("Balance successfully recharged!\nNew Balance: TK.%.2f", newBalance),
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    rechargeDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(rechargeDialog,
                        "Invalid password!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rechargeDialog,
                    "Please enter a valid positive amount!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rechargeDialog,
                    "Error processing recharge: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> rechargeDialog.dispose());

        buttonPanel.add(confirmButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(cancelButton);

        mainPanel.add(buttonPanel);

        // Add main panel to dialog
        rechargeDialog.add(mainPanel);
        rechargeDialog.setSize(400, 450);
        rechargeDialog.setLocationRelativeTo(this);
        rechargeDialog.setResizable(false);
        rechargeDialog.setVisible(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error opening recharge dialog: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new UserPage().setVisible(true));
    }
}