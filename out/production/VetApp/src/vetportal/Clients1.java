/**
 * File: Clients.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Clients.
 */

public class Clients1 {

    private int clientID;
    private String clientFirstName;
    private String clientLastName;
    private String clientPhoneNumber;
    private String clientEmail;

    //TODO: add clientID
    public Clients1(int clientID, String clientFirstName, String clientLastName, String clientPhoneNumber, String clientEmail) {
        this.clientID = clientID;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
    } //end of constructor

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
} //end of Clients
