/**
 * File: VetPortal.java

 * Date: April 16, 2020
 * @Author: Brian Rease, Nour Debiat, Rebekah Qu
 * Main POC: Nour Debiat
 * Purpose: This program is meant to simulate a Vet Portal application that allows staff to
 * add and manage clients, add and manage client pets, and add and manage appointments.
 *
 * This specific class implements the GUI for the program and the main() method.
 */
package vetportal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class VetPortal extends JFrame {

    private static final long serialVersionUID = 123L;

    private Database vetDatabase;

	// Validate email addresses are valid email addresses
    private final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
		+ "[a-zA-Z0-9_+&*-]+)*@"
		+ "(?:[a-zA-Z0-9-]+\\.)+[a-z"
		+ "A-Z]{2,7}$";
    private final Pattern emailPattern = Pattern.compile(emailRegex);
    
    // Allow only letters, apostrophes and hyphens in names
    private final String nameRegex = "[A-Za-z\\'\\-]+";
    private final Pattern namePattern = Pattern.compile(nameRegex);
    
    // Validate phone number is exactly 10 digits
    private final String phoneRegex = "^\\(\\d{3}\\)\\s+\\d{3}\\-\\d{4}$";
    private final Pattern phonePattern = Pattern.compile(phoneRegex);
    // Create object for Vet Portal (login page)
    private static VetPortal vetPortal;
    // Fields for the Login GUI
    private JButton exitBtn;
    private JButton loginBtn;
    private JPanel loginPanel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JLabel warningMsg;
    private JLabel welcomeLabel;
    private JPanel welcomePanel;

    //Create object for DashboardGui
    private static DashboardsGui dashboard;

    // Constructor for Login Page
    public VetPortal() {
        super("Vet Portal");

        loginPanel = new JPanel();
        welcomePanel = new JPanel();
        welcomeLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        usernameField = new JTextField();
        loginBtn = new JButton();
        passwordField = new JPasswordField();
        exitBtn = new JButton();
        warningMsg = new JLabel();

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

        GroupLayout welcomePanelLayout = new GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGroup(welcomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                .addGap(180, 180, 180)
                                                .addComponent(welcomeLabel))
                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addGroup(welcomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                                        .addComponent(passwordField)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(usernameLabel)
                                                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(warningMsg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(136, Short.MAX_VALUE))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(welcomeLabel)
                                .addGap(28, 28, 28)
                                .addComponent(usernameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(passwordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(warningMsg)
                                .addGap(19, 19, 19)
                                .addGroup(welcomePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(151, Short.MAX_VALUE))
        );

        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addGap(0, 75, Short.MAX_VALUE)
                                .addComponent(welcomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(welcomePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
        // Login Button Event Action
        loginBtn.addActionListener(event -> {
            try {
                authenticateUser();
            } catch (ParseException e) {
                System.out.println(e);
            }
        });
        
        
        // Exit Button Event Action
        exitBtn.addActionListener(event -> {
            System.exit(0);
        });

    } //end of constructor

    public static void main(String[] args) {
        vetPortal = new VetPortal();
        vetPortal.setVisible(true);

        //TODO: Remove Testing:
        vetPortal.createPet(new JLabel("Test"), "Jaeger", "Dog", "MN", "2017-03-18", 1);
        vetPortal.deletePet("Jaeger", "Dog", "MN", "2017-03-18");
    } //end of main()
    
    // Validation functions for New Client Form Fields
    private boolean isValidName(String name) {
        return namePattern.matcher(name).matches();
    }
    private boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }    
    private boolean isValidPhone(String phoneNumber) {
        return phonePattern.matcher(phoneNumber).matches();
    }
        
    // Getter Functions
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

        // Verify the username or password are not empty
        if ((username.isEmpty()) || (password.isEmpty())) { 
            warningMsg.setText("Username or password cannot be empty!");
            return;
        }

		// Attempt to open a connection with the database
        Database myDatabase = new Database();
        if (!myDatabase.open()) {
            System.out.println("Can't connect to the database!");
            return;
        }

        // If user is not locked out, attempt to authenticate
        if (!AccountLockout.isLocked(username)) {
            // If authentication fails
            if (!myDatabase.authenticate(username, password)) { 
                // Add a warning message to the window
                warningMsg.setText("Invalid username or password!");     
                // Reset the form fields
                usernameField.setText("");
                passwordField.setText("");
                // Log the failure
                AuditLog.logWriter("failedLogin", username);
                // Increment the number of failed logins
                AccountLockout.addFailedLogin(username);
            // Authentication was successful
            } else {
                // Log successful login
                AuditLog.logWriter("successfulLogin", username);
                // Display the Dashboards
                dashboard = new DashboardsGui(vetPortal);
                // Close the Login Page
                vetPortal.setVisible(false);                
                vetPortal.viewAllClients();
                vetPortal.viewAllPets();
                dashboard.setVisible(true);
            }
        // If user is locked out, display error
        } else {           
            // Add a warning message to the window
            warningMsg.setText("User account is locked!");
            // Reset the form fields
            usernameField.setText("");
            passwordField.setText("");
            // Log the account lockout
            AuditLog.logWriter("accountLockout", username);
        }
        myDatabase.close();
    } //end of authenticateUser()

    // Method to create a new client, called from the AddClient.java file
    public Boolean createClient(JLabel warnUser, String firstName, String lastName, String phoneNumber, String email) {
        // Verify no fields are empty
        if ((firstName.isEmpty()) || (lastName.isEmpty()
                || (phoneNumber.isEmpty()) || (email.isEmpty()))) { 
            warnUser.setText("All fields are required!");
            return false;
        }
        // Verify the first and last name are validly formatted
        if (!(isValidName(firstName) && isValidName(lastName))) { 
            warnUser.setText("First and last name may not contain invalid characters!");
            return false;
        }
        // Verify valid email address format
        if (!isValidEmail(email)) { 
            warnUser.setText("Invalid email address!");
            return false;
        }
        // Verify valid phone number format
        if(!isValidPhone(phoneNumber)) { 
            warnUser.setText("Phone number must be 10 digits!");
            return false;
        }

		//Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) {
            System.out.println("Can't connect to the database!");
            return false;
        }
		// If INSERT into database fails
        if (!vetDatabase.insertClient(firstName, lastName, phoneNumber, email)) { 
            // Display the error to the user
            String errorMessage = vetDatabase.getErrorMessage();
            warnUser.setText(errorMessage);
        // If INSERT into database is successful
        } else {      
            // Log the add client action
            AuditLog.logWriter("successfulClientAdd", lastName + ", " + firstName);
            return true;
        }
        vetDatabase.close();
        return false;
    } //end of createClient()

    // Method to delete an existing client
    public void deleteClient(String phoneNumber, String firstName, String lastName) {
	//Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) { 
            System.out.println("Can't connect to the database!");
            return;
        }

        // If no client was passed
        if (!vetDatabase.deleteClient(phoneNumber)) {
            // Display an error
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error: No client selected", JOptionPane.ERROR_MESSAGE);
        // Delete the client
        } else {
            vetDatabase.deleteClient(phoneNumber);
            // Log the deletion
            AuditLog.logWriter("successfulClientDelete", lastName + ", " + firstName);
        }
        vetDatabase.close();
    } //end of deleteClient()

// Method to view all clients that currently exist in the database
    public void viewAllClients() {
        // Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) { 
            System.out.println("Can't connect to the database!");
            return;
        }
	// Add all the clients to an array
        ArrayList<Clients> allClients = vetDatabase.selectAllClients();
	// If the array is empty
        if (allClients.isEmpty()) {
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error: No clients exist", JOptionPane.ERROR_MESSAGE);
	// If clients exist
        } else {
            // Loop through the clients and add them to the Clients Table              
            DefaultTableModel model = (DefaultTableModel) dashboard.getClientsTable().getModel();
            DashboardsGui.MyClientTableModel newModel = (DashboardsGui.MyClientTableModel) dashboard.getClientTable().getModel();
            for (Clients client : allClients) {
                Object[] row = {client.getClientFirstName(), client.getClientLastName(), client.getClientEmail(), client.getClientPhoneNumber()};
                newModel.add(client);
            }
        }
        vetDatabase.close();
    } //end of viewAllClients()

    // Method to edit information on existing clients
    public Boolean editClient(JLabel warnUser, String userID, String updatedFirstName, String updatedLastName, String updatedPhoneNumber, String updatedEmail) {            
        // Verify no fields are empty
        if ((updatedFirstName.isEmpty()) || (updatedLastName.isEmpty()
                || (updatedPhoneNumber.isEmpty()) || (updatedEmail.isEmpty()))) { 
            warnUser.setText("All fields are required!");
            return false;
        }
        // Verify the first and last name are validly formatted
        if (!(isValidName(updatedFirstName) && isValidName(updatedLastName))) { 
            warnUser.setText("First and last name may not contain invalid characters!");
            return false;
        }
        // Verify valid email address format
        if (!isValidEmail(updatedEmail)) { 
            warnUser.setText("Invalid email address!");
            return false;
        }
        // Verify valid phone number format
        if(!isValidPhone(updatedPhoneNumber)) { 
            warnUser.setText("Phone number must be 10 digits!");
            return false;
        }        

	// Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) { 
            System.out.println("Can't connect to the database!");
            return false;
        }
        
        // Get the id for the user based on the original phone number
        int id = vetDatabase.getClientID(userID);
	// If UPDATE in database fails
        if (!vetDatabase.updateClient(id, updatedFirstName, updatedLastName, updatedPhoneNumber, updatedEmail)) {
            // Show an error
            String errorMessage = vetDatabase.getErrorMessage();
            warnUser.setText(errorMessage);
	// If UPDATE in database is successful
        } else {
            // Log successful client edit
            AuditLog.logWriter("successfulClientEdit", updatedLastName + ", " + updatedFirstName);
            return true;
        }
        vetDatabase.close();
        return false;
    } //end of editClient()

    // Method to create a new pet, called from the AddPet.java file
    public Boolean createPet(JLabel warnUser, String name, String species, String gender, String dob, int owner) {
        System.out.println(dob);
        // Verify no fields are empty
        if ((name.isEmpty()) || (species.isEmpty()
                || (gender.isEmpty()) || (dob.toString().isEmpty()))) {
            warnUser.setText("All fields are required!");
            return false;
        }
        // Verify the name is validly formatted
        if (!(isValidName(name))) {
            warnUser.setText("Name may not contain invalid characters!");
            return false;
        }

        //TODO: might need to add validation checks on species, gender, and dob - depending on implementation

        //Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) {
            System.out.println("Can't connect to the database!");
            return false;
        }
        // If INSERT into database fails
        if (!vetDatabase.insertPet(name, species, gender, dob, owner)) {
            // Display the error to the user
            String errorMessage = vetDatabase.getErrorMessage();
            warnUser.setText(errorMessage);
            // If INSERT into database is successful
        } else {
            // Log the add client action
            AuditLog.logWriter("successfulPetAdd", name + ", " + species + ", " + gender);
            return true;
        }
        vetDatabase.close();
        return false;
    } //end of createPet()

    // Method to delete an existing client
    public void deletePet(String name, String species, String gender, String dob) {
        //Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) {
            System.out.println("Can't connect to the database!");
            return;
        }

        // If no client was passed
        if (!vetDatabase.deletePet(name, species, gender, dob)) {
            // Display an error
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error: No pet selected", JOptionPane.ERROR_MESSAGE);
            // Delete the client
        } else {
            // Log the deletion
            AuditLog.logWriter("successfulPetDelete", name + ", " + species + ", " + gender);
        }
        vetDatabase.close();
    } //end of deleteClient()

    //Method to view all pets that currently exist in the database
    public void viewAllPets() {
        // Attempt to open a connection with the database
        vetDatabase = new Database();
        if (!vetDatabase.open()) {
            System.out.println("Can't connect to the database!");
            return;
        }
        // Add all the pets to an array
        ArrayList<Pets> allPets = vetDatabase.selectAllPets();
        // If the array is empty
        if (allPets.isEmpty()) {
            String errorMessage = vetDatabase.getErrorMessage();
            JOptionPane.showMessageDialog(null, errorMessage, "Error: No pets exist", JOptionPane.ERROR_MESSAGE);
            // If clients exist
        } else {
            // Loop through the pets and add them to the pets Table
            DashboardsGui.MyPetTableModel newModel = (DashboardsGui.MyPetTableModel) dashboard.getPetTable().getModel();
            for (Pets pet : allPets) {
                newModel.add(pet);
            }
        }
        vetDatabase.close();
    } //end of viewAllClients()

} //end of VetPortal
