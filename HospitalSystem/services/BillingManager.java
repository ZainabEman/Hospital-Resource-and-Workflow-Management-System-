package services;

import models.Patient;
import database.GlobalDatabase;

public class BillingManager {

    // CODE SMELL: Long Method
    // CODE SMELL: Switch Statements
    // CODE SMELL: Complex CFG (deep nesting, loops, branches)
    public void processBillingAndGenerateInvoice(Patient patient, String[] servicesRendered, int[] serviceCosts, boolean hasInsurance, String insuranceType, int daysAdmitted, boolean isICU) {
        System.out.println("Starting billing process for patient: " + patient.firstName + " " + patient.lastName);
        
        double totalCost = 0.0;
        double discount = 0.0;
        double insuranceCoverage = 0.0;
        double finalAmount = 0.0;
        
        for (int i = 0; i < servicesRendered.length; i++) {
            String service = servicesRendered[i];
            int cost = serviceCosts[i];
            
            if (service != null && !service.isEmpty()) {
                if (service.equals("Blood Test")) {
                    totalCost += cost;
                } else if (service.equals("X-Ray")) {
                    totalCost += cost;
                    if (isICU) {
                        totalCost += 50.0;
                    }
                } else if (service.equals("MRI")) {
                    totalCost += cost;
                    if (daysAdmitted > 5) {
                        totalCost += 100.0;
                    }
                } else if (service.equals("Surgery")) {
                    totalCost += cost;
                    if (isICU) {
                        totalCost += 500.0;
                    } else {
                        totalCost += 200.0;
                    }
                } else {
                    totalCost += cost;
                }
            }
        }
        
        if (hasInsurance) {
            if (insuranceType != null) {
                switch (insuranceType) {
                    case "Premium":
                        if (totalCost > 1000) {
                            insuranceCoverage = totalCost * 0.90;
                        } else {
                            insuranceCoverage = totalCost * 0.95;
                        }
                        break;
                    case "Standard":
                        if (totalCost > 2000) {
                            insuranceCoverage = totalCost * 0.70;
                        } else if (totalCost > 1000) {
                            insuranceCoverage = totalCost * 0.80;
                        } else {
                            insuranceCoverage = totalCost * 0.85;
                        }
                        break;
                    case "Basic":
                        if (isICU) {
                            insuranceCoverage = totalCost * 0.40;
                        } else {
                            insuranceCoverage = totalCost * 0.50;
                        }
                        break;
                    case "State":
                        if (patient.age > 65) {
                            insuranceCoverage = totalCost * 1.0;
                        } else if (patient.age < 18) {
                            insuranceCoverage = totalCost * 1.0;
                        } else {
                            insuranceCoverage = totalCost * 0.60;
                        }
                        break;
                    default:
                        insuranceCoverage = 0.0;
                        break;
                }
            }
        } else {
            if (patient.age > 65) {
                discount = totalCost * 0.20;
            } else if (patient.age < 12) {
                discount = totalCost * 0.15;
            }
            
            if (daysAdmitted > 10) {
                discount += totalCost * 0.05;
            } else if (daysAdmitted > 20) {
                discount += totalCost * 0.10;
            }
        }
        
        int roomCostPerDay = 200;
        if (isICU) {
            roomCostPerDay = 1000;
        }
        
        int totalRoomCost = daysAdmitted * roomCostPerDay;
        totalCost += totalRoomCost;
        
        if (totalCost > 5000 && !hasInsurance) {
            discount += 200.0;
        }
        
        finalAmount = totalCost - insuranceCoverage - discount;
        
        if (finalAmount < 0) {
            finalAmount = 0.0;
        }
        
        System.out.println("=====================================");
        System.out.println("INVOICE FOR: " + patient.firstName + " " + patient.lastName);
        System.out.println("Age: " + patient.age);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Insurance Coverage: $" + insuranceCoverage);
        System.out.println("Discount Applied: $" + discount);
        System.out.println("Final Amount Due: $" + finalAmount);
        System.out.println("=====================================");
        
        GlobalDatabase.getInstance().billingRecords.add("Patient ID: " + patient.id + " Amount: $" + finalAmount);
    }
}
