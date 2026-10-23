================================================================================
CSA09 Assignment 1 - TASK 10: Encapsulation, Access Modifiers & Defensive Data Validation
================================================================================

1. TASK OBJECTIVE:
To demonstrate encapsulation (data hiding), examine the 4 Java access modifiers (`private`, 
default/package-private, `protected`, and `public`), and apply defensive programming inside 
getters and setters to protect internal object state from corruption.

2. CONCEPTS DEMONSTRATED:
- The 4 Java Access Modifiers:
  * `private`: Hidden from all external classes. Fields `registrationNumber`, `floorNumber`, 
    `parkedHours`, `hourlyRate`, and `isPaid` can only be read or modified through public methods.
  * default (package-private): Accessible only within the same package (`sessionNotes`).
  * `protected`: Accessible within the same package and by subclasses (`securityBadge`).
  * `public`: Globally accessible constructors and methods (`displaySessionSummary()`, getters/setters).
- Defensive Validation in Setters:
  * `setRegistrationNumber(regNo)`: Rejects null or strings outside 6–12 characters; converts to uppercase.
  * `setFloorNumber(floor)`: Constrains floors to the valid campus range 0 to 4.
  * `setParkedHours(hours)`: Restricts duration between 1 and 24 hours.
  * `setHourlyRate(rate)`: Prohibits negative monetary rates.
- State Integrity:
  When validation fails, an informative error message is displayed, and existing valid 
  field values remain completely untouched.

3. ALGORITHM / WORKFLOW:
Step 1: Instantiate `EncapsulatedParkingSession` with valid initial parameters.
Step 2: Display initial session state and computed fee.
Step 3: Test invalid negative hours (-5). Setter validation detects `hours <= 0` and rejects update.
Step 4: Test out-of-bounds floor (Floor 9). Setter validation detects `floor > 4` and rejects update.
Step 5: Test short registration plate ("AB"). Setter validation detects length < 6 and rejects update.
Step 6: Test negative rate (-50.0). Setter validation detects `rate < 0` and rejects update.
Step 7: Verify session summary; confirm initial data was not corrupted by rejected attempts.
Step 8: Apply valid modifications (hours = 5, floor = 3, isPaid = true).
Step 9: Display final updated session summary and stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 10"
   javac Task10.java
   java Task10
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
 TASK 10: ENCAPSULATION & DATA VALIDATION DEMO    
==================================================

--- 1. Creating Encapsulated Object with Valid Data ---
[SUCCESS] Registration number updated to: TN01BB9999
[SUCCESS] Floor updated to: Floor 2
[SUCCESS] Parked duration updated to: 3 hour(s)
  Plate Number  : TN01BB9999
  Floor         : Floor 2
  Duration      : 3 hrs
  Rate / Hour   : Rs 20.0
  Total Fee     : Rs 60.0
  Paid Status   : PENDING
  --------------------------------------

--- 2. Testing Defensive Validation (Invalid Inputs) ---
Attempting to set an invalid negative duration (-5 hours):
[VALIDATION ERROR] Parking duration must be at least 1 hour. Input was: -5

Attempting to set an invalid floor (Floor 9):
[VALIDATION ERROR] Floor 9 does not exist! Campus floors are 0 to 4. Keeping Floor 2

Attempting to set an invalid empty/short registration plate ('AB'):
[VALIDATION ERROR] Invalid registration number: 'AB'. Must be 6 to 12 characters. Modification rejected!

Attempting to set a negative rate (-50.0):
[VALIDATION ERROR] Hourly rate cannot be negative! Rejected: Rs -50.0

--- 3. Verifying Object State Remains Intact & Uncorrupted ---
  Plate Number  : TN01BB9999
  Floor         : Floor 2
  Duration      : 3 hrs
  Rate / Hour   : Rs 20.0
  Total Fee     : Rs 60.0
  Paid Status   : PENDING
  --------------------------------------
--- 4. Applying Valid Updates ---
[SUCCESS] Parked duration updated to: 5 hour(s)
[SUCCESS] Floor updated to: Floor 3
  Plate Number  : TN01BB9999
  Floor         : Floor 3
  Duration      : 5 hrs
  Rate / Hour   : Rs 20.0
  Total Fee     : Rs 100.0
  Paid Status   : PAID
  --------------------------------------

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 10"`, `javac Task10.java`, and `java Task10`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 10 section in your report.
