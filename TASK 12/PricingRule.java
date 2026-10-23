// ============================================================================
// Assignment 1 - TASK 12: PricingRule.java
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Flexible Strategy Pattern interface for dynamic parking pricing rules.
// ============================================================================

/**
 * Interface defining the strategy contract for parking fee calculation.
 */
public interface PricingRule {
    /**
     * Calculates fee based on entry hour, exit hour, and base vehicle rate.
     * 
     * @param entryHour 24-hour format (e.g., 9 for 9:00 AM)
     * @param exitHour  24-hour format (e.g., 14 for 2:00 PM)
     * @param baseRate  Standard hourly rate for vehicle type
     * @return Total parking fee in INR
     */
    double calculateFee(int entryHour, int exitHour, double baseRate);

    /**
     * Human-readable description of the pricing policy.
     */
    String getRuleDescription();
}
