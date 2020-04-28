/**
 * File: Appointments.java
 * Date: April 16, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Appointments.
 */
package vetportal;

import java.sql.Time;
import java.util.Date;

public class Appointments {

    private String aptDate;
    private String aptTime;
    private String client;
    private String pet;
    private String aptReason;

    //TODO in Development Phase III: figure out what needs to be created / pulled from GUI and how
    public Appointments(String aptDate, String aptTime, String client, String pet, String aptReason) {
        this.aptDate = aptDate;
        this.aptTime = aptTime;
        this.client = client;
        this.pet = pet;
        this.aptReason = aptReason;
    } //end of constructor

    public String getAptDate() {
        return aptDate;
    }

    public String getAptTime() {
        return aptTime;
    }

    public String getClient() {
        return client;
    }

    public String getPet() {
        return pet;
    }

    public String getAptReason() {
        return aptReason;
    }
} //end of Appointments
