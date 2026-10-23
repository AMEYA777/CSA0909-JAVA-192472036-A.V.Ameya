================================================================================
CSA09 Assignment 1 - TASK 3: Parking Facility Allocation & Release Logic
================================================================================

1. TASK OBJECTIVE:
To implement the core parking slot management methods: allocate() and release(), 
modeling a parking facility with a multi-floor slot grid. The allocate() method finds 
and reserves the first available spot, while release() safely validates coordinates, 
ensures the slot is occupied, and frees it.

2. CONCEPTS DEMONSTRATED:
- Jagged 2D boolean array:
  Floor 0 has 2 slots ([0, 0] and [0, 1])
  Floor 1 has 1 slot ([1, 0])
- Linear search across 2D array dimensions
- Defensive boundary checking (r < 0 || r >= rows || c < 0 || c >= cols)
- Handling edge cases:
  * Full capacity (allocate returns null)
  * Double release on already vacant spot (returns false)
  * Out-of-bounds release attempt [5, 5] (returns false)

3. ALGORITHM / WORKFLOW:
Algorithm for allocate():
Step 1: Traverse each row r from 0 to slots.length - 1.
Step 2: Traverse each column c from 0 to slots[r].length - 1.
Step 3: If slots[r][c] == false (unoccupied):
        a) Set slots[r][c] = true (mark occupied).
        b) Return new int[] { r, c }.
Step 4: If entire grid is traversed and no slot is free, return null.

Algorithm for release(r, c):
Step 1: Check if r < 0 OR r >= slots.length -> Return false (invalid row).
Step 2: Check if c < 0 OR c >= slots[r].length -> Return false (invalid column).
Step 3: If slots[r][c] == true:
        a) Set slots[r][c] = false (free slot).
        b) Return true (successful release).
Step 4: Else return false (slot was already vacant).

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 3"
   javac ParkingFacility.java
   java ParkingFacility
   cd ..

5. ACTUAL PROGRAM OUTPUT:
[0, 0]
[0, 1]
[1, 0]
null
true false false
[0, 1]

Explanation of Output:
- [0, 0] -> 1st allocation takes Floor 0, Slot 0
- [0, 1] -> 2nd allocation takes Floor 0, Slot 1
- [1, 0] -> 3rd allocation takes Floor 1, Slot 0
- null   -> 4th allocation fails because facility capacity (3 slots) is exhausted
- true false false:
    * facility.release(0, 1) returns true (successfully frees slot [0, 1])
    * facility.release(0, 1) returns false (already vacant, duplicate release rejected)
    * facility.release(5, 5) returns false (out-of-bounds coordinate rejected)
- [0, 1] -> Next allocation immediately takes the freed slot [0, 1]

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Navigate with `cd "TASK 3"`.
3. Run `javac ParkingFacility.java` followed by `java ParkingFacility`.
4. Capture using `Win + Shift + S` or Snipping Tool.
5. Paste into your assignment report under Task 3.
