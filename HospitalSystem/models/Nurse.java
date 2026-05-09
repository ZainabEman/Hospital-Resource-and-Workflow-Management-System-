package models;

public class Nurse extends Staff {
    public String shift;
    
    public Nurse(String name, int staffId, String shift) {
        super(name, staffId);
        this.shift = shift;
    }

    @Override
    public void performDuties() {
        System.out.println("Nurse checking vitals.");
    }

    // CODE SMELL: Refused Bequest
    @Override
    public void performSurgery() {
        throw new UnsupportedOperationException("Nurses do not perform surgery!");
    }
}
