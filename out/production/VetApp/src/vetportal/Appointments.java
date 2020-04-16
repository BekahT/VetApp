/**
 * File: Appointments.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Appointments.
 */

package vetportal;

import java.sql.Time;
import java.util.Date;

public class Appointments {

    private Date aptDate;
    private Time aptTime;
    private int client;
    private int pet;
    private String aptReason;

    //TODO: figure out what needs to be created / pulled from GUI and how
    public Appointments(String aptReason) {
        this.aptReason = aptReason;
    } //end of constructor

} //end of Appointments
