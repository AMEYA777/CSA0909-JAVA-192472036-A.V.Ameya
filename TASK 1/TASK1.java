// Assignment 1 - TASK 1: Problem Definition & Candidate Classes
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Model the campus smart-parking domain using candidate classes: Vehicle, ParkingSlot, and ParkingTicket.

class Vehicle {
    String vehicleNo;
    String vehicleType; // e.g. "Car", "Two-Wheeler"
    String ownerName;   // e.g. "Dr. A. Kumar (Faculty)", "Sneha Rao (Student)"

    // Constructor to initialize vehicle properties
    Vehicle(String vehicleNo, String vehicleType, String ownerName) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    // Display vehicle information
    void display() {
        System.out.println("  Vehicle Number : " + vehicleNo);
        System.out.println("  Vehicle Type   : " + vehicleType);
        System.out.println("  Owner / Driver : " + ownerName);
    }
}

class ParkingSlot {
    int slotNumber;        // Unique identifier for the slot
    String slotType;       // "Car" or "Two-Wheeler"
    boolean isOccupied;    // false = vacant, true = occupied
    Vehicle parkedVehicle; // Reference to currently parked vehicle

    ParkingSlot(int slotNumber, String slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.isOccupied = false; // Initially vacant
        this.parkedVehicle = null;
    }

    void park(Vehicle v) {
        this.parkedVehicle = v;
        this.isOccupied = true;
        System.out.println("[SUCCESS] Vehicle " + v.vehicleNo + " parked in Slot #" + slotNumber);
    }

    void display() {
        System.out.println("Slot #" + slotNumber + " [" + slotType + "] -> Status: " + (isOccupied ? "OCCUPIED" : "VACANT"));
        if (isOccupied && parkedVehicle != null) {
            System.out.println("  Occupied by: " + parkedVehicle.vehicleNo + " (" + parkedVehicle.ownerName + ")");
        }
    }
}

class ParkingTicket {
    int ticketId;
    String vehicleNo;
    int slotNumber;
    String entryTime;

    ParkingTicket(int ticketId, String vehicleNo, int slotNumber, String entryTime) {
        this.ticketId = ticketId;
        this.vehicleNo = vehicleNo;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
    }

    void printTicket() {
        System.out.println("------------------------------------------");
        System.out.println("        CAMPUS SMART PARKING TICKET       ");
        System.out.println("------------------------------------------");
        System.out.println("Ticket ID    : TKT-" + ticketId);
        System.out.println("Vehicle No   : " + vehicleNo);
        System.out.println("Slot Number  : #" + slotNumber);
        System.out.println("Entry Time   : " + entryTime);
        System.out.println("------------------------------------------");
    }
}

public class TASK1 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    CAMPUS SMART-PARKING SYSTEM: TASK 1 DEMO      ");
        System.out.println("==================================================");
        System.out.println("PROBLEM STATEMENT:");
        System.out.println("Traditional campus parking suffers from congestion,");
        System.out.println("lack of real-time slot visibility, and unauthorized");
        System.out.println("parking. Object-Oriented modeling solves this by");
        System.out.println("representing vehicles, slots, and tickets as objects.\n");

        System.out.println("--- 1. Creating Candidate Objects ---");
        Vehicle v1 = new Vehicle("TN01AB1234", "Car", "Dr. A. Kumar (Faculty)");
        Vehicle v2 = new Vehicle("TN02CD5678", "Two-Wheeler", "Sneha Rao (Student)");

        System.out.println("Vehicle 1 Details:");
        v1.display();
        System.out.println("\nVehicle 2 Details:");
        v2.display();

        System.out.println("\n--- 2. Creating Parking Slots ---");
        ParkingSlot slot101 = new ParkingSlot(101, "Car");
        ParkingSlot slot102 = new ParkingSlot(102, "Two-Wheeler");

        slot101.display();
        slot102.display();

        System.out.println("\n--- 3. Simulating Parking ---");
        slot101.park(v1);
        slot102.park(v2);

        System.out.println("\n--- Updated Slot Statuses ---");
        slot101.display();
        slot102.display();

        System.out.println("\n--- 4. Issuing Parking Tickets ---");
        ParkingTicket ticket1 = new ParkingTicket(5001, v1.vehicleNo, slot101.slotNumber, "09:15 AM");
        ticket1.printTicket();
    }
}
