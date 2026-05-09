package models;

public class Doctor extends Staff {
    public String specialty;
    
    // CODE SMELL: Temporary Fields
    public String currentSurgeryRoom;
    public boolean isSterilized;
    
    public Doctor(String name, int staffId, String specialty) {
        super(name, staffId);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Doctor examining patients.");
    }

    @Override
    public void performSurgery() {
        this.isSterilized = true;
        this.currentSurgeryRoom = "OR-1";
        System.out.println("Performing surgery in " + currentSurgeryRoom);
    }
}
