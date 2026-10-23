// ============================================================================
// Assignment 1 - TASK 9: Abstract Vehicle Class & Chargeable Interface Contracts
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate the design contrast between an abstract class (partial
//          implementation with state) and an interface (pure behavioral contract),
//          along with multiple interface implementation in Java.
// ============================================================================

/**
 * Interface 1: Chargeable
 * Pure contract for calculating fees and printing invoices.
 */
interface Chargeable {
    double calculateFee(int durationHours);
    void printInvoice(int durationHours);
}

/**
 * Interface 2: SecurityInspectable
 * Demonstrates multiple interface implementation in Java.
 */
interface SecurityInspectable {
    boolean performSecurityCheck();
}

/**
 * Abstract Class: AbstractVehicle
 * Cannot be directly instantiated. Contains common state (fields), constructor,
 * and both concrete and abstract methods.
 */
abstract class AbstractVehicle implements Chargeable, SecurityInspectable {
    protected String registrationNumber;
    protected String driverName;
    protected String driverCategory; // "Student", "Faculty", "Visitor"

    // Abstract class constructor
    public AbstractVehicle(String registrationNumber, String driverName, String driverCategory) {
        this.registrationNumber = registrationNumber;
        this.driverName = driverName;
        this.driverCategory = driverCategory;
    }

    // Concrete method: Common functionality shared by all subclasses
    public void printGatePass() {
        System.out.println("GATE PASS -> Reg: " + registrationNumber + " | Driver: " + driverName + " (" + driverCategory + ")");
    }

    // Abstract method: Must be uniquely implemented by each subclass
    public abstract String getVehicleCategory();
    public abstract double getHourlyRate();

    // Default implementation of security check for campus vehicles
    @Override
    public boolean performSecurityCheck() {
        System.out.println("  [SECURITY CHECK] Vehicle " + registrationNumber + ": Trunk & ID inspected -> CLEARED");
        return true;
    }

    // Common invoice generator using dynamic polymorphism
    @Override
    public void printInvoice(int durationHours) {
        double fee = calculateFee(durationHours);
        System.out.println("==========================================");
        System.out.println("           CAMPUS PARKING INVOICE         ");
        System.out.println("==========================================");
        System.out.println("Vehicle Type  : " + getVehicleCategory());
        System.out.println("Plate Number  : " + registrationNumber);
        System.out.println("Driver        : " + driverName + " (" + driverCategory + ")");
        System.out.println("Hours Parked  : " + durationHours + " hrs");
        System.out.println("Rate Applied  : Rs " + getHourlyRate() + " / hr");
        System.out.println("Total Amount  : Rs " + fee);
        System.out.println("==========================================\n");
    }
}

/**
 * Concrete Subclass 1: CampusTwoWheeler
 */
class CampusTwoWheeler extends AbstractVehicle {
    public CampusTwoWheeler(String regNo, String driver, String category) {
        super(regNo, driver, category);
    }

    @Override
    public String getVehicleCategory() {
        return "Two-Wheeler (Motorcycle/Scooter)";
    }

    @Override
    public double getHourlyRate() {
        // Subsidized fee for students/faculty
        return driverCategory.equalsIgnoreCase("Student") ? 10.0 : 15.0;
    }

    @Override
    public double calculateFee(int durationHours) {
        return durationHours * getHourlyRate();
    }
}

/**
 * Concrete Subclass 2: CampusCar
 */
class CampusCar extends AbstractVehicle {
    public CampusCar(String regNo, String driver, String category) {
        super(regNo, driver, category);
    }

    @Override
    public String getVehicleCategory() {
        return "Four-Wheeler (Car/SUV)";
    }

    @Override
    public double getHourlyRate() {
        return driverCategory.equalsIgnoreCase("Visitor") ? 40.0 : 25.0;
    }

    @Override
    public double calculateFee(int durationHours) {
        return durationHours * getHourlyRate();
    }
}

/**
 * Main Class for Task 09
 */
public class Task9 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" TASK 9: ABSTRACT CLASS & CHARGEABLE CONTRACTS    ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Polymorphic Collection of AbstractVehicle ---");
        // Array of abstract type containing heterogeneous concrete subclasses
        AbstractVehicle[] vehicles = new AbstractVehicle[] {
            new CampusTwoWheeler("TN14Z1001", "Arun (B.Tech)", "Student"),
            new CampusCar("TN02K5566", "Prof. Meenakshi", "Faculty"),
            new CampusCar("KA03MM8899", "Vendor Rajesh", "Visitor")
        };

        int parkedDuration = 4; // 4 hours simulation

        for (AbstractVehicle v : vehicles) {
            v.printGatePass();
            v.performSecurityCheck();
            v.printInvoice(parkedDuration);
        }

        System.out.println("--- 2. Key Takeaways ---");
        System.out.println("1. 'AbstractVehicle' cannot be instantiated directly with 'new AbstractVehicle()'.");
        System.out.println("2. 'Chargeable' and 'SecurityInspectable' enforce contracts ensuring all vehicles");
        System.out.println("   can be billed and inspected polymorphically.");
    }
}
