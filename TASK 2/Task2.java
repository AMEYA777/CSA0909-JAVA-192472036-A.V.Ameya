// Assignment 1 - TASK 2: Java Data Types, Arrays & Parking-Slot Representation
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate Java primitive types, 1D arrays, and 2D arrays to model a campus parking layout.

public class Task2 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  TASK 2: DATA TYPES, ARRAYS & PARKING GRID DEMO  ");
        System.out.println("==================================================");

        // -------------------------------------------------------------
        // 1. Primitive Data Types Demonstration
        // -------------------------------------------------------------
        System.out.println("--- 1. Primitive Data Types in Parking System ---");
        int totalCapacity = 12;                 // Integer: Total physical capacity
        int floorNumber = 1;                    // Integer: Specific floor level
        int slotNumber = 5;                     // Integer: Slot number
        double parkingFee = 60.0;               // Floating point: Base hourly fee in INR
        char vehicleCategory = 'C';             // Character: 'C' = Car, 'B' = Bike
        boolean isCampusOpen = true;            // Boolean: Gate open or closed
        long entryTimestamp = 1718000000000L;   // Long: Milliseconds timestamp
        String vehicleNumber = "TN01AB1234";    // Reference type: String

        System.out.println("Floor Number            : " + floorNumber);
        System.out.println("Slot Number             : " + slotNumber);
        System.out.println("Vehicle Number          : " + vehicleNumber);
        System.out.println("Parking Fee per Hour    : Rs " + parkingFee + " (double)");
        System.out.println("Total Facility Capacity : " + totalCapacity + " slots (int)");
        System.out.println("Vehicle Category Code   : '" + vehicleCategory + "' (char)");
        System.out.println("Campus Facility Open?   : " + isCampusOpen + " (boolean)");
        System.out.println("Gate Entry Timestamp    : " + entryTimestamp + " ms (long)\n");

        // -------------------------------------------------------------
        // 2. Reference Types: 1D Array Demonstration
        // -------------------------------------------------------------
        System.out.println("--- 2. Reference Types: 1D Array of Slot Numbers ---");
        String facilityName = "Main Campus North Lot";
        int[] slotIdentifiers = {101, 102, 103, 104};

        System.out.println("Facility Name: " + facilityName);
        System.out.print("Quick Access Slots: ");
        for (int i = 0; i < slotIdentifiers.length; i++) {
            System.out.print("#" + slotIdentifiers[i] + (i < slotIdentifiers.length - 1 ? ", " : "\n\n"));
        }

        // -------------------------------------------------------------
        // 3. 2D Array: Representing a Parking Grid (Rows x Cols)
        // -------------------------------------------------------------
        System.out.println("--- 3. 2D Array Representation of Parking Grid ---");
        int rows = 3;
        int cols = 4;
        String[][] parkingSlots = new String[rows][cols];

        // Park vehicles in specific grid locations (null means vacant)
        parkingSlots[0][0] = "TN02CD5678";
        parkingSlots[0][1] = "TN03EF9012";
        parkingSlots[1][2] = "TN01AB1234";
        parkingSlots[2][0] = "TN07GH3456";
        parkingSlots[2][3] = "TN09KL7890";

        // Display individual sample slots
        System.out.println("Sample Slot [0][0]: " + parkingSlots[0][0]);
        System.out.println("Sample Slot [0][1]: " + parkingSlots[0][1]);
        System.out.println("Sample Slot [0][2]: " + (parkingSlots[0][2] == null ? "EMPTY" : parkingSlots[0][2]) + "\n");

        // Display the complete 2D parking matrix
        displayParkingGrid(parkingSlots);

        // -------------------------------------------------------------
        // 4. Calculating Availability Metrics
        // -------------------------------------------------------------
        int occupiedCount = 0;
        int vacantCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (parkingSlots[r][c] != null) {
                    occupiedCount++;
                } else {
                    vacantCount++;
                }
            }
        }

        int totalSlots = rows * cols;
        double occupancyRate = ((double) occupiedCount / totalSlots) * 100.0;

        System.out.println("\n--- Parking Summary Metrics ---");
        System.out.println("Total Grid Slots : " + totalSlots);
        System.out.println("Occupied Slots   : " + occupiedCount);
        System.out.println("Available Slots  : " + vacantCount);
        System.out.printf("Occupancy Rate   : %.2f%%\n", occupancyRate);
    }

    // Helper method to display 2D parking grid visually
    public static void displayParkingGrid(String[][] grid) {
        System.out.println("Parking Layout (Row x Col):");
        System.out.print("       ");
        for (int c = 0; c < grid[0].length; c++) {
            System.out.print("Col " + c + "       ");
        }
        System.out.println();

        for (int r = 0; r < grid.length; r++) {
            System.out.print("Row " + r + ": ");
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] != null) {
                    System.out.print("[ " + grid[r][c] + " ] ");
                } else {
                    System.out.print("[   EMPTY    ] ");
                }
            }
            System.out.println();
        }
    }
}
