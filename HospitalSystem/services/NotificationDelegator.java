package services;

import models.Patient;
import utils.EmailSender;

// CODE SMELL: Middleman
public class NotificationDelegator {
    private EmailSender emailSender;

    public NotificationDelegator() {
        this.emailSender = new EmailSender();
    }

    public void sendEmailToPatient(Patient patient, String message) {
        emailSender.sendEmail(patient.firstName + "@example.com", message);
    }
}
