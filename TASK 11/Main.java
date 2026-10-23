// ============================================================================
// Assignment 1 - TASK 11: End-to-End Campus Smart-Parking System
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Implement complete end-to-end parking workflow:
//          - Vehicle entry & slot allocation
//          - Ticket generation & duplicate registration prevention
//          - Vehicle exit, slot release, fee computation & invalid slot handling
//          - Daily revenue collection accounting
// ============================================================================

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a parked vehicle entity.
 */
class CampusVehicle {
    private String registrationNumber;
    private String vehicleType; // "TwoWheeler", "Car"

    public CampusVehicle(String registrationNumber, String vehicleType) {
        this.registrationNumber = registrationNumber.trim().toUpperCase();
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CampusVehicle other = (CampusVehicle) obj;
        return this.registrationNumber.equalsIgnoreCase(other.registrationNumber);
    }

    @Override
    public int hashCode() {
        return registrationNumber.toUpperCase().hashCode();
    }
}

/**
 * Represents an issued parking ticket.
 */
class ActiveTicket {
    private int ticketId;
    private CampusVehicle vehicle;
    private int row;
    private int col;
    private int entryHour; // 24-hr format (e.g. 9 for 9:00 AM)
    private boolean isActive;

    public ActiveTicket(int ticketId, CampusVehicle vehicle, int row, int col, int entryHour) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.row = row;
        this.col = col;
        this.entryHour = entryHour;
        this.isActive = true;
    }

    public int getTicketId() { return ticketId; }
    public CampusVehicle getVehicle() { return vehicle; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getEntryHour() { return entryHour; }
    public boolean isActive() { return isActive; }
    public void markCompleted() { this.isActive = false; }
}

/**
 * Core Parking Management System
 */
class CampusParkingSystem {
    private int rows;
    private int cols;
    private CampusVehicle[][] slotGrid; // null means empty, non-null contains vehicle
    private List<ActiveTicket> ticketHistory;
    private static int ticketCounter = 1000;
    private double totalDailyRevenue;

    public CampusParkingSystem(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.slotGrid = new CampusVehicle[rows][cols];
        this.ticketHistory = new ArrayList<>();
        this.totalDailyRevenue = 0.0;
    }

    /**
     * Requirement: Vehicle Entry, Duplicate Registration Check & Slot Allocation
     */
    public ActiveTicket processVehicleEntry(String regNo, String type, int entryHour) {
        System.out.println("\n[ENTRY REQUEST] Vehicle: " + regNo + " (" + type + ")");

        // Step 1: Duplicate Registration Check
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (slotGrid[r][c] != null && slotGrid[r][c].getRegistrationNumber().equalsIgnoreCase(regNo)) {
                    System.out.println("  [ERROR: DUPLICATE ENTRY] Vehicle " + regNo + 
                                       " is ALREADY parked in slot [" + r + ", " + c + "]! Entry denied.");
                    return null;
                }
            }
        }

        // Step 2: Find First Available Parking Slot
        int allocatedRow = -1;
        int allocatedCol = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (slotGrid[r][c] == null) {
                    allocatedRow = r;
                    allocatedCol = c;
                    break;
                }
            }
            if (allocatedRow != -1) break;
        }

        // Check if facility is completely full
        if (allocatedRow == -1) {
            System.out.println("  [FACILITY FULL] No slots available in the parking lot. Entry denied.");
            return null;
        }

        // Step 3: Park the vehicle
        CampusVehicle newVehicle = new CampusVehicle(regNo, type);
        slotGrid[allocatedRow][allocatedCol] = newVehicle;

        // Step 4: Issue Ticket
        ticketCounter++;
        ActiveTicket ticket = new ActiveTicket(ticketCounter, newVehicle, allocatedRow, allocatedCol, entryHour);
        ticketHistory.add(ticket);

        System.out.println("  [SUCCESS] Slot allocated: [" + allocatedRow + ", " + allocatedCol + "]");
        System.out.println("  [TICKET ISSUED] Ticket #" + ticket.getTicketId() + " at " + entryHour + ":00 hrs");
        return ticket;
    }

    /**
     * Requirement: Vehicle Exit, Fee Calculation, Slot Release & Invalid Slot Handling
     */
    public boolean processVehicleExitBySlot(int row, int col, int exitHour) {
        System.out.println("\n[EXIT REQUEST] Attempting exit for Slot: [" + row + ", " + col + "]");

        // Requirement: Invalid Slot Boundary Handling
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("  [ERROR: INVALID SLOT] Coordinates [" + row + ", " + col + "] are out of bounds!");
            return false;
        }

        // Requirement: Invalid Slot Occupancy Handling
        if (slotGrid[row][col] == null) {
            System.out.println("  [ERROR: SLOT VACANT] Slot [" + row + ", " + col + "] has no parked vehicle!");
            return false;
        }

        // Retrieve vehicle and associated active ticket
        CampusVehicle v = slotGrid[row][col];
        ActiveTicket activeTicket = null;
        for (ActiveTicket t : ticketHistory) {
            if (t.isActive() && t.getRow() == row && t.getCol() == col) {
                activeTicket = t;
                break;
            }
        }

        int durationHours = (activeTicket != null) ? Math.max(1, exitHour - activeTicket.getEntryHour()) : 2;

        // Requirement: Parking Fee Calculation (TwoWheeler Rs 10/hr, Car Rs 30/hr)
        double ratePerHour = v.getVehicleType().equalsIgnoreCase("TwoWheeler") ? 10.0 : 30.0;
        double totalFee = durationHours * ratePerHour;
        totalDailyRevenue += totalFee;

        // Requirement: Slot Release
        slotGrid[row][col] = null; // Free the slot
        if (activeTicket != null) {
            activeTicket.markCompleted();
        }

        System.out.println("  [EXIT SUCCESS] Vehicle " + v.getRegistrationNumber() + " cleared from slot [" + row + ", " + col + "]");
        System.out.println("  Duration: " + durationHours + " hour(s) | Rate: Rs " + ratePerHour + "/hr");
        System.out.println("  Total Parking Fee Paid: Rs " + totalFee);
        return true;
    }

    /**
     * Requirement: Daily Collection Audit Report
     */
    public void displayDailyCollectionReport() {
        System.out.println("\n==========================================");
        System.out.println("     DAILY PARKING COLLECTION REPORT      ");
        System.out.println("==========================================");
        int occupied = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (slotGrid[r][c] != null) occupied++;
            }
        }
        int totalSlots = rows * cols;
        System.out.println("Total Facility Capacity : " + totalSlots + " slots");
        System.out.println("Currently Occupied      : " + occupied + " slots");
        System.out.println("Currently Vacant        : " + (totalSlots - occupied) + " slots");
        System.out.println("Total Tickets Processed : " + ticketHistory.size());
        System.out.println("Total Daily Collections : Rs " + totalDailyRevenue);
        System.out.println("==========================================\n");
    }

    public void printCurrentLotStatus() {
        System.out.println("\n--- Current Parking Grid Status ---");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (slotGrid[r][c] == null) {
                    System.out.print("[ Empty ] ");
                } else {
                    System.out.print("[" + slotGrid[r][c].getRegistrationNumber() + "] ");
                }
            }
            System.out.println();
        }
    }
}

