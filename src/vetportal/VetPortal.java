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

package vetportal;

import javax.swing.*;
import java.awt.*;

public class VetPortal extends JFrame {
    private static final long serialVersionUID = 123L;

    //TODO: create all the objects for the main GUI:

    //constructor:
    public VetPortal() {
        super("Vet Portal");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(700, 700);

        //TODO: create follow on Swing components and add them to the frame:

    } //end of constructor

    public static void main(String[] args) {
        VetPortal vetPortal = new VetPortal();
        vetPortal.setVisible(true);

        vetPortal.authenticateUser();
    } //end of main()

    /*
    This method is used to authenticate a user by pulling a username and password
    from a Java Swing GUI; specifically, a JTextfield and JPasswordfield
     */
    private void authenticateUser() {
        //TODO: change the implementation from hardcoding the username and password to
        //  pulling the information from the GUI
        String username = "bob";
        String password = "password";

        if ((username.equals("")) || (password.equals(""))) { //Verify the username or password are not empty
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
            //TODO: change implementation; allow user to access internal Vet Portal - (i.e: load new page)
            System.out.println("Authentication successful!");
        }
        myDatabase.close();
    } //end of authenticateUser()

    //TODO: add follow on methods

} //end of VetClinic
