package com.mycompany.mamakhali;

public class Destination extends javax.swing.JFrame {

    // Creates new form Destination
    public Destination() {
        initComponents();
    }

    // This method is called from within the constructor to initialize the form.
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        source = new javax.swing.JComboBox<>();
        vehicle = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        destination = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        done = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("Source");

        source.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Select", "Dairy", "Chourongi", "IIT", "CSE", "SRH", "MH", "STAH", 
            "KNIH", "Shahid Minar", "FBS", "FNB", "FA", "Social Science", 
            "BSMRH", "SSBH", "SRJH", "RH", "IMH", "PH", "KZH", "SKH", "FH", 
            "TBH", "BFMH", "JIH" }));

        vehicle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Van", "Rickshaw" }));

        jLabel2.setText("Vehicle");

        destination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Select", "Dairy", "Chourongi", "IIT", "CSE", "SRH", "MH", "STAH", 
            "KNIH", "Shahid Minar", "FBS", "FNB", "FA", "Social Science", 
            "BSMRH", "SSBH", "SRJH", "RH", "IMH", "PH", "KZH", "SKH", "FH", 
            "TBH", "BFMH", "JIH" }));

        jLabel3.setText("Destination");

        done.setText("Done");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(done))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(26, 26, 26)
                                    .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(151, 151, 151)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(done)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap()
        );

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
    }// </editor-fold>//GEN-END:initComponents

    // Action performed when "Done" is clicked
    private void doneActionPerformed(java.awt.event.ActionEvent evt) {
        // Get selected source and destination
        String sourceLocation = source.getSelectedItem().toString();
        String destinationLocation = destination.getSelectedItem().toString();
        
        // Calculate fare based on selected locations
        int fare = calculateFare(sourceLocation, destinationLocation);

        // Show fare in a message dialog
        javax.swing.JOptionPane.showMessageDialog(this, "The fare from " + sourceLocation + " to " + destinationLocation + " is: " + fare + " Taka.");

        // Transition to Payment screen, passing the calculated fare
        Payment py = new Payment(fare);
        py.setVisible(true);
        setVisible(false);
    }

    // Action performed when "Back" is clicked
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        setVisible(false);
    }

    // Action performed when "Finish" is clicked
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    // Fare calculation method based on source and destination
    public int calculateFare(String source, String destination) {
    int fare = 0;

    // Dairy fares
    if ("Dairy".equals(source) && "Chourongi".equals(destination)) fare = 15;
    else if ("Dairy".equals(source) && "CSE".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "IIT".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "SRJ".equals(destination)) fare = 20;
    else if ("Dairy".equals(source) && "MH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "STAH".equals(destination)) fare = 20;
    else if ("Dairy".equals(source) && "KNIH".equals(destination)) fare = 15;
    else if ("Dairy".equals(source) && "Shaheed Minar".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "FBS".equals(destination)) fare = 20;
    else if ("Dairy".equals(source) && "FNB".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "FA".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "Social Science".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "BSMRH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "SSB".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "SRJH".equals(destination)) fare = 20;
    else if ("Dairy".equals(source) && "RH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "IMH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "PH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "KZH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("Dairy".equals(source) && "JIH".equals(destination)) fare = 10;

    // Chourongi fares
    else if ("Chourongi".equals(source) && "Dairy".equals(destination)) fare = 15;
    else if ("Chourongi".equals(source) && "CSE".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "IIT".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "SRJ".equals(destination)) fare = 20;
    else if ("Chourongi".equals(source) && "MH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "STAH".equals(destination)) fare = 20;
    else if ("Chourongi".equals(source) && "KNIH".equals(destination)) fare = 15;
    else if ("Chourongi".equals(source) && "Shaheed Minar".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "FBS".equals(destination)) fare = 20;
    else if ("Chourongi".equals(source) && "FNB".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "FA".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "Social Science".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "BSMRH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "SSB".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "SRJH".equals(destination)) fare = 20;
    else if ("Chourongi".equals(source) && "RH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "IMH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "PH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "KZH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("Chourongi".equals(source) && "JIH".equals(destination)) fare = 10;

    // Additional routes based on the data provided for other combinations
    else if ("SSB".equals(source) && "SRJH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "RH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "IMH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "PH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "KZH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("SSB".equals(source) && "JIH".equals(destination)) fare = 10;

    // SRJH fares
    else if ("SRJH".equals(source) && "RH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "IMH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "PH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "KZH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "SKH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "FH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "TBH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "BFMH".equals(destination)) fare = 15;
    else if ("SRJH".equals(source) && "JIH".equals(destination)) fare = 15;

    // RH fares
    else if ("RH".equals(source) && "IMH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "PH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "KZH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("RH".equals(source) && "JIH".equals(destination)) fare = 10;

    // IMH fares
    else if ("IMH".equals(source) && "PH".equals(destination)) fare = 10;
    else if ("IMH".equals(source) && "KZH".equals(destination)) fare = 10;
    else if ("IMH".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("IMH".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("IMH".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("IMH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("IMH".equals(source) && "JIH".equals(destination)) fare = 10;

    // PH fares
    else if ("PH".equals(source) && "KZH".equals(destination)) fare = 10;
    else if ("PH".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("PH".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("PH".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("PH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("PH".equals(source) && "JIH".equals(destination)) fare = 10;

    // KZH fares
    else if ("KZH".equals(source) && "SKH".equals(destination)) fare = 10;
    else if ("KZH".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("KZH".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("KZH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("KZH".equals(source) && "JIH".equals(destination)) fare = 10;

    // SKH fares
    else if ("SKH".equals(source) && "FH".equals(destination)) fare = 10;
    else if ("SKH".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("SKH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("SKH".equals(source) && "JIH".equals(destination)) fare = 10;

    // FH fares
    else if ("FH".equals(source) && "TBH".equals(destination)) fare = 10;
    else if ("FH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("FH".equals(source) && "JIH".equals(destination)) fare = 10;

    // TBH fares
    else if ("TBH".equals(source) && "BFMH".equals(destination)) fare = 10;
    else if ("TBH".equals(source) && "JIH".equals(destination)) fare = 10;

    // BFMH fares
    else if ("BFMH".equals(source) && "JIH".equals(destination)) fare = 10;

    // Default fare if no match found
    else fare = 5;

    return fare;
}


    // Variables declaration
    private javax.swing.JButton done;
    private javax.swing.JComboBox<String> destination;
    private javax.swing.JComboBox<String> source;
    private javax.swing.JComboBox<String> vehicle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
}
