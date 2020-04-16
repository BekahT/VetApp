/**
 * File: VetPortal.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Nour Debiat
 * Purpose: This program is meant to simulate a Vet Clinic Portal application that allows staff to
 * add and manage clients, add and manage client pets, and add and manage appointments.
 *
 * This specific class implements the GUI for the program and the main() method.
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class VetPortal extends JFrame {
    private static final long serialVersionUID = 123L;

    private Database vetDatabase;

    private String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                                "[a-zA-Z0-9_+&*-]+)*@" +
                                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                                "A-Z]{2,7}$";
    private Pattern emailPattern = Pattern.compile(emailRegex);

    //TODO: create all the objects for the main GUI:
    private static VetPortal vetPortal;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
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

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        loginPanel.setBackground(new java.awt.Color(122, 188, 255));
        loginPanel.setToolTipText("");
        loginPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        welcomePanel.setBackground(new java.awt.Color(255, 255, 255));

        welcomeLabel.setBackground(new java.awt.Color(122, 188, 255));
        welcomeLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(122, 188, 255));
        welcomeLabel.setText("Welcome to the Vet Portal");

        usernameLabel.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(122, 188, 255));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(122, 188, 255));
        passwordLabel.setText("Password");

        usernameField.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        usernameField.setForeground(new java.awt.Color(100, 100, 100));
        usernameField.setToolTipText("");

        loginBtn.setBackground(new java.awt.Color(122, 188, 255));
        loginBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");

        passwordField.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordLabel)
                                        .addComponent(usernameLabel)
                                        .addComponent(usernameField)
                                        .addComponent(passwordField)
                                        .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                                .addContainerGap(103, Short.MAX_VALUE)
                                .addComponent(welcomeLabel)
                                .addGap(99, 99, 99))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(welcomeLabel)
                                .addGap(36, 36, 36)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(140, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addGap(0, 284, Short.MAX_VALUE)
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

        loginBtn.addActionListener(event -> authenticateUser());
        //TODO: create follow on Swing components and add them to the frame:

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

    private boolean isAlphabetic(String stringToCheck) {
        return stringToCheck.chars().allMatch(Character::isAlphabetic);
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
    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if ((username.isEmpty()) || (password.isEmpty())) { //Verify the username or password are not empty
            System.out.println("Username or password can not be empty!");
            return;
        }

        Database myDatabase = new Database();
        if (!myDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return;
        }

        if (!myDatabase.authenticate(username, password)) { //Attempt actual authentication
            //TODO: change implementation; make error display on GUI
            System.out.println("Invalid username or password!");
        } else {
            System.out.println("Authentication successful!");
            dashboard = new DashboardsGui(vetPortal);
            vetPortal.setVisible(false);
            vetPortal.viewAllClients();
            dashboard.setVisible(true);
        }
        myDatabase.close();
    } //end of authenticateUser()

    //TODO: add follow on methods
    public void createClient(String firstName, String lastName, String phoneNumber, String email) {
//        String firstName = "Elton";
//        String lastName = "John";
//        String phoneNumber = "543-123-5698";
//        String email = "elton.john@yahoo.com";



        if ((firstName.isEmpty()) || (lastName.isEmpty()
                || (phoneNumber.isEmpty()) || (email.isEmpty()))) { //Verify if any fields are empty
            System.out.println("All fields are required!");
            return;
        }

        if (!(isAlphabetic(firstName) && isAlphabetic(lastName))) { //Verify the first and last name are alphabetic
            String nameErrorMessage = "First and last name must be alphabetic!";
            JOptionPane.showMessageDialog(null, nameErrorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(email)) { //Verify valid email address
            String emailErrorMessage = "Invalid email address!";
            JOptionPane.showMessageDialog(null, emailErrorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //TODO: Possibly add error checking to see if phoneNumber is valid??


        vetDatabase = new Database();
        if (!vetDatabase.open()) { //Attempt to open a connection with the database
            System.out.println("Can't connect to the database!");
            return;
        }

        if (!vetDatabase.insertClient(firstName, lastName, phoneNumber, email)) { //Attempt actual INSERT
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //TODO: change implementation to refresh the view of all clients
            System.out.println("Creating client was successful!");
        }
        vetDatabase.close();
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
            for (Clients client: allClients) {
                System.out.println("client_id: " + client.getClientID() + ", First Name: " + client.getClientFirstName());
            }
            DefaultTableModel model = (DefaultTableModel)dashboard.getClientsTable().getModel();
            for (Clients client : allClients) {
                Object[] row = {client.getClientFirstName(), client.getClientLastName(), client.getClientEmail(), client.getClientPhoneNumber()};
                model.addRow(row);
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

        if (!(isAlphabetic(updatedFirstName) && isAlphabetic(updatedLastName))) { //Verify the first and last name are alphabetic
            String nameErrorMessage = "First and last name must be alphabetic!";
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
        }
        vetDatabase.close();

    } //end of editClient()

} //end of VetClinic
