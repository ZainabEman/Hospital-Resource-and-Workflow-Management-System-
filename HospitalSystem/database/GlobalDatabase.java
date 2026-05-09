package database;

import models.Patient;
import models.Doctor;
import models.Nurse;
import models.Appointment;

import java.util.ArrayList;
import java.util.List;

// CODE SMELL: Large Class / God Class
// CODE SMELL: Inappropriate Intimacy
public class GlobalDatabase {
    public static GlobalDatabase instance = new GlobalDatabase();
    
    public List<Patient> patients = new ArrayList<>();
    public List<Doctor> doctors = new ArrayList<>();
    public List<Nurse> nurses = new ArrayList<>();
    public List<Appointment> appointments = new ArrayList<>();
    
    public List<String> inventory = new ArrayList<>();
    public List<String> billingRecords = new ArrayList<>();
    public List<String> feedback = new ArrayList<>();
    
    private GlobalDatabase() {}

    public static GlobalDatabase getInstance() {
        return instance;
    }
}
