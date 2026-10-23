// ============================================================================
// Assignment 1 - TASK 12: Advanced Multi-Floor Campus Smart-Parking System
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Implement:
//          1. Five floors with different slot capacities using a JAGGED ARRAY.
//          2. E-Bikes with a flat parking fee.
//          3. Delivery vans charged double the car rate during 9 AM - 5 PM.
//          4. One-Day Passes for campus visitors.
//          5. Flexible PricingRule design pattern.
// ============================================================================

import java.util.ArrayList;
import java.util.List;

public class Main {

    // ------------------------------------------------------------------------
    // Concrete Implementations of the Flexible PricingRule Strategy Interface
    // ------------------------------------------------------------------------

    // Standard Car Pricing Rule: Rs 30.0 / hr
    static class StandardCarPricingRule implements PricingRule {
        @Override
        public double calculateFee(int entryHour, int exitHour, double baseRate) {
            int duration = Math.max(1, exitHour - entryHour);
            return duration * baseRate;
        }

        @Override
        public String getRuleDescription() {
            return "Standard Hourly Rule (Duration * Hourly Rate)";
        }
    }

    // E-Bike Flat Pricing Rule: Flat Rs 20.0
    static class EBikeFlatPricingRule implements PricingRule {
        private final double flatFee;

        public EBikeFlatPricingRule(double flatFee) {
            this.flatFee = flatFee;
        }

        @Override
        public double calculateFee(int entryHour, int exitHour, double baseRate) {
            return flatFee;
        }

        @Override
        public String getRuleDescription() {
            return "Subsidized Green Mobility Flat Fee (Rs " + flatFee + " all day)";
        }
    }

    // Delivery Van Peak-Hour Rule: Double car rate (Rs 60/hr) during 9 AM - 5 PM
    static class DeliveryVanPeakPricingRule implements PricingRule {
        @Override
        public double calculateFee(int entryHour, int exitHour, double baseRate) {
            if (exitHour <= entryHour) exitHour = entryHour + 1;
            double total = 0.0;
            for (int h = entryHour; h < exitHour; h++) {
                if (h >= 9 && h < 17) {
                    total += (baseRate * 2.0); // 2x rate during peak 9 AM - 5 PM
                } else {
                    total += baseRate;
                }
            }
            return total;
        }

        @Override
        public String getRuleDescription() {
            return "Commercial Delivery Rule: 2x rate during 9 AM - 5 PM, 1x off-peak";
        }
    }

    // ------------------------------------------------------------------------
    // Multi-Floor Parking Facility with JAGGED ARRAY
    // ------------------------------------------------------------------------
    static class MultiFloorParkingFacility {
        // Jagged array: each floor (row) has a different number of slots (columns)
        private String[][] floors;
        private double totalRevenue;
        private List<String> transactionLogs;

        public MultiFloorParkingFacility() {
            // Initializing 5 floors with differing capacities:
            // Floor 0 (Ground Floor) : 10 slots
            // Floor 1 (First Floor)  : 8 slots
            // Floor 2 (Second Floor) : 6 slots
            // Floor 3 (Third Floor)  : 5 slots
            // Floor 4 (Rooftop)      : 4 slots
            this.floors = new String[5][];
            this.floors[0] = new String[10];
            this.floors[1] = new String[8];
            this.floors[2] = new String[6];
            this.floors[3] = new String[5];
            this.floors[4] = new String[4];

            this.totalRevenue = 0.0;
            this.transactionLogs = new ArrayList<>();
        }

        /**
         * Allocates the lowest available floor and slot.
         * 
         * @return int[] of size 2 containing [floorIndex, slotIndex], or null if full
         */
        public int[] allocateSlot(String vehicleId) {
            for (int f = 0; f < floors.length; f++) {
                for (int s = 0; s < floors[f].length; s++) {
                    if (floors[f][s] == null) {
                        floors[f][s] = vehicleId;
                        return new int[] { f, s };
                    }
                }
            }
            return null; // Full
        }

        /**
         * Releases slot at given floor and index.
         */
        public boolean releaseSlot(int floor, int slot) {
            if (floor < 0 || floor >= floors.length || slot < 0 || slot >= floors[floor].length) {
                return false;
            }
            if (floors[floor][slot] != null) {
                floors[floor][slot] = null;
                return true;
            }
            return false;
        }

        public void addRevenue(double amount, String log) {
            this.totalRevenue += amount;
            this.transactionLogs.add(log);
        }

        public void displayJaggedArrayFloorStatus() {
            System.out.println("\n--------------------------------------------------");
            System.out.println("  5-FLOOR JAGGED ARRAY FACILITY OCCUPANCY MAP     ");
            System.out.println("--------------------------------------------------");
            int totalCapacity = 0;
            int totalOccupied = 0;

            for (int f = 0; f < floors.length; f++) {
                int capacity = floors[f].length;
                totalCapacity += capacity;
                int occ = 0;
                System.out.printf("Floor %d (%2d slots max): ", f, capacity);
                for (int s = 0; s < floors[f].length; s++) {
                    if (floors[f][s] == null) {
                        System.out.print("[ . ] ");
                    } else {
                        System.out.print("[ " + floors[f][s] + " ] ");
                        occ++;
                        totalOccupied++;
                    }
                }
                System.out.printf(" -> (%d/%d occupied)\n", occ, capacity);
            }
            System.out.println("Total Facility Capacity : " + totalCapacity + " slots");
            System.out.println("Total Currently Parked  : " + totalOccupied + " slots");
            System.out.println("Available Slots         : " + (totalCapacity - totalOccupied) + " slots");
            System.out.println("--------------------------------------------------\n");
        }

