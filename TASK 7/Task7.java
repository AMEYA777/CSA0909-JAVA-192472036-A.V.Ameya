// ============================================================================
// Assignment 1 - TASK 7: Method Overriding, equals(), hashCode(), and toString()
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate polymorphic overriding of standard java.lang.Object methods
//          to support value equality, hash contracts, and duplicate vehicle detection.
// ============================================================================

import java.util.Objects;

/**
 * Represents a registered vehicle with properly overridden Object methods.
 */
class RegisteredVehicle {
    private String registrationNumber;
    private String vehicleType;
    private String ownerName;

    public RegisteredVehicle(String registrationNumber, String vehicleType, String ownerName) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // ------------------------------------------------------------------------
    // 1. Overriding toString()
    // By default, Object.toString() prints: RegisteredVehicle@15db9742 (Memory Hash)
    // Overriding gives a meaningful, formatted representation.
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return "RegisteredVehicle [Plate=" + registrationNumber + ", Type=" + vehicleType + ", Owner=" + ownerName + "]";
    }

    // ------------------------------------------------------------------------
    // 2. Overriding equals(Object obj)
    // By default, Object.equals(o) uses 'this == o' (reference identity).
    // In our smart parking system, two vehicle objects are identical if they
    // share the same registration number, even if created at different memory locations!
    // ------------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        // Step 1: Self-check (are references pointing to the exact same object?)
        if (this == obj) {
            return true;
        }

        // Step 2: Null and class-type check
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Step 3: Type cast
        RegisteredVehicle other = (RegisteredVehicle) obj;

        // Step 4: Compare business key (case-insensitive license plate comparison)
        return this.registrationNumber != null &&
               this.registrationNumber.equalsIgnoreCase(other.registrationNumber);
    }

    // ------------------------------------------------------------------------
    // 3. Overriding hashCode()
    // JAVA CONTRACT: If two objects are equal via equals(), they MUST have
    // the same hashCode(). If you override equals(), you MUST override hashCode().
    // ------------------------------------------------------------------------
    @Override
    public int hashCode() {
        // Hash based on the uppercase registration number for case consistency
        return Objects.hash(registrationNumber.toUpperCase());
    }
}

/**
 * Main Class for Task 07
 */
public class Task7 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" TASK 7: toString(), equals() & hashCode() DEMO   ");
        System.out.println("==================================================\n");

        // Create two distinct vehicle objects in heap memory with the SAME registration number
        RegisteredVehicle v1 = new RegisteredVehicle("TN07CK1234", "Car", "Prof. Raman");
        RegisteredVehicle v2 = new RegisteredVehicle("TN07CK1234", "Car", "Prof. Raman");

        // Create a third vehicle with a DIFFERENT registration number
        RegisteredVehicle v3 = new RegisteredVehicle("TN09ZZ9999", "Two-Wheeler", "Student Pooja");

        // --------------------------------------------------------------------
        // Demonstration 1: toString()
        // --------------------------------------------------------------------
        System.out.println("--- 1. Testing toString() Overriding ---");
        System.out.println("v1: " + v1); // Automatically calls v1.toString()
        System.out.println("v3: " + v3);

        // --------------------------------------------------------------------
        // Demonstration 2: Reference Equality (==) vs Logical Equality (.equals())
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Reference Equality (==) vs Logical Equality (equals) ---");
        System.out.println("Comparing v1 and v2 with '==' (Reference check): " + (v1 == v2));
        System.out.println("Explanation: 'false' because v1 and v2 are two distinct objects stored in different heap addresses.");

        System.out.println("\nComparing v1 and v2 with '.equals()' (Value check): " + v1.equals(v2));
        System.out.println("Explanation: 'true' because our overridden equals() compares the registration numbers!");

        System.out.println("\nComparing v1 and v3 with '.equals()': " + v1.equals(v3));

        // --------------------------------------------------------------------
        // Demonstration 3: hashCode() Contract
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Testing hashCode() Contract ---");
        System.out.println("v1 hashCode: " + v1.hashCode());
        System.out.println("v2 hashCode: " + v2.hashCode());
        System.out.println("v3 hashCode: " + v3.hashCode());
        System.out.println("Do v1 and v2 share identical hashCodes? " + (v1.hashCode() == v2.hashCode()));

        // --------------------------------------------------------------------
        // Demonstration 4: Duplicate Detection in Parking
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Practical Application: Duplicate Entry Prevention ---");
        RegisteredVehicle[] activeLot = { v1 };
        RegisteredVehicle incomingVehicle = v2;

        boolean isDuplicate = false;
        for (RegisteredVehicle parked : activeLot) {
            if (parked.equals(incomingVehicle)) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            System.out.println("[ALERT] Cannot issue ticket! Vehicle " + incomingVehicle.getRegistrationNumber() + " is ALREADY parked in the facility.");
        } else {
            System.out.println("[PERMITTED] Vehicle granted entry.");
        }
    }
}
