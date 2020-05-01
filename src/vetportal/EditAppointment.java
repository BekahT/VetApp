/**
 * File: EditAppointment.java
 * Date: April 28, 2020
 * @Author: Nour Debiat, Brian Rease, Rebekah Qu
 * Purpose: This window allows the user to edit existing appointments.
 */
package vetportal;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import javax.swing.*;
import java.util.Scanner;

public class EditAppointment extends JFrame {

    // Create a new VetPortal instance
    VetPortal vetPortal;

    String currentDate, currentTime, currentClient, currentPet, currentReason;


    public EditAppointment(VetPortal vetPortal, String currentDate, String currentTime, String currentClient, String currentPet, String currentReason) {
        super("Edit Appointment Form");
        this.vetPortal = vetPortal;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.currentClient = currentClient;
        this.currentPet = currentPet;
        this.currentReason = currentReason;
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

        editAppointmentPanel = new JPanel();
        cancelBtn = new JButton();
        submitBtn = new JButton();
        editAppointmentLabel = new JLabel();
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
        timeSettings.generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.ThirtyMinutes, null, null);
        
        dateField = new DateTimePicker(dateSettings, timeSettings);
        reasonField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        editAppointmentPanel.setBackground(new java.awt.Color(255, 255, 255));

        cancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(122, 188, 255));
        cancelBtn.setText("Cancel");

        submitBtn.setBackground(new java.awt.Color(255, 255, 255));
        submitBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(122, 188, 255));
        submitBtn.setText("Submit");

        editAppointmentLabel.setBackground(new java.awt.Color(255, 255, 255));
        editAppointmentLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        editAppointmentLabel.setText("Edit the information below to modify the appointment");
        editAppointmentLabel.setMaximumSize(new java.awt.Dimension(74, 200));
        editAppointmentLabel.setMinimumSize(new java.awt.Dimension(74, 200));

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

        warningField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        warningField.setForeground(new java.awt.Color(203, 0, 0));
        warningField.setHorizontalAlignment(SwingConstants.CENTER);

        dateField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        reasonField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        GroupLayout editAppointmentPanelLayout = new GroupLayout(editAppointmentPanel);
        editAppointmentPanel.setLayout(editAppointmentPanelLayout);
        editAppointmentPanelLayout.setHorizontalGroup(
            editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(editAppointmentPanelLayout.createSequentialGroup()
                .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(editAppointmentPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(submitBtn)
                        .addGap(54, 54, 54)
                        .addComponent(cancelBtn))
                    .addGroup(editAppointmentPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(cancelInstructionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(warningField, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                .addGroup(editAppointmentPanelLayout.createSequentialGroup()
                                    .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(clientNameLabel)
                                        .addComponent(petNameLabel)
                                        .addComponent(dateLabel)
                                        .addComponent(reasonLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(clientNameField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                        .addComponent(petNameField, GroupLayout.Alignment.LEADING)
                                        .addComponent(dateField)
                                        .addComponent(reasonField))))))
                    .addGroup(editAppointmentPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(editAppointmentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        editAppointmentPanelLayout.setVerticalGroup(
            editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(editAppointmentPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(editAppointmentLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelInstructionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(petNameLabel)
                    .addComponent(petNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(clientNameLabel)
                    .addComponent(clientNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(reasonLabel)
                    .addComponent(reasonField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(warningField)
                .addGap(29, 29, 29)
                .addGroup(editAppointmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        editAppointmentLabel.getAccessibleContext().setAccessibleName("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(editAppointmentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(editAppointmentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        String petName;
        try (Scanner scanner = new Scanner(currentPet)) {
            petName = scanner.next();
        }

        clientNameField.setText(currentClient);
        petNameField.setText(petName);
        reasonField.setText(currentReason);

        String formattedTime;
        try (Scanner timeScanner = new Scanner(currentTime)) {
            timeScanner.useDelimiter(":");
            formattedTime = timeScanner.next() + ":" + timeScanner.next();
        }

        dateField.datePicker.setText(currentDate);
        dateField.timePicker.setText(formattedTime);

        submitBtn.addActionListener(event -> editSelectedAppointment());
        cancelBtn.addActionListener(event -> cancel());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editSelectedAppointment() {
        vetPortal.getVetDatabase().open();
        Boolean editTF = vetPortal.editAppointment(warningField, currentDate, currentTime, dateField.datePicker.getText(), dateField.timePicker.getText(), reasonField.getText());

        // If edit was successful
        if(editTF) {
            // If success close the form
            dispose();
        }
        // If edit was not successful, cWarningMsg will convey any errors to the user

        // Refresh the Appointments Table in the Dashboard
        DashboardsGui dashboard = vetPortal.getDashboard();
        DashboardsGui.MyAppointmentTableModel model = (DashboardsGui.MyAppointmentTableModel)dashboard.getAppointmentTable().getModel();
        model.refetchUpcomingAppointments();
    }

    // Cancel button function
    private void cancel() {
        //close the window
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton cancelBtn;
    private JLabel cancelInstructionLabel;
    private JTextField clientNameField;
    private JLabel clientNameLabel;
    private DateTimePicker dateField;
    private JLabel dateLabel;
    private JLabel editAppointmentLabel;
    private JPanel editAppointmentPanel;
    private JTextField petNameField;
    private JLabel petNameLabel;
    private JTextField reasonField;
    private JLabel reasonLabel;
    private JButton submitBtn;
    private JLabel warningField;
    // End of variables declaration//GEN-END:variables
}