/**
 * Main Class for Task 11
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    TASK 11: CAMPUS SMART-PARKING SYSTEM          ");
        System.out.println("==================================================");

        // Create a parking lot with 2 rows and 2 columns (Total 4 slots)
        CampusParkingSystem parkingSystem = new CampusParkingSystem(2, 2);

        // 1. Successful Vehicle Entries & Ticket Generation
        ActiveTicket t1 = parkingSystem.processVehicleEntry("TN01AA1111", "Car", 9);       // Entry at 9 AM -> [0, 0]
        ActiveTicket t2 = parkingSystem.processVehicleEntry("TN02BB2222", "TwoWheeler", 10); // Entry at 10 AM -> [0, 1]
        ActiveTicket t3 = parkingSystem.processVehicleEntry("TN03CC3333", "Car", 10);       // Entry at 10 AM -> [1, 0]

        // 2. Duplicate Registration Checking Demo
        parkingSystem.processVehicleEntry("TN01AA1111", "Car", 11); // Already parked! Must be rejected.

        // 3. Fill the remaining slot
        ActiveTicket t4 = parkingSystem.processVehicleEntry("TN04DD4444", "TwoWheeler", 11); // -> [1, 1]

        // 4. Attempt Entry when lot is completely full
        parkingSystem.processVehicleEntry("TN05EE5555", "Car", 12); // Facility full! Must be rejected.

        // Show grid
        parkingSystem.printCurrentLotStatus();

        // 5. Test Invalid Slot Handling
        parkingSystem.processVehicleExitBySlot(9, 9, 13); // Out of bounds coordinates
        parkingSystem.processVehicleExitBySlot(0, 0, 12); // Valid exit: Slot [0, 0] (parked 9 AM to 12 PM = 3 hrs)
        parkingSystem.processVehicleExitBySlot(0, 0, 13); // Already vacated slot!

        // 6. Another vehicle exits
        parkingSystem.processVehicleExitBySlot(0, 1, 12); // Slot [0, 1] (parked 10 AM to 12 PM = 2 hrs)

        // Show updated grid
        parkingSystem.printCurrentLotStatus();

        // 7. Re-allocating the newly freed slot [0, 0]
        parkingSystem.processVehicleEntry("TN06FF6666", "Car", 13); // Gets allocated [0, 0]

        // 8. Display Daily Collection Report
        parkingSystem.displayDailyCollectionReport();
    }
}
