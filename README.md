# Campus Smart-Parking System (CSA09 Java Assignment 1)

> **Course**: CSA09 - Object-Oriented Programming in Java  
> **Student Register Number**: `192472036` (or `YourRegisterNumber`)  
> **Environment**: Visual Studio Code (VS Code) with Java SE 21 (LTS)  
> **Frameworks / Libraries**: Pure Standard Java (No external build tools or paid APIs required)  

---

## 1. Project Title & Objectives

### Project Title
**Design, Implement, and Validate an Object-Oriented Model for a Campus Smart-Parking System**

### Objectives
1. **Solve Campus Congestion**: Model a digital smart-parking infrastructure to replace slow manual paper slips, eliminate search friction, and prevent revenue leakage.
2. **Master Object-Oriented Fundamentals**: Systematically implement and validate core Java principles across 12 structured tasks:
   - Domain modeling and candidate class discovery
   - Primitive data types, reference types, and 2D parking matrix representations
   - First-available slot allocation and defensive release algorithms
   - Constructor overloading and `this` keyword constructor chaining
   - Static sequence counters and the 5 stages of the Java object life cycle
   - Single, hierarchical, and multi-level inheritance with `super()`
   - Polymorphic method overriding (`toString()`, `equals()`, `hashCode()`) for duplicate vehicle detection
   - Interface contracts (`Chargeable`) and dynamic fee calculation hierarchies
   - Abstract classes vs. interfaces and multiple interface implementation
   - Encapsulation, all 4 Java access modifiers, and defensive input validation
   - Integrated end-to-end parking management application
   - Advanced multi-floor jagged array modeling, green mobility flat fees, peak-hour commercial delivery pricing, and visitor one-day passes

---

## 2. Software Requirements

- **Operating System**: Windows 10/11
- **Java Development Kit (JDK)**: OpenJDK 21 LTS (or JDK 17+)
- **Code Editor**: Visual Studio Code (VS Code)
- **VS Code Extensions**: Extension Pack for Java (by Microsoft)
- **Command Shell**: PowerShell or Windows Command Prompt

---

## 3. Project Directory Structure

```text
CSA09-YourRegisterNumber-Assignment1/
│
├── TASK 1/
│   ├── TASK1.java           # Candidate classes: Vehicle, ParkingSlot, ParkingTicket
│   └── README.txt           # Task 1 concept, algorithm, commands, and actual output
│
├── TASK 2/
│   ├── Task2.java           # Primitive types, 1D slot array, and 2D parking matrix
│   └── README.txt           # Task 2 concept, algorithm, commands, and actual output
│
├── TASK 3/
│   ├── ParkingFacility.java # allocate() and release(r, c) slot algorithms
│   └── README.txt           # Task 3 concept, algorithm, commands, and actual output
│
├── TASK 4/
│   ├── Task4.java           # Constructor overloading and this(...) constructor chaining
│   └── README.txt           # Task 4 concept, algorithm, commands, and actual output
│
├── TASK 5/
│   ├── Task5.java           # Static counters and 5 stages of object life cycle
│   └── README.txt           # Task 5 concept, algorithm, commands, and actual output
│
├── TASK 6/
│   ├── Task6.java           # Vehicle inheritance (Single, Hierarchical, Multi-level) & super()
│   └── README.txt           # Task 6 concept, algorithm, commands, and actual output
│
├── TASK 7/
│   ├── Task7.java           # Method overriding: toString(), equals(), hashCode() for duplicate check
│   └── README.txt           # Task 7 concept, algorithm, commands, and actual output
│
├── TASK 8/
│   ├── FeeDemo.java         # Chargeable interface and polymorphic fee calculation
│   └── README.txt           # Task 8 concept, algorithm, commands, and actual output
│
├── TASK 9/
│   ├── Task9.java           # Abstract class vs interface, multiple interface implementation
│   └── README.txt           # Task 9 concept, algorithm, commands, and actual output
│
├── TASK 10/
│   ├── Task10.java          # Encapsulation, 4 access modifiers, and defensive validation
│   └── README.txt           # Task 10 concept, algorithm, commands, and actual output
│
├── TASK 11/
│   ├── Main.java            # End-to-end working campus smart-parking application
│   └── README.txt           # Task 11 concept, algorithm, commands, and actual output
│
├── TASK 12/
│   ├── PricingRule.java     # Flexible strategy interface for pricing rules
│   ├── E_Bike.java          # Flat subsidized fee model (Rs 20.0)
│   ├── DeliveryVan.java     # Commercial van peak-hour pricing (2x rate 9 AM - 5 PM)
│   ├── OneDayPass.java      # Campus visitor one-day pass model (Rs 150.0)
│   ├── Main.java            # 5-Floor jagged array facility & revenue audit
│   └── README.txt           # Task 12 concept, algorithm, commands, and actual output
│
└── README.md                # Main comprehensive project documentation
```

