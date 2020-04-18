/**
 * File: Database.java
 * Date: March 28, 2020
 * @Author: Brian Rease, Nour Debiat, Rebekah Qu
 * Main POC: Brian Rease 
 * Purpose: This class acts as the model for the SQLite database and contains the direct methods for specific interactions.
 */
package vetportal;

import org.apache.commons.codec.digest.DigestUtils;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteErrorCode;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private String errorMessage;

    public static final String DB_NAME = "vetclinic.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_USER_PASSWORD = "password";

    public static final String TABLE_CLIENTS = "clients";
    public static final String COLUMN_CLIENT_ID = "client_id";
    public static final String COLUMN_CLIENT_FIRST_NAME = "first_name";
    public static final String COLUMN_CLIENT_LAST_NAME = "last_name";
    public static final String COLUMN_CLIENT_PHONE_NUMBER = "phone";
    public static final String COLUMN_CLIENT_EMAIL = "email";

    public static final String TABLE_PETS = "pets";
    public static final String COLUMN_PET_ID = "pet_id";
    public static final String COLUMN_PET_NAME = "name";
    public static final String COLUMN_PET_SPECIES = "species";
    public static final String COLUMN_PET_GENDER = "gender";
    public static final String COLUMN_PET_DATE_OF_BIRTH = "dob";
    public static final String COLUMN_PET_OWNER = "owner";

    public static final String TABLE_APPOINTMENTS = "appointments";
    public static final String COLUMN_APPOINTMENT_DATE = "date";
    public static final String COLUMN_APPOINTMENT_TIME = "time";
    public static final String COLUMN_APPOINTMENT_CLIENT = "client";
    public static final String COLUMN_APPOINTMENT_PET = "pet";
    public static final String COLUMN_APPOINTMENT_REASON = "reason";

    private Connection conn;
    private Statement statement;

    //This method attempts to open a connection with the database
    public boolean open() {
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            conn = DriverManager.getConnection(CONNECTION_STRING, config.toProperties());
            return true;
        } catch (SQLException eS) {
            System.out.println("SQLException: " + eS.getMessage());
            return false;
        }
    } //end of open()

    //This method will close the connection to the database if it is not null
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException eS) {
            System.out.println("Couldn't close connection: " + eS.getMessage());
        }
    } //end of close()

    private void setErrorMessage(String message) {
        errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getClientID(String phoneNumber) {
        String sql = "SELECT " + COLUMN_CLIENT_ID
            + " FROM " + TABLE_CLIENTS + " WHERE "
            + COLUMN_CLIENT_PHONE_NUMBER + "=?";
        
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, phoneNumber);
            ResultSet idResult = pstmt.executeQuery();
            return idResult.getInt("client_id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    } //end of getClientID()

    /*
    This method uses the Apache commons codec to hash a given 'password' String with sha256.
    The hash is then compared to a password hash in the sqlite database
     */
    public boolean authenticate(String username, String password) {
        // Create a hash of the password
        String passwordHash = DigestUtils.sha256Hex(password);
        // Get the password for the user in order to compare passwords
        String getUser = "SELECT " + COLUMN_USER_PASSWORD
            + " FROM " + TABLE_USERS + " WHERE "
            + COLUMN_USER_NAME + "=?";      
        try(PreparedStatement pstmt = conn.prepareStatement(getUser)){
            pstmt.setString(1, username);
            ResultSet matchedUser = pstmt.executeQuery();
            // If the hashed password for the selected user matches
            if(passwordHash.equals(matchedUser.getString(COLUMN_USER_PASSWORD))) {                
                pstmt.close();
                return true;
            // Otherwise, authentication failed
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    } //end of authenticate()

    // This method inserts a new client into the clients table in the database
    public boolean insertClient(String firstName, String lastName, String phoneNumber, String email) {
        String sql = "INSERT INTO " + TABLE_CLIENTS
            + " (" + COLUMN_CLIENT_FIRST_NAME
            + ", " + COLUMN_CLIENT_LAST_NAME
            + ", " + COLUMN_CLIENT_PHONE_NUMBER
            + ", " + COLUMN_CLIENT_EMAIL + ") VALUES(?,?,?,?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
            if (SQLiteErrorCode.SQLITE_CONSTRAINT_UNIQUE.code == 2067) {
                setErrorMessage("The phone number you entered is already in the database!");
            } else {
                setErrorMessage("Unable to create new client.");
                System.out.println(e.getMessage());
            }
            return false;
        }
    } //end of insertClient()

    // This method deletes an existing client from the clients table in the database
    public boolean deleteClient(String phoneNumber) {
        String sql = "DELETE FROM " + TABLE_CLIENTS
            + " WHERE " + COLUMN_CLIENT_PHONE_NUMBER + "=?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, phoneNumber);
            pstmt.execute();
            pstmt.close();
            return true;
        } catch (SQLException e) {
            setErrorMessage("Unable to delete client.");
            System.out.println(e.getMessage());
            return false;
        }
    } //end of deleteClient()

    // This method selects all the clients from the clients table in the database and returns them as a list
    public ArrayList<Clients> selectAllClients() {
        try {
            statement = conn.createStatement();
            ArrayList<Clients> allClients;
            try (ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CLIENTS)) {
                allClients = new ArrayList<>();
                while (results.next()) {
                    Clients client = new Clients(results.getInt(COLUMN_CLIENT_ID), results.getString(COLUMN_CLIENT_FIRST_NAME),
                            results.getString(COLUMN_CLIENT_LAST_NAME), results.getString(COLUMN_CLIENT_PHONE_NUMBER),
                            results.getString(COLUMN_CLIENT_EMAIL));
                    allClients.add(client);
                }
            }
            statement.close();
            return allClients;
        } catch (SQLException e) {
            setErrorMessage("Could not find any clients.");
            return null;
        }
    } //end of selectAllClients()

    // This method updates a client with edited information in the clients table in the database
    public boolean updateClient(int clientID, String firstName, String lastName, String phoneNumber, String email) {
        String sql = "UPDATE " + TABLE_CLIENTS
            + " SET " + COLUMN_CLIENT_FIRST_NAME + "=?, "
            + COLUMN_CLIENT_LAST_NAME + "=?, "
            + COLUMN_CLIENT_PHONE_NUMBER + "=?, "
            + COLUMN_CLIENT_EMAIL + "=? "
            + "WHERE " + COLUMN_CLIENT_ID + "=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, email);
            pstmt.setInt(5, clientID);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e)  {
            setErrorMessage("Unable to update client.");
            System.out.println(e.getMessage());
            return false;
        }
    } //end of updateClient()

} //end of Database
