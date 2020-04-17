/**
 * File: Database.java
 * Date: March 28, 2020
 * @Author: Brian Rease, Nour Debiat
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
        try {
            statement = conn.createStatement();
            ResultSet idResult = statement.executeQuery("SELECT " + COLUMN_CLIENT_ID +
                                                            " FROM " + TABLE_CLIENTS + " WHERE " +
                                                            COLUMN_CLIENT_PHONE_NUMBER + "=\'" +
                                                            phoneNumber + "\'");
            return idResult.getInt("client_id");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return -1;
        }
    } //end of getClientID()

    /*
    This method uses the Apache commons codec to hash a given 'password' String with sha256.
    The hash is then compared to a password hash in the sqlite database
     */
    public boolean authenticate(String username, String password) {
        try {
            String passwordHash = DigestUtils.sha256Hex(password);

            statement = conn.createStatement();
            ResultSet authResult = statement.executeQuery("SELECT " + COLUMN_USER_PASSWORD +
                                                                " FROM " + TABLE_USERS + " WHERE "
                                                            + COLUMN_USER_NAME + "='" + username + "'");

            if (passwordHash.equals(authResult.getString(COLUMN_USER_PASSWORD))) {
                return true;
            }
            statement.close();
            return false;
        } catch (SQLException e) {
            System.out.println("Authentication unsuccessful: " + e.getMessage());
            return false;
        }
    } //end of authenticate()

    public boolean insertClient(String firstName, String lastName, String phoneNumber, String email) {
        try {
            statement = conn.createStatement();
            statement.execute("INSERT INTO " + TABLE_CLIENTS +
                    " (" + COLUMN_CLIENT_FIRST_NAME +
                    ", " + COLUMN_CLIENT_LAST_NAME +
                    ", " + COLUMN_CLIENT_PHONE_NUMBER +
                    ", " + COLUMN_CLIENT_EMAIL + ") VALUES (\'" +
                    firstName + "\', \'" + lastName + "\', \'" + phoneNumber + "\', \'" + email + "\')");
            statement.close();
            return true;
        } catch (SQLException e) {
            if (SQLiteErrorCode.SQLITE_CONSTRAINT_UNIQUE.code == 2067) {
                setErrorMessage("The phone number you entered is already in the database!");
            } else {
                setErrorMessage("Unable to create new client.\n" + e.getMessage());
            }
            return false;
        }
    } //end of insertClient()

    public boolean deleteClient(String phoneNumber) {
        try {
            statement = conn.createStatement();
            statement.execute("DELETE FROM " + TABLE_CLIENTS +
                    " WHERE " + COLUMN_CLIENT_PHONE_NUMBER +
                    "=\'" + phoneNumber + "\'");
            statement.close();
            return true;
        } catch (SQLException e) {
            setErrorMessage("Unable to delete client.\n" + e.getMessage());
            return false;
        }
    } //end of deleteClient()

    public ArrayList<Clients> selectAllClients() {
        try {
            statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CLIENTS);
            ArrayList<Clients> allClients = new ArrayList<>();
            while(results.next()) {
                Clients client = new Clients(results.getInt(COLUMN_CLIENT_ID), results.getString(COLUMN_CLIENT_FIRST_NAME),
                                            results.getString(COLUMN_CLIENT_LAST_NAME), results.getString(COLUMN_CLIENT_PHONE_NUMBER),
                                            results.getString(COLUMN_CLIENT_EMAIL));
                allClients.add(client);
            }
            results.close();
            statement.close();
            return allClients;
        } catch (SQLException e) {
            setErrorMessage("Could not find any clients.");
            return null;
        }
    } //end of selectAllClients()

    public boolean updateClient(int clientID, String firstName, String lastName, String phoneNumber, String email) {
        try {
            statement = conn.createStatement();
            statement.execute("UPDATE " + TABLE_CLIENTS +
                    " SET " + COLUMN_CLIENT_FIRST_NAME + "=\'" + firstName +
                    "\', " + COLUMN_CLIENT_LAST_NAME + "=\'" + lastName +
                    "\', " + COLUMN_CLIENT_PHONE_NUMBER + "=\'" + phoneNumber +
                    "\', " + COLUMN_CLIENT_EMAIL + "=\'" + email +
                    "\' WHERE " + COLUMN_CLIENT_ID + "=" + clientID);
            statement.close();
            return true;
        } catch (SQLException e) {
            setErrorMessage("Unable to update client.\n" + e.getMessage());
            return false;
        }
    } //end of updateClient()

    private void setErrorMessage(String message) {
        errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertClient(String firstName, String lastName, String phoneNumber, String email) {
        try {
            statement = conn.createStatement();
            statement.execute("INSERT INTO " + TABLE_CLIENTS +
                    " (" + COLUMN_CLIENT_FIRST_NAME +
                    ", " + COLUMN_CLIENT_LAST_NAME +
                    ", " + COLUMN_CLIENT_PHONE_NUMBER +
                    ", " + COLUMN_CLIENT_EMAIL + ") VALUES (\'" +
                    firstName + "\', \'" + lastName + "\', \'" + phoneNumber + "\', \'" + email + "\')");
            statement.close();
            return true;
        } catch (SQLException e) {
            if (SQLiteErrorCode.SQLITE_CONSTRAINT_UNIQUE.code == 2067) {
                //System.out.println("The phone number you entered is already in the database! Please try again.");
                setErrorMessage("The phone number you entered is already in the database! Please try again.");
            } else {
                //System.out.println("Unable to create new client.\n" + e.getMessage());
                setErrorMessage("Unable to create new client.\n" + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    } //end of insertClient()

} //end of Database