        public void displayFinancialReport() {
            System.out.println("\n==========================================");
            System.out.println("   TASK 12: DAILY REVENUE AUDIT REPORT    ");
            System.out.println("==========================================");
            for (String log : transactionLogs) {
                System.out.println("  * " + log);
            }
            System.out.println("------------------------------------------");
            System.out.println("TOTAL REVENUE COLLECTED : Rs " + totalRevenue);
            System.out.println("==========================================\n");
        }
    }

    // ------------------------------------------------------------------------
    // Main Method: Comprehensive Test & Execution of Task 12 Requirements
    // ------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" TASK 12: EXTENDED MULTI-FLOOR SMART PARKING      ");
        System.out.println("==================================================\n");

        MultiFloorParkingFacility facility = new MultiFloorParkingFacility();

        // Instantiate Pricing Rules
        PricingRule carRule = new StandardCarPricingRule();
        PricingRule ebikeRule = new EBikeFlatPricingRule(20.0);
        PricingRule vanRule = new DeliveryVanPeakPricingRule();

        System.out.println("--- 1. Testing Jagged Array Initial State ---");
        facility.displayJaggedArrayFloorStatus();

        // --------------------------------------------------------------------
        // Feature 1 & 2: E-Bike with Flat Parking Fee
        // --------------------------------------------------------------------
        System.out.println("--- 2. Simulating E-Bike Parking (Flat Fee Feature) ---");
        E_Bike ebike = new E_Bike("EB-901", "Kavya (Student)");
        ebike.displayDetails();
        int[] ebikeSlot = facility.allocateSlot(ebike.getSerialNumber());
        System.out.println("[PARKED] E-Bike allocated Floor " + ebikeSlot[0] + ", Slot #" + ebikeSlot[1]);

        // E-Bike exits after 7 hours (from 9 AM to 16 PM)
        int ebikeEntry = 9;
        int ebikeExit = 16;
        double ebikeFee = ebikeRule.calculateFee(ebikeEntry, ebikeExit, 10.0); // Uses flat rule
        facility.releaseSlot(ebikeSlot[0], ebikeSlot[1]);
        facility.addRevenue(ebikeFee, "E-Bike " + ebike.getSerialNumber() + " (Parked 7 hrs) -> Flat Fee: Rs " + ebikeFee);
        System.out.println("[EXITED] E-Bike checked out. Hours parked: " + (ebikeExit - ebikeEntry) + 
                           " hrs | Flat Fee charged: Rs " + ebikeFee + "\n");

        // --------------------------------------------------------------------
        // Feature 3: Delivery Van Charged Double Car Rate During 9 AM - 5 PM
        // --------------------------------------------------------------------
        System.out.println("--- 3. Simulating Delivery Van (Peak Hours 9 AM - 5 PM Double Rate) ---");
        DeliveryVan van = new DeliveryVan("DL01COMM12", "Express Logistics");
        van.displayDetails();
        int[] vanSlot = facility.allocateSlot(van.getRegistrationPlate());
        System.out.println("[PARKED] Delivery Van allocated Floor " + vanSlot[0] + ", Slot #" + vanSlot[1]);

        // Van parks from 10 AM to 14 PM (4 hours during peak window 9-17)
        // Expected fee: 4 hours * (30.0 * 2) = 4 * 60 = Rs 240.0
        int vanEntry = 10;
        int vanExit = 14;
        double vanFee = van.calculateFee(vanEntry, vanExit);
        facility.releaseSlot(vanSlot[0], vanSlot[1]);
        facility.addRevenue(vanFee, "Delivery Van " + van.getRegistrationPlate() + " (10 AM to 2 PM, 4 peak hrs) -> Rs " + vanFee);
        System.out.println("[EXITED] Delivery Van cleared from slot.\n");

        // --------------------------------------------------------------------
        // Feature 4: One-Day Pass for Campus Visitors
        // --------------------------------------------------------------------
        System.out.println("--- 4. Simulating Visitor One-Day Pass ---");
        OneDayPass visitorPass = new OneDayPass("PASS-2024-001", "Dr. Vikram Seth", "DL03VIP007", "Guest Speaker Convocation");
        visitorPass.displayPass();
        int[] visitorSlot = facility.allocateSlot(visitorPass.getVehiclePlate());
        System.out.println("[PARKED] Visitor Car allocated Floor " + visitorSlot[0] + ", Slot #" + visitorSlot[1]);

        // Visitor car leaves at 18:00 (6 PM) - No exit fee because one-day pass was purchased upfront
        double passCost = visitorPass.getPassCost();
        facility.releaseSlot(visitorSlot[0], visitorSlot[1]);
        facility.addRevenue(passCost, "Visitor Pass " + visitorPass.getPassId() + " (" + visitorPass.getVehiclePlate() + ") -> Rs " + passCost);
        System.out.println("[EXITED] Visitor used One-Day Pass. Exit barrier opened with zero exit balance.\n");

        // --------------------------------------------------------------------
        // Feature 5: Multi-Floor Capacity Demonstration with Standard Cars
        // --------------------------------------------------------------------
        System.out.println("--- 5. Populating Slots Across Multiple Floors to Demonstrate Jagged Capacities ---");
        for (int i = 1; i <= 15; i++) {
            String carPlate = "CAR-" + (100 + i);
            int[] slot = facility.allocateSlot(carPlate);
            if (slot != null && (i == 1 || i == 11 || i == 15)) {
                System.out.println("Allocated " + carPlate + " -> Floor " + slot[0] + ", Slot #" + slot[1]);
            }
        }

        // Display the occupancy map showing distribution across jagged rows
        facility.displayJaggedArrayFloorStatus();

        // Print final financial report
        facility.displayFinancialReport();
    }
}
