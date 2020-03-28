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

    //TODO: add follow on methods

} //end of VetClinic
