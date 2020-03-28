/**
 * File: Clients.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Clients.
 */

package vetportal;

public class Clients {

    private int clientID;
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String clientEmail;

    //TODO: add clientID
    public Clients(String clientFirstName, String clientLastName, String clientPhoneNumber, String clientEmail) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
    } //end of constructor

} //end of Clients
