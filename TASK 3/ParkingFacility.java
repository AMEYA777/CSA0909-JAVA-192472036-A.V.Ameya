// ============================================================================
// Assignment 1 - TASK 3: Parking Facility Allocation & Release Logic
// Course: CSA09 - Object-Oriented Programming in Java
// Purpose: Implement allocate() and release() methods for smart parking management.
// ============================================================================

import java.util.Arrays;

public class ParkingFacility {

    // 2D grid representing parking spots (false = vacant, true = occupied)
    // Floor 0 has 2 spots, Floor 1 has 1 spot (total 3 spots capacity)
    private boolean[][] slots;

    /**
     * Default constructor: initializes the facility grid layout.
     */
    public ParkingFacility() {
        // Jagged array representation:
        // Floor 0: 2 slots -> [0, 0], [0, 1]
        // Floor 1: 1 slot  -> [1, 0]
        this.slots = new boolean[][] {
            new boolean[2],
            new boolean[1]
        };
    }

    /**
     * Allocates the first available parking slot in the facility.
     * Iterates through rows and columns to find an unoccupied spot.
     * 
     * @return int[] array of size 2 containing [row, col] of the allocated slot,
     *         or null if all slots are currently occupied.
     */
    public int[] allocate() {
        for (int r = 0; r < slots.length; r++) {
            for (int c = 0; c < slots[r].length; c++) {
                if (!slots[r][c]) { // Found a vacant slot
                    slots[r][c] = true; // Mark as occupied
                    return new int[] { r, c };
                }
            }
        }
        return null; // Facility is full
    }

    /**
     * Releases a previously allocated parking spot at given coordinates.
     * Validates boundaries and current occupancy status.
     * 
     * @param r Row index of the slot
     * @param c Column index of the slot
     * @return true if successfully freed; false if coordinates are invalid
     *         or if the spot was already vacant.
     */
    public boolean release(int r, int c) {
        // Step 1: Validate row and column boundaries
        if (r < 0 || r >= slots.length) {
            return false;
        }
        if (c < 0 || c >= slots[r].length) {
            return false;
        }

        // Step 2: Check if slot is occupied
        if (slots[r][c]) {
            slots[r][c] = false; // Mark slot as free
            return true;
        }

        // Step 3: Spot was already vacant
        return false;
    }

    /**
     * Main method: strictly executes the test scenario specified by the assignment.
     */
    public static void main(String[] args) {
        ParkingFacility facility = new ParkingFacility();

        // Sequential allocations
        System.out.println(Arrays.toString(facility.allocate()));
        System.out.println(Arrays.toString(facility.allocate()));
        System.out.println(Arrays.toString(facility.allocate()));
        System.out.println(Arrays.toString(facility.allocate()));

        // Release attempts: valid release, double-release, out-of-bounds release
        System.out.println(facility.release(0, 1) + " " + facility.release(0, 1) + " " + facility.release(5, 5));

        // Re-allocation into the newly freed slot
        System.out.println(Arrays.toString(facility.allocate()));
    }
}
