package vetportal;

public class AddPet extends javax.swing.JFrame {

    /**
     * Creates new form AddClient
     */
    public AddPet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPetPanel = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        addPetLabel = new javax.swing.JLabel();
        petNameLabel = new javax.swing.JLabel();
        clientNameLabel = new javax.swing.JLabel();
        speciesLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        petNameField = new javax.swing.JTextField();
        clientNameField = new javax.swing.JTextField();
        cancelInstructionLabel = new javax.swing.JLabel();
        speciesDropDown = new javax.swing.JComboBox<>();
        genderDropDown = new javax.swing.JComboBox<>();
        dobLabel = new javax.swing.JLabel();
        dobField = new javax.swing.JFormattedTextField();
        warningField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addPetPanel.setBackground(new java.awt.Color(255, 255, 255));

        cancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cancelBtn.setText("Cancel");

        submitBtn.setBackground(new java.awt.Color(255, 255, 255));
        submitBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submitBtn.setText("Submit");

        addPetLabel.setBackground(new java.awt.Color(255, 255, 255));
        addPetLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        addPetLabel.setText("Fill out the form below to add new pet");
        addPetLabel.setMaximumSize(new java.awt.Dimension(74, 200));
        addPetLabel.setMinimumSize(new java.awt.Dimension(74, 200));

        petNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        petNameLabel.setText("Pet Name");

        clientNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        clientNameLabel.setText("Client Name");

        speciesLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        speciesLabel.setText("Species");

        genderLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        genderLabel.setText("Gender");

        petNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        clientNameField.setEditable(false);
        clientNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        cancelInstructionLabel.setBackground(new java.awt.Color(255, 255, 255));
        cancelInstructionLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cancelInstructionLabel.setText("or cancel to return to Pets Dashboard");
        cancelInstructionLabel.setMaximumSize(new java.awt.Dimension(74, 200));
        cancelInstructionLabel.setMinimumSize(new java.awt.Dimension(74, 200));

        speciesDropDown.setEditable(true);
        speciesDropDown.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        speciesDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dog", "Cat", "Bird", "Small Mammal", "Fish", "Reptile" }));
        speciesDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciesDropDownActionPerformed(evt);
            }
        });

        genderDropDown.setEditable(true);
        genderDropDown.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        genderDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M", "FS", "MN" }));

        dobLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dobLabel.setText("Date of Birth");

        dobField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        dobField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        warningField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        warningField.setForeground(new java.awt.Color(198, 0, 0));

        javax.swing.GroupLayout addPetPanelLayout = new javax.swing.GroupLayout(addPetPanel);
        addPetPanel.setLayout(addPetPanelLayout);
        addPetPanelLayout.setHorizontalGroup(
            addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPetPanelLayout.createSequentialGroup()
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPetPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelInstructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addPetPanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(submitBtn)
                        .addGap(54, 54, 54)
                        .addComponent(cancelBtn))
                    .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(addPetPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(warningField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addPetPanelLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(clientNameLabel)
                                .addComponent(petNameLabel)
                                .addComponent(speciesLabel)
                                .addComponent(genderLabel)
                                .addComponent(dobLabel))
                            .addGap(18, 18, 18)
                            .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(clientNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(petNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(speciesDropDown, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genderDropDown, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobField, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        addPetPanelLayout.setVerticalGroup(
            addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPetPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addPetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelInstructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petNameLabel)
                    .addComponent(petNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientNameLabel)
                    .addComponent(clientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(speciesLabel)
                    .addComponent(speciesDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(genderDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobLabel)
                    .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(warningField)
                .addGap(28, 28, 28)
                .addGroup(addPetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        addPetLabel.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addPetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addPetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void speciesDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciesDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speciesDropDownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addPetLabel;
    private javax.swing.JPanel addPetPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cancelInstructionLabel;
    private javax.swing.JTextField clientNameField;
    private javax.swing.JLabel clientNameLabel;
    private javax.swing.JFormattedTextField dobField;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JComboBox<String> genderDropDown;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField petNameField;
    private javax.swing.JLabel petNameLabel;
    private javax.swing.JComboBox<String> speciesDropDown;
    private javax.swing.JLabel speciesLabel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel warningField;
    // End of variables declaration//GEN-END:variables
}
