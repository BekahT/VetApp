/**
 * File: Pets.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Pets.
 */

package vetportal;

import java.util.Date;

public class Pets1 {

    private int petID;
    private String petName;
    private String petSpecies;
    private String petGender;
    private Date petDateOfBirth; //TODO: figure out implementation and possibly change to java.sql.Date vs java.util.Date?
    private int petOwner;

    //TODO: add petID and petDateOfBirth
    public Pets1(String petName, String petSpecies, String petGender, int petOwner) {
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.petGender = petGender;
        this.petOwner = petOwner;
    } //end of constructor


} //end of Pets
