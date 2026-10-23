// ============================================================================
// Assignment 1 - TASK 12: OneDayPass.java
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Models an all-day visitor pass granting unlimited campus parking for a flat rate.
// ============================================================================

public class OneDayPass {
    private String passId;
    private String visitorName;
    private String vehiclePlate;
    private String visitPurpose;
    private static final double ONE_DAY_PASS_PRICE = 150.0; // Flat INR fee for the full day
    private boolean isExpired;

    public OneDayPass(String passId, String visitorName, String vehiclePlate, String visitPurpose) {
        this.passId = passId;
        this.visitorName = visitorName;
        this.vehiclePlate = vehiclePlate.trim().toUpperCase();
        this.visitPurpose = visitPurpose;
        this.isExpired = false;
    }

    public String getPassId() {
        return passId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public double getPassCost() {
        return ONE_DAY_PASS_PRICE;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void expirePass() {
        this.isExpired = true;
    }

    public void displayPass() {
        System.out.println("==========================================");
        System.out.println("       CAMPUS VISITOR ONE-DAY PASS        ");
        System.out.println("==========================================");
        System.out.println("Pass ID       : " + passId);
        System.out.println("Visitor Name  : " + visitorName);
        System.out.println("Vehicle Plate : " + vehiclePlate);
        System.out.println("Visit Purpose : " + visitPurpose);
        System.out.println("Fixed Cost    : Rs " + ONE_DAY_PASS_PRICE + " (Valid all day)");
        System.out.println("Status        : " + (isExpired ? "EXPIRED" : "ACTIVE"));
        System.out.println("==========================================\n");
    }
}
