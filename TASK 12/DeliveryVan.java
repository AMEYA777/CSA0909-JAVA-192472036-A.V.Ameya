// ============================================================================
// Assignment 1 - TASK 12: DeliveryVan.java
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Models campus commercial delivery vans charged double the standard car
//          rate during business peak hours (9:00 AM to 5:00 PM / 09:00 to 17:00).
// ============================================================================

public class DeliveryVan {
    private String registrationPlate;
    private String deliveryCompany; // e.g. "Amazon Campus Logistics", "Courier"
    private static final double STANDARD_CAR_RATE = 30.0;
    private static final int PEAK_START_HOUR = 9;  // 9:00 AM
    private static final int PEAK_END_HOUR = 17;   // 5:00 PM (17:00)

    public DeliveryVan(String registrationPlate, String deliveryCompany) {
        this.registrationPlate = registrationPlate.trim().toUpperCase();
        this.deliveryCompany = deliveryCompany;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    /**
     * Requirement: Delivery vans charged at double the car rate during 9 AM–5 PM.
     * Evaluates hour-by-hour intervals.
     */
    public double calculateFee(int entryHour, int exitHour) {
        if (exitHour <= entryHour) {
            exitHour = entryHour + 1; // Minimum 1-hour charge
        }

        double totalFee = 0.0;
        int peakHours = 0;
        int normalHours = 0;

        for (int h = entryHour; h < exitHour; h++) {
            if (h >= PEAK_START_HOUR && h < PEAK_END_HOUR) {
                // Peak delivery window (9 AM to 5 PM): Double the car rate
                totalFee += (STANDARD_CAR_RATE * 2.0); // Rs 60.0 per hour
                peakHours++;
            } else {
                // Outside peak hours: Standard rate
                totalFee += STANDARD_CAR_RATE; // Rs 30.0 per hour
                normalHours++;
            }
        }

        System.out.println("  [DELIVERY VAN PRICING BREAKDOWN]");
        System.out.println("    Peak Hours (9 AM-5 PM) : " + peakHours + " hr(s) @ Rs 60.0/hr = Rs " + (peakHours * 60.0));
        System.out.println("    Off-Peak Hours         : " + normalHours + " hr(s) @ Rs 30.0/hr = Rs " + (normalHours * 30.0));
        System.out.println("    Total Van Parking Fee  : Rs " + totalFee);

        return totalFee;
    }

    public void displayDetails() {
        System.out.println("  Delivery Van  : " + registrationPlate);
        System.out.println("  Company       : " + deliveryCompany);
        System.out.println("  Pricing Rule  : Double Car Rate (Rs 60/hr) during 9 AM - 5 PM");
    }
}
