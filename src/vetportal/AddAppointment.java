/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetportal;

import javax.swing.*;

public class AddAppointment extends javax.swing.JFrame {

    // Create a new VetPortal instance
    VetPortal vetPortal;

    //Variables to store appointment information:
    String petName;
    String clientFullName;
    int petOwnerID;
    int petID;

    /**
     * Creates new form AddClient
     */
    public AddAppointment(VetPortal vetPortal, String petName, String clientFullName, int petOwnerID, int petID) {
        super("Add New Appointment Form");
        this.vetPortal = vetPortal;
        this.petName = petName;
        this.clientFullName = clientFullName;
        this.petOwnerID = petOwnerID;
        this.petID = petID;
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

        addAppointmentPanel = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        addAppointmentLabel = new javax.swing.JLabel();
        petNameLabel = new javax.swing.JLabel();
        clientNameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        petNameField = new javax.swing.JTextField();
        clientNameField = new javax.swing.JTextField();
        cancelInstructionLabel = new javax.swing.JLabel();
        reasonLabel = new javax.swing.JLabel();
        warningField = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        reasonField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addAppointmentPanel.setBackground(new java.awt.Color(255, 255, 255));

        cancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(122, 188, 255));
        cancelBtn.setText("Cancel");

        submitBtn.setBackground(new java.awt.Color(255, 255, 255));
        submitBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(122, 188, 255));
        submitBtn.setText("Submit");

        addAppointmentLabel.setBackground(new java.awt.Color(255, 255, 255));
        addAppointmentLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        addAppointmentLabel.setText("Fill out the form below to add a new appointment");
        addAppointmentLabel.setMaximumSize(new java.awt.Dimension(74, 200));
        addAppointmentLabel.setMinimumSize(new java.awt.Dimension(74, 200));

        petNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        petNameLabel.setText("Pet Name");

        clientNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        clientNameLabel.setText("Client Name");

        dateLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dateLabel.setText("Date and Time");

        petNameField.setEditable(false);
        petNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        clientNameField.setEditable(false);
        clientNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        cancelInstructionLabel.setBackground(new java.awt.Color(255, 255, 255));
        cancelInstructionLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cancelInstructionLabel.setText("or cancel to return to Appointments Dashboard");
        cancelInstructionLabel.setMaximumSize(new java.awt.Dimension(74, 200));
        cancelInstructionLabel.setMinimumSize(new java.awt.Dimension(74, 200));

        reasonLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reasonLabel.setText("Reason");

        warningField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        warningField.setForeground(new java.awt.Color(198, 0, 0));

        dateField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        reasonField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        javax.swing.GroupLayout addAppointmentPanelLayout = new javax.swing.GroupLayout(addAppointmentPanel);
        addAppointmentPanel.setLayout(addAppointmentPanelLayout);
        addAppointmentPanelLayout.setHorizontalGroup(
            addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addAppointmentPanelLayout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addAppointmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelInstructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warningField, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(clientNameLabel)
                                    .addComponent(petNameLabel)
                                    .addComponent(dateLabel)
                                    .addComponent(reasonLabel))
                                .addGap(18, 18, 18)
                                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(clientNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(petNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateField)
                                    .addComponent(reasonField)))))
                    .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(submitBtn)
                        .addGap(54, 54, 54)
                        .addComponent(cancelBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addAppointmentPanelLayout.setVerticalGroup(
            addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addAppointmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelInstructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(petNameLabel)
                    .addComponent(petNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientNameLabel)
                    .addComponent(clientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reasonLabel)
                    .addComponent(reasonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(warningField)
                .addGap(29, 29, 29)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        addAppointmentLabel.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addAppointmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addAppointmentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        petNameField.setText(petName);
        clientNameField.setText(clientFullName);

        submitBtn.addActionListener(event -> createNewAppointment());
        cancelBtn.addActionListener(event -> cancel());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Create a new pet function
    private void createNewAppointment() {
        //TODO: get the date and time from the fields once they are separate
        String date = dateField.getText();
        //String time = timeField.getText();
        String reason = reasonField.getText();

        vetPortal.getVetDatabase().open();
        //TODO: uncomment this once fields are separate
        //Boolean createTF = vetPortal.createAppointment(warningField, date, time, petOwnerID, petID, reason);

        // If creation was successful
        //TODO: uncomment this once fields are separate
        /*
        if(createTF) {
            // If success, reset the form
            petNameField.setText(null);
            clientNameField.setText(null);
            dateField.setText(null);
            //timeField.setText(null);
            reasonField.setText(null);
            // And close it
            dispose();

            // Refresh the Appointments Table in the Dashboard
            DashboardsGui dashboard = vetPortal.getDashboard();
            DashboardsGui.MyAppointmentTableModel model = (DashboardsGui.MyAppointmentTableModel)dashboard.getAppointmentTable().getModel();
            model.refetchAppointments();
            // Redirect the user to the appointments tab
            dashboard.moveToApptTab();
        }
        */
        // If creation was not successful, cWarningMsg will convey any errors to the user
    }

    // Cancel button function
    private void cancel() {
        //close the window
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addAppointmentLabel;
    private javax.swing.JPanel addAppointmentPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cancelInstructionLabel;
    private javax.swing.JTextField clientNameField;
    private javax.swing.JLabel clientNameLabel;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField petNameField;
    private javax.swing.JLabel petNameLabel;
    private javax.swing.JTextField reasonField;
    private javax.swing.JLabel reasonLabel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel warningField;
    // End of variables declaration//GEN-END:variables
}
