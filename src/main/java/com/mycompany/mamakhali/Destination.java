package com.mycompany.mamakhali;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public void setBackgroundImage(String imagePath) {
        if (imagePath != null) {
            backgroundImage = new ImageIcon(imagePath).getImage();
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class Destination extends javax.swing.JFrame {
    private javax.swing.JButton confirmRide;
    private javax.swing.JComboBox<String> destination;
    private javax.swing.JComboBox<String> source;
    private javax.swing.JComboBox<String> vehicle;
    private javax.swing.JButton backButton;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JLabel vehicleLabel;
    private BackgroundPanel mainPanel;
    private javax.swing.JLabel welcomeLabel;

    public Destination() {
        initComponents();
        setLocationRelativeTo(null);
        
        String username = Session.getUsername();
        welcomeLabel.setText("Hi " + username + ", where are we heading?");
        
        // To set background image, call:
        mainPanel.setBackgroundImage("/Users/ziadtahzeeb/Downloads/Distance.png");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        mainPanel = new BackgroundPanel();
        welcomeLabel = new javax.swing.JLabel();
        sourceLabel = new javax.swing.JLabel();
        destinationLabel = new javax.swing.JLabel();
        vehicleLabel = new javax.swing.JLabel();
        
        source = new javax.swing.JComboBox<>();
        destination = new javax.swing.JComboBox<>();
        vehicle = new javax.swing.JComboBox<>();
        
        confirmRide = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 600));
        setResizable(false);

        // Configure main panel
        mainPanel.setBackground(new java.awt.Color(153, 255, 255));

        // Configure welcome label
        welcomeLabel.setFont(new java.awt.Font("Magnolia Script", 1, 22));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Configure labels
        sourceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        sourceLabel.setText("Source");
        
        destinationLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        destinationLabel.setText("Destination");
        
        vehicleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        vehicleLabel.setText("Vehicle");

        // Configure ComboBoxes
        String[] locations = {
            "Select", "Dairy", "Chourongi", "IIT", "CSE", "SRH", "MH", "STAH",
            "KNIH", "Shahid Minar", "FBS", "FNB", "FA", "Social Science",
            "BSMRH", "SSBH", "SRJH", "RH", "IMH", "PH", "KZH", "SKH", "FH",
            "TBH", "BFMH", "JIH"
        };
        
        source.setModel(new javax.swing.DefaultComboBoxModel<>(locations));
        destination.setModel(new javax.swing.DefaultComboBoxModel<>(locations));
        vehicle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Van", "Rickshaw" }));

        // Configure buttons
        confirmRide.setFont(new java.awt.Font("Segoe UI", 1, 14));
        confirmRide.setText("Confirm Ride");
        confirmRide.addActionListener(evt -> confirmRideActionPerformed(evt));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        backButton.setText("Back");
        backButton.addActionListener(evt -> backButtonActionPerformed(evt));

        finishButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        finishButton.setText("Finish");
        finishButton.addActionListener(evt -> finishButtonActionPerformed(evt));

        // Layout
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(50)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sourceLabel)
                            .addComponent(destinationLabel)
                            .addComponent(vehicleLabel))
                        .addGap(30)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(100)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20)
                                .addComponent(confirmRide, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(40)
                .addComponent(welcomeLabel)
                .addGap(50)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceLabel)
                    .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationLabel)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleLabel)
                    .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmRide, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void confirmRideActionPerformed(java.awt.event.ActionEvent evt) {
        String sourceLocation = source.getSelectedItem().toString();
        String destinationLocation = destination.getSelectedItem().toString();
        String selectedVehicle = vehicle.getSelectedItem().toString();
        
        if (sourceLocation.equals(destinationLocation)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid destination, please change it.");
            return;
        }
        
        int fare = calculateFare(sourceLocation, destinationLocation);
        
        if ("Van".equals(selectedVehicle)) {
            fare += 10;
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "The fare from " + sourceLocation + " to " + destinationLocation + 
            " by " + selectedVehicle + " is: " + fare + " Taka.");

        Payment py = new Payment(fare);
        py.setVisible(true);
        setVisible(false);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserPage userPage = new UserPage();
        userPage.setVisible(true);
        setVisible(false);
    }

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    public int calculateFare(String source, String destination) {
        int fare = 0;

        // Dairy fares
        if ("Dairy".equals(source) && "Chourongi".equals(destination)) fare = 15;
        else if ("Dairy".equals(source) && "CSE".equals(destination)) fare = 10;
        else if ("Dairy".equals(source) && "IIT".equals(destination)) fare = 10;
        else if ("Dairy".equals(source) && "SRH".equals(destination)) fare = 20;
        else if ("Dairy".equals(source) && "SRJH".equals(destination)) fare = 20;
        else if ("Dairy".equals(source) && "MH".equals(destination)) fare = 10;
        else if ("Dairy".equals(source) && "STAH".equals(destination)) fare = 20;
        else if ("Dairy".equals(source) && "KNIH".equals(destination)) fare = 15;
        else if ("Dairy".equals(source) && "Shahid Minar".equals(destination)) fare = 10;
        else if ("Dairy".equals(source) && "FBS".equals(destination)) fare = 25;
        else if ("Dairy".equals(source) && "FNB".equals(destination)) fare = 20;

        return fare;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Destination().setVisible(true);
        });
    }
}