// ============================================================================
// Assignment 1 - TASK 4: Classes, Constructors, Overloading & 'this' Keyword
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate class definitions, default constructor, parameterized
//          constructors, constructor overloading, constructor chaining, and 'this'.
// ============================================================================

/**
 * Represents a parking slot with various constructor options.
 */
class SmartSlot {
    // Instance variables (fields) representing the state of each object
    private int slotNumber;
    private int floorNumber;
    private String slotType; // "Standard", "EV-Charging", "Handicapped"
    private boolean isOccupied;

    // ------------------------------------------------------------------------
    // Constructor 1: Default Constructor (No Arguments)
    // Uses 'this(...)' to call Constructor 3 with default values.
    // ------------------------------------------------------------------------
    public SmartSlot() {
        // Constructor chaining: calling another constructor in the same class
        this(101, 1, "Standard");
        System.out.println("[INFO] Default constructor invoked. Assigned default Slot #101 on Floor 1.");
    }

    // ------------------------------------------------------------------------
    // Constructor 2: Overloaded Constructor with 2 parameters (Slot and Floor)
    // Defaults the slotType to "Standard".
    // ------------------------------------------------------------------------
    public SmartSlot(int slotNumber, int floorNumber) {
        // Chaining to 3-parameter constructor
        this(slotNumber, floorNumber, "Standard");
        System.out.println("[INFO] Two-parameter constructor invoked for Slot #" + slotNumber);
    }

    // ------------------------------------------------------------------------
    // Constructor 3: Fully Parameterized Constructor
    // Demonstrates the 'this' keyword to resolve shadowing between
    // instance variables and constructor parameters.
    // ------------------------------------------------------------------------
    public SmartSlot(int slotNumber, int floorNumber, String slotType) {
        // 'this.slotNumber' refers to the instance variable
        // 'slotNumber' refers to the parameter passed in
        this.slotNumber = slotNumber;
        this.floorNumber = floorNumber;
        this.slotType = slotType;
        this.isOccupied = false; // New slots are initially free
        System.out.println("[INFO] Full parameterized constructor invoked for Slot #" + this.slotNumber + " (" + this.slotType + ")");
    }

    // Method to display slot information
    public void displayDetails() {
        System.out.println("  Slot ID      : #" + this.slotNumber);
        System.out.println("  Floor Level  : Floor " + this.floorNumber);
        System.out.println("  Slot Type    : " + this.slotType);
        System.out.println("  Occupied?    : " + (this.isOccupied ? "YES" : "NO"));
        System.out.println("  --------------------------------------");
    }

    // Method to occupy the slot using 'this'
    public void occupy() {
        this.isOccupied = true;
        System.out.println("[UPDATE] Slot #" + this.slotNumber + " has been OCCUPIED.");
    }
}

/**
 * Main Class for Task 04
 */
public class Task4 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  TASK 4: CONSTRUCTORS & 'this' KEYWORD DEMO      ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Instantiating via Default Constructor ---");
        SmartSlot slotDefault = new SmartSlot();
        slotDefault.displayDetails();

        System.out.println("\n--- 2. Instantiating via 2-Parameter Constructor ---");
        SmartSlot slotTwoParam = new SmartSlot(205, 2);
        slotTwoParam.displayDetails();

        System.out.println("\n--- 3. Instantiating via Full 3-Parameter Constructor ---");
        SmartSlot slotEv = new SmartSlot(310, 3, "EV-Charging");
        slotEv.displayDetails();

        System.out.println("\n--- 4. Changing Object State ---");
        slotEv.occupy();
        slotEv.displayDetails();
    }
}
