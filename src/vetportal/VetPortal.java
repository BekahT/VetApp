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

    //constructor:
    public VetPortal() {
        super("Vet Clinic");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(1600, 700);

        //TODO: create follow on Swing components and add them to the frame:

    } //end of constructor

    public static void main(String[] args) {
        VetPortal window = new VetPortal();
        window.setVisible(true);
    } //end of main()

    private boolean isAlphabetic(String stringToCheck) {
        return stringToCheck.chars().allMatch(Character::isAlphabetic);
    }

    private boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    //TODO: add follow on methods
    private void createClient() {
        String firstName = "Elton";
        String lastName = "John";
        String phoneNumber = "543-123-5698";
        String email = "elton.john@yahoo.com";

        if ((firstName.equals(null)) || (lastName.equals(null)
                || (phoneNumber.equals(null)) || (email.equals(null)))) { //Verify if any fields are empty
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
            System.out.println("Creating client was successful!");
        }
        vetDatabase.close();
    } //end of createClient()


} //end of VetClinic
