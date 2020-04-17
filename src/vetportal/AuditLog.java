/**
 * File: AuditLog.java
 * Date: April 16, 2020
 * @Author: Rebekah Qu
 * Main POC:  Rebekah Qu
 * Purpose: This class takes events triggered in the application and logs them
 *
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class AuditLog {
     public static void logWriter(String event, String info) {
        // Try-with-resources write to a file with append being true, so the log retains old events
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("auditLog.txt", true))) {
            switch(event){
                case ("successfulLogin"): 
                    writer.write(Instant.now() + " - Type: Login - Location: VetPortal Login " 
                        + "- Outcome: Successful Login - " + info + "\n");
                    break;
                case ("failedLogin"):
                    writer.write(Instant.now() + " - Type: Login - Location: VetPortal Login " 
                        + "- Outcome: Failed Login - " + info + "\n");
                    break;    
                case ("accountLockout"):
                    writer.write(Instant.now() + " - Type: Login - Location: VetPortal Login " 
                        + "- Outcome: Account Lockout - " + info + "\n");
                    break; 
                case ("successfulClientAdd"):
                    writer.write(Instant.now() + " - Type: Add Client - Location: VetPortal New Client " 
                        + "- Outcome: Successful New Client Creation - " + info + "\n");
                    break;
                case ("successfulClientEdit"):
                    writer.write(Instant.now() + " - Type: Edit Client - Location: VetPortal Edit Client " 
                        + "- Outcome: Successful Client Edit - " + info + "\n");
                    break;
                case ("successfulClientDelete"):
                    writer.write(Instant.now() + " - Type: Delete Client - Location: VetPortal Client Dashboard " 
                        + "- Outcome: Successful Client Delete - " + info + "\n");
                    break;
            }            
        // Catch errors
        } catch (IOException io) {
            System.out.println("File IO Exception");
        }
    }
}
