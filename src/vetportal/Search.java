/**
 * File: Search.java
 * Date: April 20, 2020
 * @Author: Rebekah Qu
 * Purpose: This class is used to filter table data based on passed search criteria
 */
package vetportal;

import java.util.List;
import java.util.stream.Collectors;

public class Search {   
    
    // Search for pets based on any of the three criteria, missing criteria is passed an empty string
    // Returns the list of pets that were matched
    public static List<Pets> searchPets(List<Pets> pets, String petName, String petOwner, String petDOB) {       
        // Search on Pet Name, Owner Name, and Pet Date of Birth        
        if (!"".equals(petName) && !"".equals(petOwner) && !"    -  -  ".equals(petDOB)) {
            List<Pets> matches = pets.stream()
                    .filter(p -> p.getPetName().equalsIgnoreCase(petName) && p.getPetOwner().equalsIgnoreCase(petOwner) && p.getPetDateOfBirth().equalsIgnoreCase(petDOB))
                    .collect(Collectors.toList());
            return matches;
        
        // Search on Pet Name and Owner Name
        } else if (!"".equals(petName) && !"".equals(petOwner) && "    -  -  ".equals(petDOB)) {
            List<Pets> matches = pets.stream()
                .filter(p -> p.getPetName().equalsIgnoreCase(petName) && p.getPetOwner().equalsIgnoreCase(petOwner))
                .collect(Collectors.toList());
            return matches;
            
        // Search on Pet Name and Pet Date of Birth        
        } else if (!"".equals(petName) && "".equals(petOwner) && !"    -  -  ".equals(petDOB)) {
            List<Pets> matches = pets.stream()
                    .filter(p -> p.getPetName().equalsIgnoreCase(petName) && p.getPetDateOfBirth().equalsIgnoreCase(petDOB))
                    .collect(Collectors.toList());
            return matches;   
        
        // Search on Owner Name and Pet Date of Birth    
        } else if ("".equals(petName) && !"".equals(petOwner) && !"    -  -  ".equals(petDOB)) {
            List<Pets> matches = pets.stream()
                    .filter(p -> p.getPetOwner().equalsIgnoreCase(petOwner) && p.getPetDateOfBirth().equalsIgnoreCase(petDOB))
                    .collect(Collectors.toList());
            return matches;
        
        // Search on Pet Name only    
        } else if (!"".equals(petName) && "".equals(petOwner) && "    -  -  ".equals(petDOB)) {
            List<Pets> matches = pets.stream()
                    .filter(p -> p.getPetName().equalsIgnoreCase(petName))
                    .collect(Collectors.toList());
            return matches; 
        
        // Search on Owner Name only        
        } else if ("".equals(petName) && !"".equals(petOwner) && "    -  -  ".equals(petDOB)){
            List<Pets> matches = pets.stream()
                    .filter(p -> p.getPetOwner().equalsIgnoreCase(petOwner))
                    .collect(Collectors.toList());
            return matches; 
            
        // Search on Pet Date of Birth only
        } else if ("".equals(petName) && !"    -  -  ".equals(petDOB)) {
            List<Pets> matches = pets.stream()
                    .filter(p -> p.getPetDateOfBirth().equalsIgnoreCase(petDOB))
                    .collect(Collectors.toList());
            return matches; 
        }           
        return null;
    }
    
    // Search for clients based on any of the three criteria, missing criteria is passed as an empty string
    // Returns the list of clients that were matched
    public static List<Clients> searchClients(List<Clients> clients, String lastName, String email, String phone) {       
        // Search on Last Name, Email, and Phone Number
        if (!"".equals(lastName) && !"".equals(email) && !"(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientLastName().equalsIgnoreCase(lastName) && c.getClientEmail().equalsIgnoreCase(email) && c.getClientPhoneNumber().equalsIgnoreCase(phone))
                .collect(Collectors.toList());       
            return matches;
        // Search on Last Name and Email only
        } else if (!"".equals(lastName) && !"".equals(email) && "(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientLastName().equalsIgnoreCase(lastName) && c.getClientEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());       
            return matches;
        // Search on Last Name and Phone Only
        } else if (!"".equals(lastName) && "".equals(email) && !"(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientLastName().equalsIgnoreCase(lastName) && c.getClientPhoneNumber().equalsIgnoreCase(phone))
                .collect(Collectors.toList());       
            return matches;
        // Search on Email and Phone Only
        } else if ("".equals(lastName) && !"".equals(email) && !"(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientEmail().equalsIgnoreCase(email) && c.getClientPhoneNumber().equalsIgnoreCase(phone))
                .collect(Collectors.toList());       
            return matches;
        // Search on Last Name Only
        } else if (!"".equals(lastName) && "".equals(email) && "(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());       
            return matches;
        // Search on Email Only
        } else if ("".equals(lastName) && !"".equals(email) && "(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());       
            return matches;
        // Search on Phone Number Only
        } else if ("".equals(lastName) && "".equals(email) && !"(   )    -    ".equals(phone)) {
            List<Clients> matches = clients.stream()
                .filter(c -> c.getClientPhoneNumber().equalsIgnoreCase(phone))
                .collect(Collectors.toList());       
            return matches;
        }
    return null;
    }
}
