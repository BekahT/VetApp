/**
 * File: Pets.java
 * Date: March 26, 2020
 * @Author: Brian Rease, Nour Debiat
 * Main POC: Brian Rease
 * Purpose: This class is used to create new Pets.
 */

package vetportal;

import java.sql.Date;

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
} //end of Pets
