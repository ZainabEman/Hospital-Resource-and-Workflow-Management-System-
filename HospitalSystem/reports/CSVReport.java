package reports;

import database.GlobalDatabase;
import models.Patient;

public class CSVReport extends Report {
    
    public CSVReport(String title) {
        super(title);
    }

    @Override
    public void generate() {
        System.out.println("Generating CSV Report: " + title);
        System.out.println("FirstName,LastName,Age");
        
        // CODE SMELL: Shotgun Surgery
        for (Patient p : GlobalDatabase.getInstance().patients) {
            System.out.println(p.firstName + "," + p.lastName + "," + p.age);
        }
    }
}
