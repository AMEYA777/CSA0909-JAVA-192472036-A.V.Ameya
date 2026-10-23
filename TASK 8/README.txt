================================================================================
CSA09 Assignment 1 - TASK 8: Chargeable Interface & Fee Hierarchy (FeeDemo.java)
================================================================================

1. TASK OBJECTIVE:
To design an interface contract `Chargeable` and implement a polymorphic fee calculation 
hierarchy for diverse vehicle types in the campus parking system (TwoWheeler, Car, and 
ElectricCar). The task validates runtime polymorphism (dynamic method dispatch) and 
interface type querying using the `instanceof` operator.

2. CONCEPTS DEMONSTRATED:
- Interface Contract:
  * `interface Chargeable`: Declares `calculateFee(int hours)` and overloaded `calculateFee()`.
- Abstract Superclass:
  * `abstract class Vehicle implements Chargeable`: Holds common state (regNo, hoursParked) 
    and bridges interface contracts to subclasses.
- Subclasses & Polymorphic Rates:
  * `TwoWheeler`: Rate = Rs 10.0 / hour. For 3 hours = Rs 30.0.
  * `Car`: Rate = Rs 30.0 / hour. For 3 hours = Rs 90.0.
  * `ElectricCar extends Car`: Base car rate (Rs 90.0) + charging service fee (Rs 120.0) = Rs 210.0.
- `instanceof` Operator:
  * Confirms at runtime that `v3` (an ElectricCar referenced by a Vehicle reference) 
    is an instance of the `Chargeable` interface.

3. ALGORITHM / WORKFLOW:
Step 1: Declare reference variables of abstract type `Vehicle`:
        v1 = new TwoWheeler("TN01A1");
        v2 = new Car("TN02B2");
        v3 = new ElectricCar("TN03C3");
Step 2: Invoke `v1.calculateFee(3)`. JVM resolves to TwoWheeler.calculateFee() -> 3 * 10 = Rs 30.0.
Step 3: Invoke `v2.calculateFee(3)`. JVM resolves to Car.calculateFee() -> 3 * 30 = Rs 90.0.
Step 4: Invoke `v3.calculateFee(3)`. JVM resolves to ElectricCar.calculateFee() -> (3 * 30) + 120 = Rs 210.0.
Step 5: Evaluate expression `v3 instanceof Chargeable` -> Evaluates to `true`.
Step 6: Print results to console and stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 8"
   javac FeeDemo.java
   java FeeDemo
   cd ..

5. ACTUAL PROGRAM OUTPUT:
TwoWheeler TN01A1 -> Rs 30.0
Car TN02B2 -> Rs 90.0
ElectricCar TN03C3 -> Rs 210.0
true

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 8"` -> `javac FeeDemo.java` -> `java FeeDemo`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 8 section in your report.
