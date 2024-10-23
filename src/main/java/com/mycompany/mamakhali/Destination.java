package com.mycompany.mamakhali;

public class Destination extends javax.swing.JFrame {
    
    private javax.swing.JButton confirmRide;
    private javax.swing.JComboBox<String> destination;
    private javax.swing.JComboBox<String> source;
    private javax.swing.JComboBox<String> vehicle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel welcomeLabel;

    public Destination() {
        initComponents();
        setLocationRelativeTo(null);
        
        String username = Session.getUsername();
        welcomeLabel.setText("Hi " + username + ", where are we heading?");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        welcomeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        source = new javax.swing.JComboBox<>();
        vehicle = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        destination = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        confirmRide = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 450));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        welcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Source");

        source.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Select", "Dairy", "Chourongi", "IIT", "CSE", "SRH", "MH", "STAH",
            "KNIH", "Shahid Minar", "FBS", "FNB", "FA", "Social Science",
            "BSMRH", "SSBH", "SRJH", "RH", "IMH", "PH", "KZH", "SKH", "FH",
            "TBH", "BFMH", "JIH" }));

        vehicle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Van", "Rickshaw" }));

        jLabel2.setText("Vehicle");

        destination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Select", "Dairy", "Chourongi", "IIT", "CSE", "SRH", "MH", "STAH",
            "KNIH", "Shahid Minar", "FBS", "FNB", "FA", "Social Science",
            "BSMRH", "SSBH", "SRJH", "RH", "IMH", "PH", "KZH", "SKH", "FH",
            "TBH", "BFMH", "JIH" }));

        jLabel3.setText("Destination");

        confirmRide.setText("Confirm Ride");
        confirmRide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRideActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Finish");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        // Layout code remains the same...
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(80, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 
                                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirmRide))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(26, 26, 26)
                                        .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 170, 
                                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, 
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 170, 
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(64, 64, 64))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addGap(151, 151, 151))))
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(welcomeLabel)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmRide)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        // Add additional 10 Taka for Van
        if ("Van".equals(selectedVehicle)) {
            fare += 10;
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, "The fare from " + sourceLocation + 
                                                " to " + destinationLocation + 
                                                " by " + selectedVehicle + " is: " + fare + " Taka.");

        Payment py = new Payment(fare);
        py.setVisible(true);
        setVisible(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        UserPage userPage = new UserPage();
        userPage.setVisible(true);
        setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    public int calculateFare(String source, String destination) {
        int fare = 0;

        // Dairy fares
        if ("Dairy".equals(source) && "Chourongi".equals(destination)) fare = 15;
        else if ("Dairy".equals(source) && "CSE".equals(destination)) fare = 10;
        else if ("Dairy".equals(source) && "IIT".equals(destination)) fare = 10;
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Destination().setVisible(true);
            }
        });
    }
}