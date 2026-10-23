// ============================================================================
// Assignment 1 - TASK 10: Encapsulation, Access Modifiers & Defensive Validation
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate data hiding using private fields, the 4 Java access modifiers,
//          and defensive validation inside getter and setter methods.
// ============================================================================

class EncapsulatedParkingSession {
    // ------------------------------------------------------------------------
    // 1. PRIVATE FIELDS (Data Hiding)
    // Directly inaccessible from outside classes. Must use getters/setters.
    // ------------------------------------------------------------------------
    private String registrationNumber;
    private int floorNumber;        // Allowed campus floors: 0 to 4
    private int parkedHours;        // Allowed range: 1 to 24 hours
    private double hourlyRate;      // Must be positive
    private boolean isPaid;

    // ------------------------------------------------------------------------
    // 2. PACKAGE-PRIVATE (Default) & PROTECTED FIELDS (Access Modifier Demo)
    // ------------------------------------------------------------------------
    String sessionNotes;            // Default (package-private)
    protected String securityBadge; // Protected: accessible to subclasses

    // Constructor enforcing validation through setters
    public EncapsulatedParkingSession(String regNo, int floor, int hours, double rate) {
        setRegistrationNumber(regNo);
        setFloorNumber(floor);
        setParkedHours(hours);
        setHourlyRate(rate);
        this.isPaid = false;
        this.sessionNotes = "Standard Session";
        this.securityBadge = "PASS-REGULAR";
    }

    // ------------------------------------------------------------------------
    // 3. GETTERS AND VALIDATING SETTERS
    // ------------------------------------------------------------------------

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String regNo) {
        // Validation: Cannot be null, must be between 6 and 12 alphanumeric characters
        if (regNo == null || regNo.trim().length() < 6 || regNo.trim().length() > 12) {
            System.out.println("[VALIDATION ERROR] Invalid registration number: '" + regNo + 
                               "'. Must be 6 to 12 characters. Modification rejected!");
            return;
        }
        this.registrationNumber = regNo.trim().toUpperCase();
        System.out.println("[SUCCESS] Registration number updated to: " + this.registrationNumber);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floor) {
        // Validation: Campus parking structure only has Floors 0, 1, 2, 3, 4
        if (floor < 0 || floor > 4) {
            System.out.println("[VALIDATION ERROR] Floor " + floor + " does not exist! Campus floors are 0 to 4. Keeping Floor " + this.floorNumber);
            return;
        }
        this.floorNumber = floor;
        System.out.println("[SUCCESS] Floor updated to: Floor " + this.floorNumber);
    }

    public int getParkedHours() {
        return parkedHours;
    }

    public void setParkedHours(int hours) {
        // Validation: Duration cannot be zero or negative, maximum single session is 24 hrs
        if (hours <= 0) {
            System.out.println("[VALIDATION ERROR] Parking duration must be at least 1 hour. Input was: " + hours);
            return;
        }
        if (hours > 24) {
            System.out.println("[VALIDATION ERROR] Maximum allowed single-session parking is 24 hours. Input was: " + hours);
            return;
        }
        this.parkedHours = hours;
        System.out.println("[SUCCESS] Parked duration updated to: " + this.parkedHours + " hour(s)");
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double rate) {
        // Validation: Rate cannot be negative
        if (rate < 0.0) {
            System.out.println("[VALIDATION ERROR] Hourly rate cannot be negative! Rejected: Rs " + rate);
            return;
        }
        this.hourlyRate = rate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    // Business method computing total cost securely
    public double calculateTotalFee() {
        return this.parkedHours * this.hourlyRate;
    }

    public void displaySessionSummary() {
        System.out.println("  Plate Number  : " + registrationNumber);
        System.out.println("  Floor         : Floor " + floorNumber);
        System.out.println("  Duration      : " + parkedHours + " hrs");
        System.out.println("  Rate / Hour   : Rs " + hourlyRate);
        System.out.println("  Total Fee     : Rs " + calculateTotalFee());
        System.out.println("  Paid Status   : " + (isPaid ? "PAID" : "PENDING"));
        System.out.println("  --------------------------------------");
    }
}

/**
 * Main Class for Task 10
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" TASK 10: ENCAPSULATION & DATA VALIDATION DEMO    ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Creating Encapsulated Object with Valid Data ---");
        EncapsulatedParkingSession session = new EncapsulatedParkingSession("TN01BB9999", 2, 3, 20.0);
        session.displaySessionSummary();

        System.out.println("\n--- 2. Testing Defensive Validation (Invalid Inputs) ---");
        System.out.println("Attempting to set an invalid negative duration (-5 hours):");
        session.setParkedHours(-5); // Will be rejected by validation

        System.out.println("\nAttempting to set an invalid floor (Floor 9):");
        session.setFloorNumber(9); // Will be rejected by validation

        System.out.println("\nAttempting to set an invalid empty/short registration plate ('AB'):");
        session.setRegistrationNumber("AB"); // Too short, will be rejected

        System.out.println("\nAttempting to set a negative rate (-50.0):");
        session.setHourlyRate(-50.0); // Rejected

        System.out.println("\n--- 3. Verifying Object State Remains Intact & Uncorrupted ---");
        session.displaySessionSummary();

        System.out.println("--- 4. Applying Valid Updates ---");
        session.setParkedHours(5);
        session.setFloorNumber(3);
        session.setPaid(true);
        session.displaySessionSummary();
    }
}
