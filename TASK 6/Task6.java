// ============================================================================
// Assignment 1 - TASK 6: Vehicle Inheritance Hierarchy & super() Keyword
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Demonstrate single, hierarchical, and multi-level inheritance in Java
//          with clear, beginner-friendly explanations of the super() keyword.
// ============================================================================

/**
 * Base Class (Superclass)
 * Defines common state and behavior shared by all motorized campus vehicles.
 */
class BaseVehicle {
    protected String registrationNumber;
    protected String brand;
    protected double baseHourlyRate;

    // Base class constructor
    public BaseVehicle(String registrationNumber, String brand, double baseHourlyRate) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.baseHourlyRate = baseHourlyRate;
        System.out.println("  [BASE CONSTRUCTOR] BaseVehicle initialized for: " + registrationNumber);
    }

    public void displayDetails() {
        System.out.println("Registration : " + registrationNumber);
        System.out.println("Brand        : " + brand);
        System.out.println("Base Rate    : Rs " + baseHourlyRate + " / hour");
    }
}

/**
 * Single Inheritance: TwoWheeler IS-A BaseVehicle
 */
class TwoWheelerVehicle extends BaseVehicle {
    private boolean hasHelmetStorage;

    public TwoWheelerVehicle(String registrationNumber, String brand, double baseHourlyRate, boolean hasHelmetStorage) {
        // EXPLANATION OF super(...):
        // 1. 'super' refers directly to the immediate parent class (BaseVehicle).
        // 2. 'super(...)' must be the VERY FIRST statement in this constructor.
        // 3. It passes parameters up to initialize the fields defined in BaseVehicle.
        super(registrationNumber, brand, baseHourlyRate);

        this.hasHelmetStorage = hasHelmetStorage;
        System.out.println("  [SUBCLASS CONSTRUCTOR] TwoWheelerVehicle initialized.");
    }

    @Override
    public void displayDetails() {
        // EXPLANATION OF super.method():
        // Re-uses parent's display logic without re-writing print statements!
        super.displayDetails();
        System.out.println("Helmet Storage: " + (hasHelmetStorage ? "Available" : "Not Available"));
    }
}

/**
 * Hierarchical Inheritance: Car IS-A BaseVehicle
 */
class CarVehicle extends BaseVehicle {
    protected int seatingCapacity;

    public CarVehicle(String registrationNumber, String brand, double baseHourlyRate, int seatingCapacity) {
        // Calls BaseVehicle constructor first
        super(registrationNumber, brand, baseHourlyRate);
        this.seatingCapacity = seatingCapacity;
        System.out.println("  [SUBCLASS CONSTRUCTOR] CarVehicle initialized with " + seatingCapacity + " seats.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Cap  : " + seatingCapacity + " passengers");
    }
}

/**
 * Multi-Level Inheritance: ElectricCar IS-A CarVehicle IS-A BaseVehicle
 */
class ElectricCarVehicle extends CarVehicle {
    private double batteryCapacityKWh;
    private boolean isChargingRequested;

    public ElectricCarVehicle(String registrationNumber, String brand, double baseHourlyRate,
                              int seatingCapacity, double batteryCapacityKWh, boolean isChargingRequested) {
        // Calls CarVehicle constructor, which in turn calls BaseVehicle constructor.
        // Execution sequence: BaseVehicle -> CarVehicle -> ElectricCarVehicle
        super(registrationNumber, brand, baseHourlyRate, seatingCapacity);

        this.batteryCapacityKWh = batteryCapacityKWh;
        this.isChargingRequested = isChargingRequested;
        System.out.println("  [MULTI-LEVEL CONSTRUCTOR] ElectricCarVehicle initialized (" + batteryCapacityKWh + " kWh).");
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Calls CarVehicle displayDetails (which also calls BaseVehicle)
        System.out.println("Battery Size : " + batteryCapacityKWh + " kWh");
        System.out.println("EV Charging  : " + (isChargingRequested ? "Active (Charging Slot)" : "Standard Slot"));
    }
}

/**
 * Main Class for Task 06
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  TASK 6: INHERITANCE HIERARCHY & super() DEMO    ");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Instantiating TwoWheeler (Single Inheritance) ---");
        TwoWheelerVehicle bike = new TwoWheelerVehicle("TN10AB1234", "Honda Activa", 10.0, true);
        System.out.println("\n[Details]");
        bike.displayDetails();

        System.out.println("\n--------------------------------------------------");
        System.out.println("--- 2. Instantiating Car (Hierarchical Inheritance) ---");
        CarVehicle car = new CarVehicle("TN09XY9988", "Maruti Suzuki Swift", 30.0, 5);
        System.out.println("\n[Details]");
        car.displayDetails();

        System.out.println("\n--------------------------------------------------");
        System.out.println("--- 3. Instantiating ElectricCar (Multi-Level Inheritance) ---");
        ElectricCarVehicle ev = new ElectricCarVehicle("TN01EV0001", "Tata Nexon EV", 35.0, 5, 40.5, true);
        System.out.println("\n[Details]");
        ev.displayDetails();
    }
}