---

## 4. Concept Map across Tasks

| Task | Topic | Key Java OOP Concepts Applied |
| :--- | :--- | :--- |
| **TASK 1** | Candidate Classes | Domain decomposition, `class`, `new`, instance fields, methods |
| **TASK 2** | Data Types & Arrays | `int`, `double`, `char`, `boolean`, `long`, 1D arrays, 2D arrays |
| **TASK 3** | Slot Logic | Jagged 2D grid, search algorithm, boundary checks, state mutation |
| **TASK 4** | Constructors | Default constructor, parameterized constructor, overloading, `this(...)` |
| **TASK 5** | Static & Lifecycle | `static` variables, `static` methods, Metaspace vs Heap, 5 lifecycle stages |
| **TASK 6** | Inheritance | Single, Hierarchical, Multi-level inheritance, `super(...)`, `super.method()` |
| **TASK 7** | Object Overrides | Polymorphic `toString()`, `equals()` value equality, `hashCode()` contract |
| **TASK 8** | Interfaces | `interface Chargeable`, `abstract class Vehicle`, dynamic dispatch, `instanceof` |
| **TASK 9** | Abstraction | Abstract classes vs. interfaces, multiple interface implementation |
| **TASK 10** | Encapsulation | `private`, default, `protected`, `public`, defensive setter validation |
| **TASK 11** | End-to-End System | Complete vehicle check-in, ticket issuance, exit billing, audit report |
| **TASK 12** | Advanced Extensions | 5-Floor **jagged array**, flat fee E-Bike, peak Delivery Van, One-Day Pass |

---

## 5. How to Open the Project in VS Code

1. Launch **Visual Studio Code**.
2. Go to **File** > **Open Folder...** (or press `Ctrl + K Ctrl + O`).
3. Select your project folder:
   ```text
   C:\Users\HP\OneDrive\Desktop\CO-1 ASSIGINMENT\CSA09-YourRegisterNumber-Assignment1
   ```
4. Open the built-in terminal: press **`Ctrl + ~`** (or go to **Terminal** > **New Terminal**).

---

## 6. Exact Terminal Commands to Compile and Run Each Task

Every task folder is self-contained with its own runnable main class.

### TASK 1: Problem Definition & Candidate Classes
```bash
cd "TASK 1"
javac TASK1.java
java TASK1
cd ..
```

### TASK 2: Java Data Types, Arrays & Parking Grid
```bash
cd "TASK 2"
javac Task2.java
java Task2
cd ..
```

### TASK 3: Parking Facility Allocation & Release Logic
```bash
cd "TASK 3"
javac ParkingFacility.java
java ParkingFacility
cd ..
```

### TASK 4: Constructors, Overloading & 'this' Keyword
```bash
cd "TASK 4"
javac Task4.java
java Task4
cd ..
```

### TASK 5: Static Members & Object Life Cycle
```bash
cd "TASK 5"
javac Task5.java
java Task5
cd ..
```

### TASK 6: Vehicle Inheritance & super() Keyword
```bash
cd "TASK 6"
javac Task6.java
java Task6
cd ..
```

### TASK 7: toString(), equals(), hashCode() & Duplicate Checking
```bash
cd "TASK 7"
javac Task7.java
java Task7
cd ..
```

