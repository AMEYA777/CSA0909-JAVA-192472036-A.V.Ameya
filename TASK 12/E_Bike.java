// ============================================================================
// Assignment 1 - TASK 12: E_Bike.java
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Models an eco-friendly campus E-Bike charged with a flat parking fee.
// ============================================================================

public class E_Bike {
    private String serialNumber;
    private String riderName;
    private static final double FLAT_FEE = 20.0; // Flat fee in INR regardless of duration

    public E_Bike(String serialNumber, String riderName) {
        this.serialNumber = serialNumber.trim().toUpperCase();
        this.riderName = riderName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getRiderName() {
        return riderName;
    }

    /**
     * Requirement: Flat parking fee calculation for E-Bikes.
     */
    public double calculateFee(int entryHour, int exitHour) {
        // E-Bikes are charged a flat subsidised fee to encourage green transport
        return FLAT_FEE;
    }

    public void displayDetails() {
        System.out.println("  E-Bike Serial : " + serialNumber);
        System.out.println("  Rider Name    : " + riderName);
        System.out.println("  Fee Policy    : Flat Rate Rs " + FLAT_FEE + " (All-day)");
    }
}
