package com.mycompany.mamakhali;

public class Destination extends javax.swing.JFrame {

    // Creates new form Destination
    public Destination() {
        initComponents();
        setLocationRelativeTo(null); // Center the frame
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
        else if ("Dairy".equals(source) && "SRJH".equals(destination)) fare = 20; // Fixed from "SRJ"
        else if ("Dairy".equals(source) && "MH".equals(destination)) fare = 10;
        else if ("Dairy".equals(source) && "STAH".equals(destination)) fare = 20;
        else if ("Dairy".equals(source) && "KNIH".equals(destination)) fare = 15;
        else if ("Dairy".equals(source) && "Shahid Minar".equals(destination)) fare = 10; // Fixed from "Shaheed Minar"
        else if ("Dairy".equals(source) && "FBS".equals(destination)) fare = 25;
        else if ("Dairy".equals(source) && "FNB".equals(destination)) fare = 20;

        // More conditions for other sources...
        // (Include similar logic for other sources like Chourongi, IIT, etc.)

        return fare; 
    }

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Destination().setVisible(true);
            }
        });
    }

   
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
