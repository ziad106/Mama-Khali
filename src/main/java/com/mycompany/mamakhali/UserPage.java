package com.mycompany.mamakhali;

public class UserPage extends javax.swing.JFrame {
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JButton requestRideBtn;
    private javax.swing.JButton accountInfoBtn;
    private javax.swing.JButton rechargeBalanceBtn;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel mainPanel;

    public UserPage() {
        initComponents();
        setTitle("Mama Khali - User Page");
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
        mainPanel.setLayout(null);  // Using absolute layout for precise positioning

        // Welcome Label
        welcomeLabel.setFont(new java.awt.Font("Magnolia Script", 1, 32));
        welcomeLabel.setText("Welcome back, " + Session.getUsername());
        welcomeLabel.setBounds(40, 20, 400, 40);
        mainPanel.add(welcomeLabel);

        // Request Ride Button (Moved up 2 pixels, made smaller)
        requestRideBtn.setText("Request Ride");
        requestRideBtn.setFont(new java.awt.Font("MV Boli", 1, 13));  // Slightly smaller font
        requestRideBtn.setBounds(180, 378, 138, 33);  // Moved 2 pixels up, slightly smaller
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

        // Account Information Button (Moved left and width increased)
        accountInfoBtn.setText("Account Information");
        accountInfoBtn.setFont(new java.awt.Font("MV Boli", 0, 10));  // Smaller font size
        accountInfoBtn.setBounds(33, 420, 147, 30);  // Moved left and width increased by 7 pixels
        accountInfoBtn.setBackground(java.awt.Color.BLACK);
        accountInfoBtn.setForeground(java.awt.Color.WHITE);
        accountInfoBtn.setOpaque(true);
        accountInfoBtn.setBorderPainted(false);
        mainPanel.add(accountInfoBtn);

        // Recharge Balance Button (Moved right slightly)
        rechargeBalanceBtn.setText("Recharge Balance");
        rechargeBalanceBtn.setFont(new java.awt.Font("MV Boli", 0, 11));  // Smaller font size
        rechargeBalanceBtn.setBounds(327, 420, 140, 30);  // Moved right slightly
        rechargeBalanceBtn.setBackground(java.awt.Color.BLACK);
        rechargeBalanceBtn.setForeground(java.awt.Color.WHITE);
        rechargeBalanceBtn.setOpaque(true);
        rechargeBalanceBtn.setBorderPainted(false);
        mainPanel.add(rechargeBalanceBtn);

        // Background Label with Image
        backgroundLabel.setIcon(new javax.swing.ImageIcon("/Users/ziadtahzeeb/Downloads/Welcome back, username.png")); 
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UserPage().setVisible(true));
    }
}
