================================================================================
CSA09 Assignment 1 - TASK 1: Problem Definition & Candidate Classes
================================================================================

1. TASK OBJECTIVE:
To analyze the real-world campus parking problem (congestion, manual slip delays, 
lack of slot visibility, unauthorized parking) and identify candidate Object-Oriented 
entities. We define classes representing the fundamental domain concepts: Vehicle, 
ParkingSlot, and ParkingTicket.

2. CANDIDATE CLASSES IDENTIFIED:
a) Vehicle:
   - Attributes: vehicleNo (String), vehicleType (String), ownerName (String)
   - Method: display()
b) ParkingSlot:
   - Attributes: slotNumber (int), slotType (String), isOccupied (boolean), parkedVehicle (Vehicle)
   - Methods: park(Vehicle v), display()
c) ParkingTicket:
   - Attributes: ticketId (int), vehicleNo (String), slotNumber (int), entryTime (String)
   - Method: printTicket()

3. ALGORITHM / WORKFLOW:
Step 1: Start the program and print problem statement header.
Step 2: Instantiate candidate Vehicle objects (Car and Two-Wheeler) with registration and owner data.
Step 3: Instantiate ParkingSlot objects with unique slot numbers and types.
Step 4: Display initial vacant slot statuses.
Step 5: Park the vehicles into the corresponding slots, updating isOccupied to true.
Step 6: Display updated slot statuses showing occupied status and parked vehicle info.
Step 7: Generate and print a ParkingTicket receipt with ticket ID, vehicle registration, slot number, and timestamp.
Step 8: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 1"
   javac TASK1.java
   java TASK1
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
    CAMPUS SMART-PARKING SYSTEM: TASK 1 DEMO      
==================================================
PROBLEM STATEMENT:
Traditional campus parking suffers from congestion,
lack of real-time slot visibility, and unauthorized
parking. Object-Oriented modeling solves this by
representing vehicles, slots, and tickets as objects.

--- 1. Creating Candidate Objects ---
Vehicle 1 Details:
  Vehicle Number : TN01AB1234
  Vehicle Type   : Car
  Owner / Driver : Dr. A. Kumar (Faculty)

Vehicle 2 Details:
  Vehicle Number : TN02CD5678
  Vehicle Type   : Two-Wheeler
  Owner / Driver : Sneha Rao (Student)

--- 2. Creating Parking Slots ---
Slot #101 [Car] -> Status: VACANT
Slot #102 [Two-Wheeler] -> Status: VACANT

--- 3. Simulating Parking ---
[SUCCESS] Vehicle TN01AB1234 parked in Slot #101
[SUCCESS] Vehicle TN02CD5678 parked in Slot #102

--- Updated Slot Statuses ---
Slot #101 [Car] -> Status: OCCUPIED
  Occupied by: TN01AB1234 (Dr. A. Kumar (Faculty))
Slot #102 [Two-Wheeler] -> Status: OCCUPIED
  Occupied by: TN02CD5678 (Sneha Rao (Student))

--- 4. Issuing Parking Tickets ---
------------------------------------------
        CAMPUS SMART PARKING TICKET       
------------------------------------------
Ticket ID    : TKT-5001
Vehicle No   : TN01AB1234
Slot Number  : #101
Entry Time   : 09:15 AM
------------------------------------------

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open Terminal in VS Code (`Ctrl + ~`).
2. Run `cd "TASK 1"` followed by `javac TASK1.java` and `java TASK1`.
3. Press `Win + Shift + S` (Windows Snipping Tool) or `Alt + PrtScn`.
4. Drag across the terminal area showing the command and output.
5. Paste (`Ctrl + V`) into your assignment report under the Task 1 screenshot box.
