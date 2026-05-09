package models;

// CODE SMELL: Data Class
// CODE SMELL: Primitive Obsession
public class Patient {
    public int id;
    public String firstName;
    public String lastName;
    public int age;
    public String bloodType; // Should be an enum
    public String street; // Should be Address object
    public String city;
    public String zipCode;
    public String phone;
    public String insuranceProvider;
    public String insurancePolicyNumber;
    public int status; // 0 = New, 1 = Admitted, 2 = Discharged
    
    // CODE SMELL: Long Parameter List
    public Patient(int id, String firstName, String lastName, int age, String bloodType, String street, String city, String zipCode, String phone, String insuranceProvider, String insurancePolicyNumber, int status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bloodType = bloodType;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.insuranceProvider = insuranceProvider;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.status = status;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getZipCode() { return zipCode; }
    public String getInsuranceProvider() { return insuranceProvider; }
}
