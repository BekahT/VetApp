/**
 * File: EditClient.java
 * Date: April 18, 2020
 * @Author: Nour Debiat, Rebekah Qu
 * Purpose: This window allows the user to add new clients.
 */

package vetportal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;

public class EditClient extends javax.swing.JFrame {

    //Creating VetPortal object:
    VetPortal vetPortal;

    /**
    * Creates new form EditClient
    * @param vetPortal
    * @throws java.text.ParseException
    */
    public EditClient(VetPortal vetPortal, String currentFirstName, String currentLastName, String currentEmail, String currentPhoneNumber) throws ParseException {
        super("Edit Client Form");
        this.vetPortal = vetPortal;
        String userID = currentPhoneNumber;
        // Pass the current client information to the form
        initComponents(currentFirstName, currentLastName, currentEmail, currentPhoneNumber, userID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String currentFirstName, String currentLastName, String currentEmail, String currentPhoneNumber, String userID) throws ParseException {

        editClientPanel = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        editClientLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        MaskFormatter phoneFormat = new MaskFormatter("(###) ###-####");
        phoneField = new javax.swing.JFormattedTextField(phoneFormat);
        cWarningMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editClientPanel.setBackground(new java.awt.Color(255, 255, 255));

        cancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		cancelBtn.setForeground(new java.awt.Color(122, 188, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtnMouseClicked(evt);
            }
        });

        submitBtn.setBackground(new java.awt.Color(255, 255, 255));
        submitBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N   
		submitBtn.setForeground(new java.awt.Color(122, 188, 255));		
        submitBtn.setText("Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt, userID);
            }
        });

        editClientLabel.setBackground(new java.awt.Color(255, 255, 255));
        editClientLabel.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        editClientLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editClientLabel.setText("<html>Edit the form below to edit the selected client <br>or cancel to return to the Clients Dashboard</html>");

        firstNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        firstNameLabel.setText("First Name");

        lastNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lastNameLabel.setText("Last Name");

        emailLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        emailLabel.setText("Email");

        phoneLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        phoneLabel.setText("Phone Number");

        firstNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        firstNameField.setText(currentFirstName);

        lastNameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lastNameField.setText(currentLastName);

        emailField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        emailField.setText(currentEmail);

        phoneField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        phoneField.setText(currentPhoneNumber);

        cWarningMsg.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cWarningMsg.setForeground(new java.awt.Color(203, 0, 0));
        cWarningMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout editClientPanelLayout = new javax.swing.GroupLayout(editClientPanel);
        editClientPanel.setLayout(editClientPanelLayout);
        editClientPanelLayout.setHorizontalGroup(
            editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editClientPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lastNameLabel)
                    .addComponent(firstNameLabel)
                    .addComponent(emailLabel)
                    .addComponent(phoneLabel))
                .addGap(18, 18, 18)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lastNameField)
                    .addComponent(emailField)
                    .addComponent(phoneField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editClientPanelLayout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addComponent(editClientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(editClientPanelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(submitBtn)
                .addGap(110, 110, 110)
                .addComponent(cancelBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editClientPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cWarningMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editClientPanelLayout.setVerticalGroup(
            editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editClientPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(editClientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addGap(18, 18, 18)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cWarningMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(editClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event for Submit button click
    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt, String userID) {//GEN-FIRST:event_submitBtnMouseClicked
        // Attempt to edit the client using the original phone number as the identifier
        editSelectedClient(userID);
    }//GEN-LAST:event_submitBtnMouseClicked

    // Event for Cancel button click
    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
	// Close the Add Client window and do nothing
        dispose();
    }//GEN-LAST:event_cancelBtnMouseClicked

    private void editSelectedClient(String userID) {
        Boolean editTF = vetPortal.editClient(cWarningMsg, userID, firstNameField.getText(), lastNameField.getText(), phoneField.getText(), emailField.getText());

        // If edit was successful
        if(editTF) {
            // If success close the form
            dispose();
        } 
        // If edit was not successful, cWarningMsg will convey any errors to the user

        // Refresh the Clients Table in the Dashboard
        DashboardsGui dashboard = vetPortal.getDashboard();
        DashboardsGui.MyTableModel model = (DashboardsGui.MyTableModel) dashboard.getTable().getModel();
        model.remove(); 
    } //end of editSelectedClient()

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel editClientLabel;
    private javax.swing.JPanel editClientPanel;
    private javax.swing.JLabel cWarningMsg;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
