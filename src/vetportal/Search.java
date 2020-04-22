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
