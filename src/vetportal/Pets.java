/**
 * File: Pets.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Pets.
 */
package vetportal;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pets {

    private int petID;
    private String petName;
    private String petSpecies;
    private String petGender;
    private String petDateOfBirth; //TODO: figure out implementation and possibly change to java.sql.Date vs java.util.Date?
    private int petOwner;

    //TODO in Phase II: add petID and petDateOfBirth
    public Pets(int petID, String petName, String petSpecies, String petGender, String petDateOfBirth, int petOwner) {
        this.petID = petID;
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.petGender = petGender;
        this.petDateOfBirth = petDateOfBirth;
        this.petOwner = petOwner;
    } //end of constructor

    public int getPetID() {
        return petID;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetSpecies() {
        return petSpecies;
    }

    public String getPetGender() {
        return petGender;
    }

    public String getPetDateOfBirth() {
        return petDateOfBirth;
    }

    public int getPetOwner() {
        return petOwner;
    }

    //Validate date of birth
    public static Boolean validateDOB(String petDOB) throws ParseException {
        //format date to match field input
        DateFormat formatDate = new SimpleDateFormat("MM/dd/yy");
        //get today's date
        Date todayDate = new Date();
        //correctly format today's date
        Date cTodayDate = formatDate.parse(formatDate.format(todayDate));
        //correctly format user input
        Date cPetDOB = formatDate.parse(petDOB);

        //compare the current date to input
        //if today's date is after the pet's dob (pet's dob in past)
        if (cTodayDate.compareTo(cPetDOB) > 0) {
            //return true (valid DOB)
            System.out.println("true");
            return true;
        }
        //otherwise, return false (invalid dob)
        else {
            System.out.println("false");
            return false;
        }
    }
} //end of Pets
