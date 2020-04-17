/**
 * File: Users.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Users.
 */
 
 package vetportal;

public class Users {

    private int userID;
    private String userName;
    private String userPassword;

    //TODO: add userID
    public Users(String userName, String userPassword) {
        this.userName = userName;

        //TODO: change the functionality to have secure authentication
        this.userPassword = userPassword;
    } //end of constructor

} //end of Users
