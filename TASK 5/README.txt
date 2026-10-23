================================================================================
CSA09 Assignment 1 - TASK 5: Static Ticket Numbering & Object Life Cycle Concepts
================================================================================

1. TASK OBJECTIVE:
To demonstrate static members (static variables and static methods), differentiate 
between class-level scope (Metaspace) and instance-level scope (Heap), and walk 
through the 5 distinct stages of the Java Object Life Cycle.

2. CONCEPTS DEMONSTRATED:
- Static Members (Class Scope):
  * `static int ticketSequence = 1000`: Shared by all SmartTicket objects. Increments 
    automatically so each ticket receives a guaranteed unique sequential number.
  * `static int activeTicketCount`: Tracks currently active tickets in the facility.
  * `static double totalCollections`: Tracks running sum of revenue.
  * Static methods: `getLastIssuedTicketId()`, `getActiveTicketCount()`, `getTotalCollections()` 
    invoked directly on the class `SmartTicket.` without needing an object instance.
- The 5 Stages of the Java Object Life Cycle:
  1. Declaration: Reference variable declared on Stack (`SmartTicket t1;`).
  2. Instantiation: JVM keyword `new` allocates memory block on the Heap.
  3. Initialization: Constructor executes, initializes fields, increments static counter.
  4. Usage: Object methods invoked (`t1.displayTicket()`, `t1.markPaid()`).
  5. Dereferencing & GC: Setting `t3 = null` makes Heap object unreachable; JVM 
     Garbage Collector (GC) reclaims memory during its sweep.

3. ALGORITHM / WORKFLOW:
Step 1: Check and display initial static states before any object is created.
Step 2: Declare reference variable `t1` (Stage 1).
Step 3: Instantiate and initialize 3 distinct SmartTicket objects: t1, t2, t3 (Stages 2 & 3).
Step 4: Verify static sequence has auto-incremented from 1000 to 1003.
Step 5: Invoke display methods and mark ticket t1 as paid (Stage 4).
Step 6: Update active ticket count from 3 down to 2.
Step 7: Nullify reference `t3 = null` to demonstrate GC eligibility (Stage 5).
Step 8: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 5"
   javac Task5.java
   java Task5
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
  TASK 5: STATIC MEMBERS & OBJECT LIFE CYCLE      
==================================================

--- 1. Initial Static State ---
Starting Ticket Sequence : 1000
Active Tickets in Lot    : 0
Total Collections        : Rs 0.0

--- 2. Object Lifecycle Stages ---
[OBJECT LIFE CYCLE: INITIALIZED] SmartTicket #1001 created for TN01AA1111
[OBJECT LIFE CYCLE: INITIALIZED] SmartTicket #1002 created for TN02BB2222
[OBJECT LIFE CYCLE: INITIALIZED] SmartTicket #1003 created for TN03CC3333

--- 3. Static State After Creating 3 Objects ---
Last Issued Ticket ID : 1003
Active Tickets Count  : 3
Total Collections     : Rs 170.0

--- 4. Object Usage ---
  Ticket ID     : TKT-1001
  Vehicle Plate : TN01AA1111
  Fee Amount    : Rs 50.0
  Payment Status: UNPAID
  --------------------------------------
  Ticket ID     : TKT-1002
  Vehicle Plate : TN02BB2222
  Fee Amount    : Rs 80.0
  Payment Status: UNPAID
  --------------------------------------
  Ticket ID     : TKT-1003
  Vehicle Plate : TN03CC3333
  Fee Amount    : Rs 40.0
  Payment Status: UNPAID
  --------------------------------------
[OBJECT LIFE CYCLE: USED] Ticket #1001 has been paid & closed.
Active Tickets Remaining: 2

--- 5. Dereferencing & Garbage Collection ---
Dereferencing object t3 by setting t3 = null...
t3 reference is now null. Heap memory can be reclaimed by JVM Garbage Collector.

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 5"`, `javac Task5.java`, and `java Task5`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 5 section in your report document.
