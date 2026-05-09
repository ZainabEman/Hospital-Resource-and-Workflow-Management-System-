package models;

public abstract class Staff {
    protected String name;
    protected int staffId;

    public Staff(String name, int staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    public abstract void performDuties();
    
    // CODE SMELL: Refused Bequest
    public abstract void performSurgery();
}
