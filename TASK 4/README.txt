================================================================================
CSA09 Assignment 1 - TASK 4: Classes, Objects, Constructors, Overloading & 'this' Keyword
================================================================================

1. TASK OBJECTIVE:
To demonstrate class definitions, constructor overloading, and the usage of the 
'this' keyword in Java. The task shows how constructors can be overloaded with 
varying parameter counts, how `this(...)` enables constructor chaining to eliminate 
code redundancy, and how `this.variable` resolves shadowing between local constructor 
parameters and instance fields.

2. CONCEPTS DEMONSTRATED:
- Class & Objects: SmartSlot class modeling campus parking spaces.
- Constructors:
  * Default Constructor SmartSlot(): sets default slot 101 on floor 1.
  * Overloaded Constructor SmartSlot(slotNumber, floorNumber): defaults slotType to "Standard".
  * Fully Parameterized Constructor SmartSlot(slotNumber, floorNumber, slotType).
- 'this' Keyword:
  * Constructor Chaining: `this(101, 1, "Standard");` calls the 3-arg constructor from 
    the 0-arg and 2-arg constructors. Must be the first line in the constructor body.
  * Field Disambiguation: `this.slotNumber = slotNumber;` distinguishes the instance variable 
    from the parameter having the identical name.
- Object state alteration via `occupy()` method.

3. ALGORITHM / WORKFLOW:
Step 1: Start main method in Task4.
Step 2: Instantiate `slotDefault` using the default constructor `new SmartSlot()`.
        - Calls 3-parameter constructor via `this(101, 1, "Standard")`.
        - Displays initial slot state.
Step 3: Instantiate `slotTwoParam` using 2-parameter constructor `new SmartSlot(205, 2)`.
        - Chains to 3-parameter constructor with default type "Standard".
        - Displays slot state.
Step 4: Instantiate `slotEv` using full 3-parameter constructor `new SmartSlot(310, 3, "EV-Charging")`.
        - Assigns all fields directly using `this` prefix.
        - Displays slot state.
Step 5: Change `slotEv` state by invoking `occupy()`, setting `isOccupied` to true.
Step 6: Display updated state of `slotEv` showing occupied status.
Step 7: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 4"
   javac Task4.java
   java Task4
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
  TASK 4: CONSTRUCTORS & 'this' KEYWORD DEMO      
==================================================

--- 1. Instantiating via Default Constructor ---
[INFO] Full parameterized constructor invoked for Slot #101 (Standard)
[INFO] Default constructor invoked. Assigned default Slot #101 on Floor 1.
  Slot ID      : #101
  Floor Level  : Floor 1
  Slot Type    : Standard
  Occupied?    : NO
  --------------------------------------

--- 2. Instantiating via 2-Parameter Constructor ---
[INFO] Full parameterized constructor invoked for Slot #205 (Standard)
[INFO] Two-parameter constructor invoked for Slot #205
  Slot ID      : #205
  Floor Level  : Floor 2
  Slot Type    : Standard
  Occupied?    : NO
  --------------------------------------

--- 3. Instantiating via Full 3-Parameter Constructor ---
[INFO] Full parameterized constructor invoked for Slot #310 (EV-Charging)
  Slot ID      : #310
  Floor Level  : Floor 3
  Slot Type    : EV-Charging
  Occupied?    : NO
  --------------------------------------

--- 4. Changing Object State ---
[UPDATE] Slot #310 has been OCCUPIED.
  Slot ID      : #310
  Floor Level  : Floor 3
  Slot Type    : EV-Charging
  Occupied?    : YES
  --------------------------------------

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open terminal in VS Code.
2. Run `cd "TASK 4"` -> `javac Task4.java` -> `java Task4`.
3. Capture the screen with `Win + Shift + S`.
4. Paste the screenshot under the Task 4 section in your report.
