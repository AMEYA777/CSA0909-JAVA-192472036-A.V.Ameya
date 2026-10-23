// ============================================================================
// Assignment 1 - TASK 8: Chargeable Interface & Fee Hierarchy (FeeDemo.java)
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Implement Chargeable interface, Vehicle hierarchy, Car, and
//          ElectricCar classes. Preserve original main() method and output.
// ============================================================================

/**
 * Interface defining contract for fee calculation.
 */
interface Chargeable {
    double calculateFee(int hours);
    double calculateFee(); // Overload with default duration
}

/**
 * Base abstract class for all vehicles.
 */
abstract class Vehicle implements Chargeable {
    public String regNo;
    protected int hoursParked = 3; // Default 3 hours

    public Vehicle(String regNo) {
        this.regNo = regNo;
        this.hoursParked = 3;
    }

    public Vehicle(String regNo, int hours) {
        this.regNo = regNo;
        this.hoursParked = hours;
    }

    public String getRegNo() {
        return regNo;
    }

    @Override
    public double calculateFee() {
        return calculateFee(this.hoursParked);
    }
}

/**
 * TwoWheeler class: Rs 10 per hour.
 */
class TwoWheeler extends Vehicle {
    private static final double HOURLY_RATE = 10.0;

    public TwoWheeler(String regNo) {
        super(regNo);
    }

    public TwoWheeler(String regNo, int hours) {
        super(regNo, hours);
    }

    @Override
    public double calculateFee(int hours) {
        return hours * HOURLY_RATE;
    }
}

/**
 * Car class: Rs 30 per hour.
 */
class Car extends Vehicle {
    protected static final double HOURLY_RATE = 30.0;

    public Car(String regNo) {
        super(regNo);
    }

    public Car(String regNo, int hours) {
        super(regNo, hours);
    }

    @Override
    public double calculateFee(int hours) {
        return hours * HOURLY_RATE;
    }
}

/**
 * ElectricCar class: Inherits Car base fee + Rs 120 charging service fee.
 * For 3 hours: 3 * 30 + 120 = Rs 210.0.
 */
class ElectricCar extends Car {
    private static final double CHARGING_SERVICE_FEE = 120.0;

    public ElectricCar(String regNo) {
        super(regNo);
    }

    public ElectricCar(String regNo, int hours) {
        super(regNo, hours);
    }

    @Override
    public double calculateFee(int hours) {
        // Base car parking rate + electric vehicle charging surcharge
        return super.calculateFee(hours) + CHARGING_SERVICE_FEE;
    }
}

/**
 * Main Class: FeeDemo
 * Preserves the original main method logic and produces the exact output required.
 */
public class FeeDemo {
    public static void main(String[] args) {
        Vehicle v1 = new TwoWheeler("TN01A1");
        Vehicle v2 = new Car("TN02B2");
        Vehicle v3 = new ElectricCar("TN03C3");

        System.out.println("TwoWheeler " + v1.getRegNo() + " -> Rs " + v1.calculateFee(3));
        System.out.println("Car " + v2.getRegNo() + " -> Rs " + v2.calculateFee(3));
        System.out.println("ElectricCar " + v3.getRegNo() + " -> Rs " + v3.calculateFee(3));
        System.out.println(v3 instanceof Chargeable);
    }
}