### TASK 8: Chargeable Interface & Fee Hierarchy
```bash
cd "TASK 8"
javac FeeDemo.java
java FeeDemo
cd ..
```

### TASK 9: Abstract Vehicle Class & Interface Contracts
```bash
cd "TASK 9"
javac Task9.java
java Task9
cd ..
```

### TASK 10: Encapsulation & Defensive Data Validation
```bash
cd "TASK 10"
javac Task10.java
java Task10
cd ..
```

### TASK 11: End-to-End Working Parking System Application
```bash
cd "TASK 11"
javac Main.java
java Main
cd ..
```

### TASK 12: Advanced Multi-Floor Jagged Array & Extended Pricing
```bash
cd "TASK 12"
javac *.java
java Main
cd ..
```

---

## 7. One-Click Automated Verification Script

To compile and execute all 12 tasks sequentially in one run, open PowerShell in the project root folder and execute:

```powershell
1..12 | ForEach-Object {
    $folder = "TASK $_"
    Write-Host "`n==============================================" -ForegroundColor Yellow
    Write-Host "   COMPILING & RUNNING $folder" -ForegroundColor Cyan
    Write-Host "==============================================" -ForegroundColor Yellow
    Push-Location $folder
    javac *.java
    if (Test-Path "TASK1.java") { java TASK1 }
    elseif (Test-Path "Task2.java") { java Task2 }
    elseif (Test-Path "ParkingFacility.java") { java ParkingFacility }
    elseif (Test-Path "Task4.java") { java Task4 }
    elseif (Test-Path "Task5.java") { java Task5 }
    elseif (Test-Path "Task6.java") { java Task6 }
    elseif (Test-Path "Task7.java") { java Task7 }
    elseif (Test-Path "FeeDemo.java") { java FeeDemo }
    elseif (Test-Path "Task9.java") { java Task9 }
    elseif (Test-Path "Task10.java") { java Task10 }
    elseif (Test-Path "Main.java") { java Main }
    Pop-Location
}
```

---

## 8. Summary of Results

| Task | Key Output Highlight | Verification Status |
| :--- | :--- | :--- |
| **TASK 1** | Candidate vehicles and slots instantiated; tickets issued successfully | Passed (Code 0) |
| **TASK 2** | Formatted 2D parking matrix rendered; occupancy computed at 41.67% | Passed (Code 0) |
| **TASK 3** | Sequential allocations `[0,0]`, `[0,1]`, `[1,0]`, `null`, `true false false`, `[0,1]` | Passed (Code 0) |
| **TASK 4** | Constructor chaining via `this(...)` initializes default, 2-arg, and 3-arg slots | Passed (Code 0) |
| **TASK 5** | Static ticket sequence auto-increments to 1003; 5-stage lifecycle demonstrated | Passed (Code 0) |
| **TASK 6** | `super(...)` chains through `BaseVehicle -> CarVehicle -> ElectricCarVehicle` | Passed (Code 0) |
| **TASK 7** | Logical equality (`equals`) detects duplicate plates; hashCode contract holds true | Passed (Code 0) |
| **TASK 8** | Polymorphic rates: Bike Rs 30.0, Car Rs 90.0, EV Rs 210.0; `instanceof Chargeable = true` | Passed (Code 0) |
| **TASK 9** | AbstractVehicle array processed; gate pass, security clearance, and invoices printed | Passed (Code 0) |
| **TASK 10** | Invalid floor (9), negative hours (-5), short plate ("AB") rejected defensively | Passed (Code 0) |
| **TASK 11** | Full lifecycle: entry, ticket, duplicate rejection, exit billing, Rs 110.0 daily total | Passed (Code 0) |
| **TASK 12** | 5-Floor jagged array (33 slots), flat E-Bike (Rs 20), peak Van (Rs 240), One-Day Pass (Rs 150) | Passed (Code 0) |

---

## 9. How to Capture Screenshots for Submission

1. Open VS Code integrated terminal (`Ctrl + ~`).
2. Run the specific task command (e.g., `cd "TASK 1"`, `javac TASK1.java`, `java TASK1`).
3. Press **`Win + Shift + S`** (Windows Snipping Tool) or **`Alt + PrtScn`**.
4. Select the terminal area showing your command and the full terminal output.
5. Paste (`Ctrl + V`) the captured screenshot directly into your assignment Word document under that task's screenshot placeholder box.

---

## 10. How to Upload Project to GitHub

Follow these simple steps from VS Code terminal:

### Step 1: Initialize Git
```bash
git init
```

### Step 2: Add all files
```bash
git add .
```

### Step 3: Commit the changes
```bash
git commit -m "Complete CSA09 Assignment 1: Campus Smart-Parking System (Tasks 1 to 12)"
```

### Step 4: Create a Repository on GitHub
1. Open your web browser and navigate to [https://github.com/new](https://github.com/new).
2. Enter the repository name: `CSA09-Assignment1-SmartParking`.
3. Choose **Public** visibility.
4. Leave "Add a README file" unchecked (you already have this one).
5. Click **Create repository**.

### Step 5: Link Local Repository and Push
```bash
git branch -M main
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/CSA09-Assignment1-SmartParking.git
git push -u origin main
```
*(Replace `YOUR_GITHUB_USERNAME` with your actual GitHub username).*

---

## 11. Viva Voce Defense Guide (Top Oral Examination Questions)

### Q1: What is the difference between an Abstract Class and an Interface in Java?
**Answer**:
- An **abstract class** (e.g., `AbstractVehicle` in Task 9) can maintain state (instance fields like `registrationNumber`), constructors, and concrete method implementations alongside abstract methods. A class can extend only one abstract class.
- An **interface** (e.g., `Chargeable` in Task 8 & 9, `PricingRule` in Task 12) defines a pure behavioral contract. A class can implement multiple interfaces (`implements Chargeable, SecurityInspectable`).

### Q2: Why did we override both `equals()` and `hashCode()` in Task 7?
**Answer**:
According to the Java Object Contract, if two objects are equal according to `equals(Object obj)`, they **must** return the identical integer from `hashCode()`. In our system, two distinct vehicle objects in heap memory representing the same registration plate (e.g., `"TN07CK1234"`) are logically equal. If we didn't override `hashCode()`, hashing collections (like `HashSet` or `HashMap`) would fail to recognize them as duplicates, causing unauthorized double entries.

### Q3: What is a Jagged Array and why is it used in Task 3 and Task 12?
**Answer**:
A **jagged array** is an array of arrays where each row can have a different column capacity (`String[][] floors = new String[5][]`). In Task 12, Floor 0 has 10 slots, Floor 1 has 8 slots, Floor 2 has 6 slots, Floor 3 has 5 slots, and Floor 4 has 4 slots. Physical parking buildings rarely have identical capacity across all floors due to ramps, elevators, and structural pillars. Jagged arrays prevent memory wastage compared to a rigid rectangular matrix.

### Q4: How does constructor chaining work using `this(...)` and `super(...)`?
**Answer**:
- `this(...)` (Task 4) invokes an overloaded constructor in the **same class**, allowing default parameters to funnel into a single master constructor.
- `super(...)` (Task 6) invokes the constructor of the **immediate parent class**. It must be the very first statement in the subclass constructor to ensure the parent's state is initialized before subclass fields.

### Q5: How is dynamic method dispatch (runtime polymorphism) demonstrated in Task 8?
**Answer**:
When `Vehicle v = new ElectricCar("TN03C3")` invokes `v.calculateFee(3)`, the compiler checks the `Vehicle` reference type at compile time, but at runtime the Java Virtual Machine (JVM) dynamically dispatches the call to `ElectricCar.calculateFee(int)`, adding the charging fee surcharge of Rs 120.0.

### Q6: How does encapsulation protect system data in Task 10?
**Answer**:
By declaring fields as `private`, direct uncontrolled access from external classes is blocked. Modifying fields is strictly restricted to setter methods containing validation guards (e.g., rejecting negative hours, out-of-range floors 0-4, or invalid registration plates). If an input fails validation, the setter displays an error and leaves the existing valid state untouched.
