package utils;

public class ValidationUtils {

    // CODE SMELL: Duplicate Code
    public boolean validateDoctorName(String name) {
        if (name == null) return false;
        if (name.isEmpty()) return false;
        if (name.length() < 2) return false;
        if (name.length() > 50) return false;
        return true;
    }

    // CODE SMELL: Duplicate Code
    public boolean validatePatientName(String name) {
        if (name == null) return false;
        if (name.isEmpty()) return false;
        if (name.length() < 2) return false;
        if (name.length() > 50) return false;
        return true;
    }

    // CODE SMELL: Speculative Generality
    public boolean validateIntergalacticPatientID(String id) {
        if (id.startsWith("MARS-")) return true;
        return false;
    }
    
    // CODE SMELL: Excessive Comments
    /**
     * This method validates the age.
     * It takes an integer age.
     * It checks if the age is greater than 0.
     * It checks if the age is less than 150.
     * It returns true if valid.
     * It returns false if invalid.
     * 
     * @param age The age to validate
     * @return boolean True if valid, false otherwise
     */
    public boolean validateAge(int age) {
        if (age > 0 && age < 150) {
            return true;
        }
        return false;
    }
}
