================================================================================
CSA09 Assignment 1 - TASK 7: Method Overriding, equals(), hashCode() and toString()
================================================================================

1. TASK OBJECTIVE:
To demonstrate the proper polymorphic overriding of fundamental `java.lang.Object` methods:
`toString()`, `equals(Object obj)`, and `hashCode()`. In campus parking systems, vehicle 
identity is governed by the state (registration number) rather than memory pointer identity.

2. CONCEPTS DEMONSTRATED:
- toString():
  * Default implementation in Object prints `ClassName@hexHash`.
  * Overridden implementation outputs human-readable description: 
    `RegisteredVehicle [Plate=TN07CK1234, Type=Car, Owner=Prof. Raman]`.
- equals(Object obj):
  * Default `==` tests reference identity (same memory address on Heap).
  * Overridden `equals()` compares registration numbers using `equalsIgnoreCase()`.
  * Proper defensive 4-step check:
    1. Reference equality check (`this == obj`).
    2. Null & class type check (`obj == null || getClass() != obj.getClass()`).
    3. Safe downcasting `(RegisteredVehicle) obj`.
    4. Business field comparison on registration plate.
- hashCode():
  * The Java Contract: If `v1.equals(v2)` is true, `v1.hashCode()` MUST equal `v2.hashCode()`.
  * Implemented using `Objects.hash(registrationNumber.toUpperCase())`.
- Practical Application: Duplicate vehicle entry prevention.

3. ALGORITHM / WORKFLOW:
Step 1: Instantiate two distinct vehicle objects v1 and v2 having identical plate number "TN07CK1234".
Step 2: Instantiate vehicle v3 with different plate number "TN09ZZ9999".
Step 3: Print v1 and v3; verify toString() provides formatted attributes.
Step 4: Compare `v1 == v2` -> Evaluates to `false` (different heap memory addresses).
Step 5: Compare `v1.equals(v2)` -> Evaluates to `true` (overridden logical value check).
Step 6: Verify `v1.hashCode() == v2.hashCode()` -> Confirms hash contract holds.
Step 7: Search an active lot array containing v1 with incoming vehicle v2.
Step 8: Detect duplicate registration via `.equals()`, log alert and prevent ticket issuance.
Step 9: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 7"
   javac Task7.java
   java Task7
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
 TASK 7: toString(), equals() & hashCode() DEMO   
==================================================

--- 1. Testing toString() Overriding ---
v1: RegisteredVehicle [Plate=TN07CK1234, Type=Car, Owner=Prof. Raman]
v3: RegisteredVehicle [Plate=TN09ZZ9999, Type=Two-Wheeler, Owner=Student Pooja]

--- 2. Reference Equality (==) vs Logical Equality (equals) ---
Comparing v1 and v2 with '==' (Reference check): false
Explanation: 'false' because v1 and v2 are two distinct objects stored in different heap addresses.

Comparing v1 and v2 with '.equals()' (Value check): true
Explanation: 'true' because our overridden equals() compares the registration numbers!

Comparing v1 and v3 with '.equals()': false

--- 3. Testing hashCode() Contract ---
v1 hashCode: 2011019688
v2 hashCode: 2011019688
v3 hashCode: 1726053326
Do v1 and v2 share identical hashCodes? true

--- 4. Practical Application: Duplicate Entry Prevention ---
[ALERT] Cannot issue ticket! Vehicle TN07CK1234 is ALREADY parked in the facility.

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 7"`, `javac Task7.java`, and `java Task7`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 7 section in your report.
