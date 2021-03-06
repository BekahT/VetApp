/**
 * File: AddAppointment.java
 * Date: April 28, 2020
 * @Author: Nour Debiat, Brian Rease, Rebekah Qu
 * Purpose: This window allows the user to add new appointments.
 */
package vetportal;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;
import javax.swing.*;

public class AddAppointment extends JFrame {

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

        addAppointmentPanel = new JPanel();
        cancelBtn = new JButton();
        submitBtn = new JButton();
        addAppointmentLabel = new JLabel();
        petNameLabel = new JLabel();
        clientNameLabel = new JLabel();
        dateLabel = new JLabel();
        petNameField = new JTextField();
        clientNameField = new JTextField();
        cancelInstructionLabel = new JLabel();
        reasonLabel = new JLabel();
        warningField = new JLabel();
        
        // Create a DateTimePicker
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateSettings.setFormatForDatesBeforeCommonEra("uuuu-MM-dd"); 
        dateSettings.setAllowEmptyDates(false);        
        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.setAllowEmptyTimes(false);
        timeSettings.use24HourClockFormat();
        timeSettings.generatePotentialMenuTimes(TimeIncrement.ThirtyMinutes, null, null);
        
        dateField = new DateTimePicker(dateSettings, timeSettings);
        
        reasonField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        cancelInstructionLabel.setText("or cancel to return to Pets Dashboard");
        cancelInstructionLabel.setMaximumSize(new java.awt.Dimension(74, 200));
        cancelInstructionLabel.setMinimumSize(new java.awt.Dimension(74, 200));

        reasonLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reasonLabel.setText("Reason");

        warningField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        warningField.setForeground(new java.awt.Color(203, 0, 0));
        warningField.setHorizontalAlignment(SwingConstants.CENTER);

        dateField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        reasonField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        GroupLayout addAppointmentPanelLayout = new GroupLayout(addAppointmentPanel);
        addAppointmentPanel.setLayout(addAppointmentPanelLayout);
        addAppointmentPanelLayout.setHorizontalGroup(
            addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, addAppointmentPanelLayout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(addAppointmentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelInstructionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(warningField, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                            .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(clientNameLabel)
                                    .addComponent(petNameLabel)
                                    .addComponent(dateLabel)
                                    .addComponent(reasonLabel))
                                .addGap(18, 18, 18)
                                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(clientNameField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(petNameField, GroupLayout.Alignment.LEADING)
                                    .addComponent(dateField)
                                    .addComponent(reasonField)))))
                    .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(submitBtn)
                        .addGap(54, 54, 54)
                        .addComponent(cancelBtn)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addAppointmentPanelLayout.setVerticalGroup(
            addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(addAppointmentPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addAppointmentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelInstructionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(petNameLabel)
                    .addComponent(petNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(clientNameLabel)
                    .addComponent(clientNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(reasonLabel)
                    .addComponent(reasonField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(warningField)
                .addGap(29, 29, 29)
                .addGroup(addAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        addAppointmentLabel.getAccessibleContext().setAccessibleName("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(addAppointmentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(addAppointmentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        petNameField.setText(petName);
        clientNameField.setText(clientFullName);

        submitBtn.addActionListener(event -> createNewAppointment());
        cancelBtn.addActionListener(event -> cancel());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Create a new pet function
    private void createNewAppointment() {
        String date = dateField.datePicker.getText();
        String time = dateField.timePicker.getText();
        String reason = reasonField.getText();

        vetPortal.getVetDatabase().open();
        Boolean createTF = vetPortal.createAppointment(warningField, date, time, petOwnerID, petID, reason);

        // If creation was successful
        if(createTF) {
            // If success, reset the form
            petNameField.setText(null);
            clientNameField.setText(null);
            reasonField.setText(null);
            // And close it
            dispose();

            // Refresh the Appointments Table in the Dashboard
            DashboardsGui dashboard = vetPortal.getDashboard();
            DashboardsGui.MyAppointmentTableModel model = (DashboardsGui.MyAppointmentTableModel)dashboard.getAppointmentTable().getModel();
            model.refetchUpcomingAppointments();
            // Redirect the user to the appointments tab
            dashboard.moveToApptTab();
        }
        // If creation was not successful, cWarningMsg will convey any errors to the user
    }

    // Cancel button function
    private void cancel() {
        //close the window
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel addAppointmentLabel;
    private JPanel addAppointmentPanel;
    private JButton cancelBtn;
    private JLabel cancelInstructionLabel;
    private JTextField clientNameField;
    private JLabel clientNameLabel;
    private DateTimePicker dateField;
    private JLabel dateLabel;
    private JTextField petNameField;
    private JLabel petNameLabel;
    private JTextField reasonField;
    private JLabel reasonLabel;
    private JButton submitBtn;
    private JLabel warningField;
    // End of variables declaration//GEN-END:variables
}
