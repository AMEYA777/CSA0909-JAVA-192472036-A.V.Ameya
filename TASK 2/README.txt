================================================================================
CSA09 Assignment 1 - TASK 2: Java Data Types, Arrays & Parking-Slot Representation
================================================================================

1. TASK OBJECTIVE:
To demonstrate the proper usage of Java primitive data types (int, double, char, 
boolean, long), reference types (String, 1D array), and a 2-dimensional array to model 
a structured parking lot matrix. The program visually displays vacant and occupied slots 
and computes utilization metrics.

2. CONCEPTS DEMONSTRATED:
- Primitive data types:
  * int totalCapacity, floorNumber, slotNumber (whole numbers)
  * double parkingFee (floating-point currency)
  * char vehicleCategory ('C' for car, 'B' for bike)
  * boolean isCampusOpen (true/false gate state)
  * long entryTimestamp (64-bit integer timestamp)
- Reference data types:
  * String vehicleNumber, facilityName
  * 1D Array: int[] slotIdentifiers
  * 2D Array: String[][] parkingSlots (Row x Col matrix)
- Loops and nested iteration for metric calculation and grid visualization.

3. ALGORITHM / WORKFLOW:
Step 1: Declare and initialize primitive variables describing parking facility settings.
Step 2: Print primitive values and their types to console.
Step 3: Declare and iterate over a 1D array of quick-access slot numbers.
Step 4: Instantiate a 2D array of Strings `parkingSlots[rows][cols]`.
Step 5: Populate specific coordinates [r][c] with vehicle registration strings to simulate parked cars.
Step 6: Traverse the 2D array to render a formatted visual grid of occupied and empty slots.
Step 7: Count total, occupied, and vacant slots; compute occupancy percentage:
        occupancyRate = (occupiedCount / totalSlots) * 100.
Step 8: Display the final summary metrics.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 2"
   javac Task2.java
   java Task2
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
  TASK 2: DATA TYPES, ARRAYS & PARKING GRID DEMO  
==================================================
--- 1. Primitive Data Types in Parking System ---
Floor Number            : 1
Slot Number             : 5
Vehicle Number          : TN01AB1234
Parking Fee per Hour    : Rs 60.0 (double)
Total Facility Capacity : 12 slots (int)
Vehicle Category Code   : 'C' (char)
Campus Facility Open?   : true (boolean)
Gate Entry Timestamp    : 1718000000000 ms (long)

--- 2. Reference Types: 1D Array of Slot Numbers ---
Facility Name: Main Campus North Lot
Quick Access Slots: #101, #102, #103, #104

--- 3. 2D Array Representation of Parking Grid ---
Sample Slot [0][0]: TN02CD5678
Sample Slot [0][1]: TN03EF9012
Sample Slot [0][2]: EMPTY

Parking Layout (Row x Col):
       Col 0       Col 1       Col 2       Col 3       
Row 0: [ TN02CD5678 ] [ TN03EF9012 ] [   EMPTY    ] [   EMPTY    ] 
Row 1: [   EMPTY    ] [   EMPTY    ] [ TN01AB1234 ] [   EMPTY    ] 
Row 2: [ TN07GH3456 ] [   EMPTY    ] [   EMPTY    ] [ TN09KL7890 ] 

--- Parking Summary Metrics ---
Total Grid Slots : 12
Occupied Slots   : 5
Available Slots  : 7
Occupancy Rate   : 41.67%

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open Terminal in VS Code (`Ctrl + ~`).
2. Run `cd "TASK 2"` followed by `javac Task2.java` and `java Task2`.
3. Press `Win + Shift + S` or `Alt + PrtScn` to capture the output window.
4. Paste (`Ctrl + V`) into your assignment report under the Task 2 screenshot section.
