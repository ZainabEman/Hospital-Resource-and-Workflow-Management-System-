package reports;

import database.GlobalDatabase;
import models.Patient;

public class PDFReport extends Report {
    
    public PDFReport(String title) {
        super(title);
    }

    @Override
    public void generate() {
        System.out.println("Generating PDF Report: " + title);
        
        // CODE SMELL: Shotgun Surgery
        for (Patient p : GlobalDatabase.getInstance().patients) {
            System.out.println("PDF ROW: " + p.firstName + " " + p.lastName + " - " + p.age);
        }
    }
}
