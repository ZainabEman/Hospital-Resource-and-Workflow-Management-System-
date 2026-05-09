package legacy;

import models.Appointment;
import database.GlobalDatabase;

// CODE SMELL: Alternative Classes with Different Interfaces
public class AppointmentManager {
    
    public void bookNewMeeting(Appointment appointment) {
        System.out.println("Booking meeting...");
        GlobalDatabase.getInstance().appointments.add(appointment);
    }
    
    public void cancelMeeting(Appointment appointment) {
        GlobalDatabase.getInstance().appointments.remove(appointment);
    }
}
