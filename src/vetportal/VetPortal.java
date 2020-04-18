/**
 * File: VetPortal.java

 * Date: April 16, 2020
 * @Author: Brian Rease, Nour Debiat, Rebekah Qu
 * Main POC: Nour Debiat
 * Purpose: This program is meant to simulate a Vet Clinic Portal application that allows staff to
 * add and manage clients, add and manage client pets, and add and manage appointments.
 *
 * This specific class implements the GUI for the program and the main() method.
 */

package vetportal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class VetPortal extends JFrame {

    private static final long serialVersionUID = 123L;

    private Database vetDatabase;

    private String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
            + "[a-zA-Z0-9_+&*-]+)*@"
            + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
            + "A-Z]{2,7}$";
    private Pattern emailPattern = Pattern.compile(emailRegex);
    
    // Allow letters, apostrophes and hyphens in names
    private String nameRegex = "[A-Za-z'\\-]+";
    private Pattern namePattern = Pattern.compile(nameRegex);
  
    //TODO: create all the objects for the main GUI:
    private static VetPortal vetPortal;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel warningMsg;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JPanel welcomePanel;

    //Create object for DashboardGui:
    DashboardsGui dashboard;

    //constructor:
    public VetPortal() {
        super("Vet Portal");

        loginPanel = new javax.swing.JPanel();
        welcomePanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        exitBtn = new javax.swing.JButton();
        warningMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        loginPanel.setBackground(new java.awt.Color(122, 188, 255));
        loginPanel.setToolTipText("");
        loginPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        welcomePanel.setBackground(new java.awt.Color(255, 255, 255));

        welcomeLabel.setBackground(new java.awt.Color(122, 188, 255));
        welcomeLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(122, 188, 255));
        welcomeLabel.setText("Welcome to the Vet Portal");

        usernameLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(122, 188, 255));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(122, 188, 255));
        passwordLabel.setText("Password");

        usernameField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        usernameField.setForeground(new java.awt.Color(41, 41, 41));
        usernameField.setToolTipText("");

        loginBtn.setBackground(new java.awt.Color(255, 255, 255));
        loginBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(122, 188, 255));
        loginBtn.setText("Login");

        passwordField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(41, 41, 41));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(122, 188, 255));
        exitBtn.setText("Exit");

        warningMsg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        warningMsg.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                .addGap(180, 180, 180)
                                                .addComponent(welcomeLabel))
                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                                        .addComponent(passwordField)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(usernameLabel)
                                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(warningMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(136, Short.MAX_VALUE))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(welcomeLabel)
                                .addGap(28, 28, 28)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(warningMsg)
                                .addGap(19, 19, 19)
                                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addGap(0, 75, Short.MAX_VALUE)
                                .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
        // Login Button Action
        loginBtn.addActionListener(event -> {
            try {
                authenticateUser();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        
        
        // Exit Button Action
        exitBtn.addActionListener(event -> {
            System.exit(0);
        });

    } //end of constructor

    public static void main(String[] args) {
        vetPortal = new VetPortal();
        vetPortal.setVisible(true);

//        AddClient page = new AddClient();
//        page.setVisible(true);
        //vetPortal.authenticateUser();
        //vetPortal.createClient();
        //vetPortal.deleteClient();
        //vetPortal.viewAllClients();
        //vetPortal.editClient();
    } //end of main()
    
    private boolean isValidName(String name) {
        return namePattern.matcher(name).matches();
    }

    private boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    public DashboardsGui getDashboard() {
        return dashboard;
    }

    public Database getVetDatabase() {
        return vetDatabase;
    }

    public VetPortal getVetPortal() {
        return vetPortal;
    }

    /*
    This method is used to authenticate a user by pulling a username and password
    from a Java Swing GUI; specifically, a JTextfield and JPasswordfield
     */
    private void authenticateUser() throws ParseException {
        // Make username lowercase to effectively make case insensitive
        String username = usernameField.getText().toLowerCase();
        String password = new String(passwordField.getPassword());

        if ((username.isEmpty()) || (password.isEmpty())) { //Verify the username or password are not empty
            warningMsg.setText("Username or password cannot be empty!");
            return;
        }

        Database myDatabase = new Database();
        if (!myDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return;
        }

        // If user is not locked out, attempt to authenticate
        if (!AccountLockout.isLocked(username)) {
            if (!myDatabase.authenticate(username, password)) { //Attempt actual authentication
                // Add a warning message to the window
                warningMsg.setText("Invalid username or password!");     
                // Reset the form fields
                usernameField.setText("");
                passwordField.setText("");
                // Log the failure
                AuditLog.logWriter("failedLogin", username);
                AccountLockout.addFailedLogin(username);
            } else {
                AuditLog.logWriter("successfulLogin", username);
                dashboard = new DashboardsGui(vetPortal);
                vetPortal.setVisible(false);
                vetPortal.viewAllClients();
                dashboard.setVisible(true);
            }
        // If user is locked out, display error
        } else {           
            // Add a warning message to the window
            warningMsg.setText("User account is locked!");
            // Reset the form fields
            usernameField.setText("");
            passwordField.setText("");
            AuditLog.logWriter("accountLockout", username);
        }
        myDatabase.close();
    } //end of authenticateUser()

    //TODO: add follow on methods
    public Boolean createClient(JLabel warnUser, String firstName, String lastName, String phoneNumber, String email) {
        if ((firstName.isEmpty()) || (lastName.isEmpty()
                || (phoneNumber.isEmpty()) || (email.isEmpty()))) { //Verify if any fields are empty
            warnUser.setText("All fields are required!");
            return false;
        }

        if (!(isValidName(firstName) && isValidName(lastName))) { //Verify the first and last name are validly formatted
            warnUser.setText("First and last name may not contain invalid characters!");
            return false;
        }

        if (!isValidEmail(email)) { //Verify valid email address
            warnUser.setText("Invalid email address!");
            return false;
        }

        vetDatabase = new Database();
        if (!vetDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return false;
        }

        if (!vetDatabase.insertClient(firstName, lastName, phoneNumber, email)) { //Attempt actual INSERT
            String errorMessage = vetDatabase.getErrorMessage();
            warnUser.setText(errorMessage);
        } else {
            //TODO: change implementation to refresh the view of all clients
            AuditLog.logWriter("successfulClientAdd", lastName + ", " + firstName);
            return true;
        }
        vetDatabase.close();
        return false;
    } //end of createClient()

    private void deleteClient() {
        String phoneNumber = "543-123-5691";

        vetDatabase = new Database();
        if (!vetDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return;
        }

        if (!vetDatabase.deleteClient(phoneNumber)) {
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Deleting client was successful!");
            // NEED CLIENT INFO AuditLog.logWriter("successfulClientDelete", lastName + ", " + firstName);
        }
        vetDatabase.close();
    } //end of deleteClient()

    public void viewAllClients() {
        vetDatabase = new Database();
        if (!vetDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return;
        }

        ArrayList<Clients> allClients = vetDatabase.selectAllClients();

        if (allClients.isEmpty()) {
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Clients client : allClients) {
                System.out.println("client_id: " + client.getClientID() + ", First Name: " + client.getClientFirstName());
            }
            DefaultTableModel model = (DefaultTableModel) dashboard.getClientsTable().getModel();
            DashboardsGui.MyTableModel newModel = (DashboardsGui.MyTableModel) dashboard.getTable().getModel();
            for (Clients client : allClients) {
                Object[] row = {client.getClientFirstName(), client.getClientLastName(), client.getClientEmail(), client.getClientPhoneNumber()};
                //model.addRow(row);
//                newModel.add(client.getClientFirstName());
//                newModel.add(client.getClientLastName());
//                newModel.add(client.getClientEmail());
//                newModel.add(client.getClientPhoneNumber());
                newModel.add(client);
            }
        }
        vetDatabase.close();
    } //end of viewAllClients()

    private void editClient() {
        String currentPhoneNumber = "111-111-1111";

        String updatedFirstName = "Elton";
        String updatedLastName = "John";
        String updatedPhoneNumber = "222-222-2222";
        String updatedEmail = "elton.john@yahoo.com";

        if ((updatedFirstName.isEmpty()) || (updatedLastName.isEmpty()
                || (updatedPhoneNumber.isEmpty()) || (updatedEmail.isEmpty()))) { //Verify if any fields are empty
            System.out.println("All fields are required!");
            return;
        }

        if (!(isValidName(updatedFirstName) && isValidName(updatedLastName))) { //Verify the first and last name are validly formatted
            String nameErrorMessage = "First and last name may not contain invalid characters!";
            JOptionPane.showMessageDialog(null, nameErrorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(updatedEmail)) { //Verify valid email address
            String emailErrorMessage = "Invalid email address!";
            JOptionPane.showMessageDialog(null, emailErrorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        vetDatabase = new Database();
        if (!vetDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return;
        }

        int id = vetDatabase.getClientID(currentPhoneNumber);

        if (!vetDatabase.updateClient(id, updatedFirstName, updatedLastName, updatedPhoneNumber, updatedEmail)) {
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Updating client was successful!");
            AuditLog.logWriter("successfulClientEdit", updatedLastName + ", " + updatedFirstName);
        }
        vetDatabase.close();

    } //end of editClient()

} //end of VetClinic
