package controllers;

import models.Patient;
import database.GlobalDatabase;
import services.BillingManager;
import java.util.Scanner;

// CODE SMELL: Divergent Change
public class HospitalController {
    
    public void startSystem() {
        System.out.println("Welcome to Hospital Resource and Workflow Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. Process Billing");
        System.out.println("3. Exit");
        
        int choice = 1; 
        
        if(choice == 1) {
            addPatientLogic();
        } 
        
        processBillingLogic();
    }
    
    private void addPatientLogic() {
        Patient p = new Patient(1, "John", "Doe", 45, "O+", "123 Main St", "City", "12345", "555-1234", "BlueCross", "POL123", 0);
        GlobalDatabase.getInstance().patients.add(p);
        System.out.println("Patient added.");
    }
    
    private void processBillingLogic() {
        if (!GlobalDatabase.getInstance().patients.isEmpty()) {
            Patient p = GlobalDatabase.getInstance().patients.get(0);
            BillingManager bm = new BillingManager();
            
            String[] services = {"Blood Test", "X-Ray"};
            int[] costs = {100, 250};
            
            bm.processBillingAndGenerateInvoice(p, services, costs, true, "Standard", 3, false);
        }
    }
}
