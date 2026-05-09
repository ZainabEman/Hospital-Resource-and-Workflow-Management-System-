package services;

import models.Appointment;
import models.Doctor;
import models.Patient;
import database.GlobalDatabase;

public class SchedulingService {

    // CODE SMELL: Feature Envy
    public void scheduleAppointment(Appointment app) {
        Doctor doc = app.doctor;
        Patient pat = app.patient;
        
        System.out.println("Scheduling appointment for " + pat.firstName + " with Dr. " + doc.name);
        
        // CODE SMELL: Message Chains
        String patientZip = app.getPatient().getZipCode();
        String insurance = app.getPatient().getInsuranceProvider();
        
        System.out.println("Checking insurance " + insurance + " for zip " + patientZip);
        
        GlobalDatabase.getInstance().appointments.add(app);
    }
}
