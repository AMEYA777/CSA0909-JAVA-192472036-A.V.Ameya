================================================================================
CSA09 Assignment 1 - TASK 6: Vehicle Inheritance Hierarchy & super() Keyword
================================================================================

1. TASK OBJECTIVE:
To demonstrate class inheritance hierarchies in Java:
- Single Inheritance: TwoWheelerVehicle extends BaseVehicle
- Hierarchical Inheritance: TwoWheelerVehicle and CarVehicle both extend BaseVehicle
- Multi-Level Inheritance: ElectricCarVehicle extends CarVehicle extends BaseVehicle
The task explains the exact role of `super(...)` for constructor execution and `super.method()` 
for method reuse.

2. CONCEPTS DEMONSTRATED:
- BaseVehicle (Parent Superclass): Encapsulates shared attributes (registrationNumber, brand, 
  baseHourlyRate) and default displayDetails().
- Subclasses:
  * TwoWheelerVehicle adds helmet storage flag.
  * CarVehicle adds passenger seating capacity.
  * ElectricCarVehicle adds battery capacity (kWh) and charging requirement flag.
- The `super()` Keyword Explained:
  1. Constructor Chaining: `super(reg, brand, rate)` must be the VERY FIRST statement inside 
     the subclass constructor. It invokes the parent constructor before initializing subclass fields.
  2. Multi-level Constructor Order: JVM executes BaseVehicle -> CarVehicle -> ElectricCarVehicle.
  3. Parent Method Reuse: `super.displayDetails()` calls parent printing logic, eliminating 
     duplicate code.

3. ALGORITHM / WORKFLOW:
Step 1: Start Task6 main method.
Step 2: Instantiate TwoWheelerVehicle. JVM invokes BaseVehicle constructor, then TwoWheeler constructor.
Step 3: Call bike.displayDetails(), which executes super.displayDetails() then prints helmet storage.
Step 4: Instantiate CarVehicle. JVM invokes BaseVehicle constructor, then Car constructor.
Step 5: Call car.displayDetails().
Step 6: Instantiate ElectricCarVehicle. JVM executes BaseVehicle -> CarVehicle -> ElectricCarVehicle.
Step 7: Call ev.displayDetails(), showing inherited and specific EV fields.
Step 8: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 6"
   javac Task6.java
   java Task6
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
  TASK 6: INHERITANCE HIERARCHY & super() DEMO    
==================================================

--- 1. Instantiating TwoWheeler (Single Inheritance) ---
  [BASE CONSTRUCTOR] BaseVehicle initialized for: TN10AB1234
  [SUBCLASS CONSTRUCTOR] TwoWheelerVehicle initialized.

[Details]
Registration : TN10AB1234
Brand        : Honda Activa
Base Rate    : Rs 10.0 / hour
Helmet Storage: Available

--------------------------------------------------
--- 2. Instantiating Car (Hierarchical Inheritance) ---
  [BASE CONSTRUCTOR] BaseVehicle initialized for: TN09XY9988
  [SUBCLASS CONSTRUCTOR] CarVehicle initialized with 5 seats.

[Details]
Registration : TN09XY9988
Brand        : Maruti Suzuki Swift
Base Rate    : Rs 30.0 / hour
Seating Cap  : 5 passengers

--------------------------------------------------
--- 3. Instantiating ElectricCar (Multi-Level Inheritance) ---
  [BASE CONSTRUCTOR] BaseVehicle initialized for: TN01EV0001
  [SUBCLASS CONSTRUCTOR] CarVehicle initialized with 5 seats.
  [MULTI-LEVEL CONSTRUCTOR] ElectricCarVehicle initialized (40.5 kWh).

[Details]
Registration : TN01EV0001
Brand        : Tata Nexon EV
Base Rate    : Rs 35.0 / hour
Seating Cap  : 5 passengers
Battery Size : 40.5 kWh
EV Charging  : Active (Charging Slot)

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 6"`, `javac Task6.java`, and `java Task6`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 6 section in your report.
