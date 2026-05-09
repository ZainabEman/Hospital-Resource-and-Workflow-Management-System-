package models;

public class Appointment {
    public int appointmentId;
    public String date;
    public String time;
    public Doctor doctor;
    public Patient patient;
    
    // CODE SMELL: Data Clumps
    public String patientSymptom1;
    public String patientSymptom2;
    public int painLevel;
    public String previousMedication;

    public Appointment(int appointmentId, String date, String time, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }
    
    public Patient getPatient() { return patient; }
}
