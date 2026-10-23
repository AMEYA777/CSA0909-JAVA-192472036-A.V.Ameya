================================================================================
CSA09 Assignment 1 - TASK 9: Abstract Vehicle Class & Chargeable Interface Contracts
================================================================================

1. TASK OBJECTIVE:
To demonstrate the architectural difference between Abstract Classes and Interfaces in Java. 
An abstract class provides partial implementation and encapsulates common state (fields, 
constructors, helper methods), whereas an interface provides a pure behavioral contract 
without state. The task also illustrates multiple interface implementation in Java.

2. CONCEPTS DEMONSTRATED:
- Interfaces:
  * `Chargeable`: Defines calculation and invoice printing contracts.
  * `SecurityInspectable`: Defines security verification contract.
  * Demonstrates how a Java class can implement multiple interfaces (`implements Chargeable, SecurityInspectable`).
- Abstract Class:
  * `AbstractVehicle`: Contains state (registrationNumber, driverName, driverCategory), 
    constructor, and concrete methods (`printGatePass()`, `performSecurityCheck()`, `printInvoice()`).
  * Enforces abstract methods (`getVehicleCategory()`, `getHourlyRate()`) which must be 
    implemented by concrete subclasses.
- Subclasses:
  * `CampusTwoWheeler`: Student rate Rs 10/hr, Faculty rate Rs 15/hr.
  * `CampusCar`: Visitor rate Rs 40/hr, Campus community rate Rs 25/hr.
- Heterogeneous Polymorphic Array: `AbstractVehicle[]` processed with a single uniform loop.

3. ALGORITHM / WORKFLOW:
Step 1: Declare an array `AbstractVehicle[]` containing CampusTwoWheeler and CampusCar objects.
Step 2: Loop through each vehicle in the array.
Step 3: Invoke `printGatePass()` to display identity and campus driver role.
Step 4: Invoke `performSecurityCheck()` to simulate gate inspection.
Step 5: Invoke `printInvoice(4)` to dynamically calculate fee and print structured invoice.
Step 6: Display summary key takeaways.
Step 7: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 9"
   javac Task9.java
   java Task9
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
 TASK 9: ABSTRACT CLASS & CHARGEABLE CONTRACTS    
==================================================

--- 1. Polymorphic Collection of AbstractVehicle ---
GATE PASS -> Reg: TN14Z1001 | Driver: Arun (B.Tech) (Student)
  [SECURITY CHECK] Vehicle TN14Z1001: Trunk & ID inspected -> CLEARED
==========================================
           CAMPUS PARKING INVOICE         
==========================================
Vehicle Type  : Two-Wheeler (Motorcycle/Scooter)
Plate Number  : TN14Z1001
Driver        : Arun (B.Tech) (Student)
Hours Parked  : 4 hrs
Rate Applied  : Rs 10.0 / hr
Total Amount  : Rs 40.0
==========================================

GATE PASS -> Reg: TN02K5566 | Driver: Prof. Meenakshi (Faculty)
  [SECURITY CHECK] Vehicle TN02K5566: Trunk & ID inspected -> CLEARED
==========================================
           CAMPUS PARKING INVOICE         
==========================================
Vehicle Type  : Four-Wheeler (Car/SUV)
Plate Number  : TN02K5566
Driver        : Prof. Meenakshi (Faculty)
Hours Parked  : 4 hrs
Rate Applied  : Rs 25.0 / hr
Total Amount  : Rs 100.0
==========================================

GATE PASS -> Reg: KA03MM8899 | Driver: Vendor Rajesh (Visitor)
  [SECURITY CHECK] Vehicle KA03MM8899: Trunk & ID inspected -> CLEARED
==========================================
           CAMPUS PARKING INVOICE         
==========================================
Vehicle Type  : Four-Wheeler (Car/SUV)
Plate Number  : KA03MM8899
Driver        : Vendor Rajesh (Visitor)
Hours Parked  : 4 hrs
Rate Applied  : Rs 40.0 / hr
Total Amount  : Rs 160.0
==========================================

--- 2. Key Takeaways ---
1. 'AbstractVehicle' cannot be instantiated directly with 'new AbstractVehicle()'.
2. 'Chargeable' and 'SecurityInspectable' enforce contracts ensuring all vehicles
   can be billed and inspected polymorphically.

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 9"`, `javac Task9.java`, and `java Task9`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 9 section in your report.
