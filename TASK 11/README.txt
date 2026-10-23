================================================================================
CSA09 Assignment 1 - TASK 11: End-to-End Campus Smart-Parking System
================================================================================

1. TASK OBJECTIVE:
To integrate the preceding individual modules into a comprehensive, end-to-end 
console application managing the complete campus parking lifecycle:
- Vehicle check-in and automated first-available slot assignment
- Auto-incrementing ticket issuance
- Duplicate plate number prevention
- Capacity exhaustion handling (lot full)
- Defensive exit validation (out-of-bounds slot coordinates and already-vacant slots)
- Accurate duration-based fee billing (TwoWheeler Rs 10/hr, Car Rs 30/hr)
- Slot deallocation and immediate re-allocation to incoming vehicles
- Comprehensive end-of-day revenue audit reporting

2. CONCEPTS DEMONSTRATED:
- 2D Object Array: `CampusVehicle[][] slotGrid` represents physical parking spots.
- Collections: `List<ActiveTicket>` maintains active and completed ticket history.
- Linear Search: Automated slot finding and duplicate registration checks.
- Robust Boundary Checks: Defensive guard against illegal coordinates (e.g., [9, 9]).
- Daily Revenue Accounting: Running sum of all collected fees with audit metrics.

3. ALGORITHM / WORKFLOW:
Step 1: Initialize CampusParkingSystem with 2 rows and 2 columns (4 slots).
Step 2: Process valid entries for TN01AA1111 (Car), TN02BB2222 (TwoWheeler), TN03CC3333 (Car).
Step 3: Test duplicate entry attempt for TN01AA1111 -> System detects active car and denies entry.
Step 4: Fill slot [1, 1] with vehicle TN04DD4444.
Step 5: Attempt entry for TN05EE5555 -> Lot capacity is exhausted; system denies entry.
Step 6: Display visual lot matrix showing all 4 occupied slots.
Step 7: Test exit at coordinate [9, 9] -> System catches out-of-bounds error and aborts safely.
Step 8: Process exit for slot [0, 0] (3 hours @ Rs 30/hr = Rs 90.0). Frees slot [0, 0].
Step 9: Test duplicate exit on newly vacated slot [0, 0] -> System catches vacant slot error.
Step 10: Process exit for slot [0, 1] (2 hours @ Rs 10/hr = Rs 20.0). Frees slot [0, 1].
Step 11: Display updated occupancy grid.
Step 12: Process entry for new vehicle TN06FF6666 -> System re-allocates newly freed slot [0, 0].
Step 13: Display the final daily collection audit report with total revenue (Rs 110.0).
Step 14: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 11"
   javac Main.java
   java Main
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
    TASK 11: CAMPUS SMART-PARKING SYSTEM          
==================================================

[ENTRY REQUEST] Vehicle: TN01AA1111 (Car)
  [SUCCESS] Slot allocated: [0, 0]
  [TICKET ISSUED] Ticket #1001 at 9:00 hrs

[ENTRY REQUEST] Vehicle: TN02BB2222 (TwoWheeler)
  [SUCCESS] Slot allocated: [0, 1]
  [TICKET ISSUED] Ticket #1002 at 10:00 hrs

[ENTRY REQUEST] Vehicle: TN03CC3333 (Car)
  [SUCCESS] Slot allocated: [1, 0]
  [TICKET ISSUED] Ticket #1003 at 10:00 hrs

[ENTRY REQUEST] Vehicle: TN01AA1111 (Car)
  [ERROR: DUPLICATE ENTRY] Vehicle TN01AA1111 is ALREADY parked in slot [0, 0]! Entry denied.

[ENTRY REQUEST] Vehicle: TN04DD4444 (TwoWheeler)
  [SUCCESS] Slot allocated: [1, 1]
  [TICKET ISSUED] Ticket #1004 at 11:00 hrs

[ENTRY REQUEST] Vehicle: TN05EE5555 (Car)
  [FACILITY FULL] No slots available in the parking lot. Entry denied.

--- Current Parking Grid Status ---
[TN01AA1111] [TN02BB2222] 
[TN03CC3333] [TN04DD4444] 

[EXIT REQUEST] Attempting exit for Slot: [9, 9]
  [ERROR: INVALID SLOT] Coordinates [9, 9] are out of bounds!

[EXIT REQUEST] Attempting exit for Slot: [0, 0]
  [EXIT SUCCESS] Vehicle TN01AA1111 cleared from slot [0, 0]
  Duration: 3 hour(s) | Rate: Rs 30.0/hr
  Total Parking Fee Paid: Rs 90.0

[EXIT REQUEST] Attempting exit for Slot: [0, 0]
  [ERROR: SLOT VACANT] Slot [0, 0] has no parked vehicle!

[EXIT REQUEST] Attempting exit for Slot: [0, 1]
  [EXIT SUCCESS] Vehicle TN02BB2222 cleared from slot [0, 1]
  Duration: 2 hour(s) | Rate: Rs 10.0/hr
  Total Parking Fee Paid: Rs 20.0

--- Current Parking Grid Status ---
[ Empty ] [ Empty ] 
[TN03CC3333] [TN04DD4444] 

[ENTRY REQUEST] Vehicle: TN06FF6666 (Car)
  [SUCCESS] Slot allocated: [0, 0]
  [TICKET ISSUED] Ticket #1005 at 13:00 hrs

==========================================
     DAILY PARKING COLLECTION REPORT      
==========================================
Total Facility Capacity : 4 slots
Currently Occupied      : 3 slots
Currently Vacant        : 1 slots
Total Tickets Processed : 5
Total Daily Collections : Rs 110.0
==========================================

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 11"`, `javac Main.java`, and `java Main`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 11 section in your report.
