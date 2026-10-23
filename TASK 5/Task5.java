// ============================================================================
// Assignment 1 - TASK 5: Static Ticket Numbering & Object Life Cycle
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate static counter variables, static vs instance scope,
//          and explain the complete 5-stage life cycle of objects in Java.
// ============================================================================

class SmartTicket {
    // ------------------------------------------------------------------------
    // STATIC VARIABLES (Class-Level Scope)
    // Shared by all instances of SmartTicket. Stored in Metaspace/Class area.
    // ------------------------------------------------------------------------
    private static int ticketSequence = 1000;   // Auto-incrementing counter
    private static int activeTicketCount = 0;   // Current active tickets in lot
    private static double totalCollections = 0; // Total revenue collected across all tickets

    // ------------------------------------------------------------------------
    // INSTANCE VARIABLES (Object-Level Scope)
    // Each object allocated on the Heap has its own separate copy.
    // ------------------------------------------------------------------------
    private int ticketId;
    private String licensePlate;
    private double fee;
    private boolean isPaid;

    // Constructor: Invoked during object initialization
    public SmartTicket(String licensePlate, double fee) {
        // Increment the shared class counter for every new ticket
        ticketSequence++;
        this.ticketId = ticketSequence; // Unique ticket number
        this.licensePlate = licensePlate;
        this.fee = fee;
        this.isPaid = false;

        activeTicketCount++;
        totalCollections += fee;
        System.out.println("[OBJECT LIFE CYCLE: INITIALIZED] SmartTicket #" + this.ticketId + " created for " + licensePlate);
    }

    // Instance method: operates on specific object's data
    public void markPaid() {
        this.isPaid = true;
        if (activeTicketCount > 0) {
            activeTicketCount--;
        }
        System.out.println("[OBJECT LIFE CYCLE: USED] Ticket #" + this.ticketId + " has been paid & closed.");
    }

    public void displayTicket() {
        System.out.println("  Ticket ID     : TKT-" + this.ticketId);
        System.out.println("  Vehicle Plate : " + this.licensePlate);
        System.out.println("  Fee Amount    : Rs " + this.fee);
        System.out.println("  Payment Status: " + (this.isPaid ? "PAID" : "UNPAID"));
        System.out.println("  --------------------------------------");
    }

    // ------------------------------------------------------------------------
    // STATIC METHODS (Class-Level Methods)
    // Can be invoked without creating an instance: SmartTicket.getLastIssuedTicketId()
    // ------------------------------------------------------------------------
    public static int getLastIssuedTicketId() {
        return ticketSequence;
    }

    public static int getActiveTicketCount() {
        return activeTicketCount;
    }

    public static double getTotalCollections() {
        return totalCollections;
    }
}

public class Task5 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  TASK 5: STATIC MEMBERS & OBJECT LIFE CYCLE      ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Initial Static State ---");
        System.out.println("Starting Ticket Sequence : " + SmartTicket.getLastIssuedTicketId());
        System.out.println("Active Tickets in Lot    : " + SmartTicket.getActiveTicketCount());
        System.out.println("Total Collections        : Rs " + SmartTicket.getTotalCollections() + "\n");

        // --------------------------------------------------------------------
        // OBJECT LIFE CYCLE STAGE 1: Declaration
        // Allocates reference variable 't1' on the Call Stack. No Heap memory yet.
        // --------------------------------------------------------------------
        System.out.println("--- 2. Object Lifecycle Stages ---");
        SmartTicket t1; // Declaration

        // --------------------------------------------------------------------
        // OBJECT LIFE CYCLE STAGE 2 & 3: Instantiation & Initialization
        // 'new' allocates memory on Heap, constructor initializes fields.
        // --------------------------------------------------------------------
        t1 = new SmartTicket("TN01AA1111", 50.0);
        SmartTicket t2 = new SmartTicket("TN02BB2222", 80.0);
        SmartTicket t3 = new SmartTicket("TN03CC3333", 40.0);

        System.out.println("\n--- 3. Static State After Creating 3 Objects ---");
        System.out.println("Last Issued Ticket ID : " + SmartTicket.getLastIssuedTicketId());
        System.out.println("Active Tickets Count  : " + SmartTicket.getActiveTicketCount());
        System.out.println("Total Collections     : Rs " + SmartTicket.getTotalCollections());

        // --------------------------------------------------------------------
        // OBJECT LIFE CYCLE STAGE 4: Usage
        // Calling methods, reading values, performing business operations.
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Object Usage ---");
        t1.displayTicket();
        t2.displayTicket();
        t3.displayTicket();

        t1.markPaid();
        System.out.println("Active Tickets Remaining: " + SmartTicket.getActiveTicketCount());

        // --------------------------------------------------------------------
        // OBJECT LIFE CYCLE STAGE 5: Dereferencing & Garbage Collection Eligibility
        // When a reference is set to null, the Heap object becomes unreachable.
        // The Java Garbage Collector (GC) can reclaim that memory.
        // --------------------------------------------------------------------
        System.out.println("\n--- 5. Dereferencing & Garbage Collection ---");
        System.out.println("Dereferencing object t3 by setting t3 = null...");
        t3 = null; // Object is now eligible for Garbage Collection
        System.out.println("t3 reference is now null. Heap memory can be reclaimed by JVM Garbage Collector.");
    }
}
