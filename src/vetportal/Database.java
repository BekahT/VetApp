/**
 * File: Datasource.java
 * Date: March 28, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class acts as the model for the SQLite database and contains the direct methods for specific interactions.
 */

package vetportal;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteErrorCode;
import java.sql.*;

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
