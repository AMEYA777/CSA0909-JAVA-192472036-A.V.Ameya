================================================================================
CSA09 Assignment 1 - TASK 12: Advanced Multi-Floor System & Flexible Pricing Strategies
================================================================================

1. TASK OBJECTIVE:
To implement advanced architectural extensions and dynamic pricing policies requested 
in the assignment specifications:
- 5-Floor Parking Structure with differing slot capacities modeled as a JAGGED ARRAY:
  * Floor 0 (Ground): 10 slots
  * Floor 1 (First) : 8 slots
  * Floor 2 (Second): 6 slots
  * Floor 3 (Third) : 5 slots
  * Floor 4 (Rooftop): 4 slots (Total = 33 slots)
- Subsidized E-Bikes charged a flat parking fee of Rs 20.0 regardless of duration.
- Commercial Delivery Vans charged double the standard car rate (Rs 60.0/hr vs Rs 30.0/hr) 
  during business peak hours (9:00 AM to 5:00 PM / 09:00 to 17:00).
- Campus Visitor One-Day Passes offering all-day unlimited parking for a fixed Rs 150.0.
- Flexible Strategy Pattern via `PricingRule` interface allowing runtime fee strategy switching.

2. FILES COMPRISING TASK 12:
1. `PricingRule.java`: Strategy interface defining calculateFee(entry, exit, baseRate).
2. `E_Bike.java`: Encapsulates green mobility vehicle with flat fee policy.
3. `DeliveryVan.java`: Encapsulates commercial carrier with hour-by-hour peak detection.
4. `OneDayPass.java`: Encapsulates visitor one-day prepaid parking credentials.
5. `Main.java`: Integrates the 5-floor jagged facility, executes end-to-end tests, 
   renders jagged occupancy maps, and generates the audit report.

3. ALGORITHM / WORKFLOW:
Step 1: Instantiate `MultiFloorParkingFacility` with jagged array `String[5][]`.
Step 2: Allocate slots for Floor 0 (10), Floor 1 (8), Floor 2 (6), Floor 3 (5), Floor 4 (4).
Step 3: Instantiate E-Bike EB-901, allocate slot, simulate 7-hour parking, apply flat rule (Rs 20.0), 
        release slot, and record revenue.
Step 4: Instantiate Delivery Van DL01COMM12, allocate slot, simulate parking from 10 AM to 2 PM 
        (4 peak hours @ Rs 60.0/hr = Rs 240.0), release slot, and record revenue.
Step 5: Issue Visitor One-Day Pass PASS-2024-001 (flat Rs 150.0), allocate slot, allow barrier 
        passage with zero exit balance, and record revenue.
Step 6: Fill 15 standard car slots across floors to demonstrate jagged array memory distribution.
Step 7: Render 5-Floor visual occupancy map with slot bracket counts.
Step 8: Output daily financial audit report showing total revenue (Rs 410.0) and individual logs.
Step 9: Stop.

4. COMPILATION AND EXECUTION COMMANDS:
In VS Code terminal:
   cd "TASK 12"
   javac *.java
   java Main
   cd ..

5. ACTUAL PROGRAM OUTPUT:
==================================================
 TASK 12: EXTENDED MULTI-FLOOR SMART PARKING      
==================================================

--- 1. Testing Jagged Array Initial State ---

--------------------------------------------------
  5-FLOOR JAGGED ARRAY FACILITY OCCUPANCY MAP     
--------------------------------------------------
Floor 0 (10 slots max): [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]  -> (0/10 occupied)
Floor 1 ( 8 slots max): [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]  -> (0/8 occupied)
Floor 2 ( 6 slots max): [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]  -> (0/6 occupied)
Floor 3 ( 5 slots max): [ . ] [ . ] [ . ] [ . ] [ . ]  -> (0/5 occupied)
Floor 4 ( 4 slots max): [ . ] [ . ] [ . ] [ . ]  -> (0/4 occupied)
Total Facility Capacity : 33 slots
Total Currently Parked  : 0 slots
Available Slots         : 33 slots
--------------------------------------------------

--- 2. Simulating E-Bike Parking (Flat Fee Feature) ---
  E-Bike Serial : EB-901
  Rider Name    : Kavya (Student)
  Fee Policy    : Flat Rate Rs 20.0 (All-day)
[PARKED] E-Bike allocated Floor 0, Slot #0
[EXITED] E-Bike checked out. Hours parked: 7 hrs | Flat Fee charged: Rs 20.0

--- 3. Simulating Delivery Van (Peak Hours 9 AM - 5 PM Double Rate) ---
  Delivery Van  : DL01COMM12
  Company       : Express Logistics
  Pricing Rule  : Double Car Rate (Rs 60/hr) during 9 AM - 5 PM
[PARKED] Delivery Van allocated Floor 0, Slot #0
  [DELIVERY VAN PRICING BREAKDOWN]
    Peak Hours (9 AM-5 PM) : 4 hr(s) @ Rs 60.0/hr = Rs 240.0
    Off-Peak Hours         : 0 hr(s) @ Rs 30.0/hr = Rs 0.0
    Total Van Parking Fee  : Rs 240.0
[EXITED] Delivery Van cleared from slot.

--- 4. Simulating Visitor One-Day Pass ---
==========================================
       CAMPUS VISITOR ONE-DAY PASS        
==========================================
Pass ID       : PASS-2024-001
Visitor Name  : Dr. Vikram Seth
Vehicle Plate : DL03VIP007
Visit Purpose : Guest Speaker Convocation
Fixed Cost    : Rs 150.0 (Valid all day)
Status        : ACTIVE
==========================================

[PARKED] Visitor Car allocated Floor 0, Slot #0
[EXITED] Visitor used One-Day Pass. Exit barrier opened with zero exit balance.

--- 5. Populating Slots Across Multiple Floors to Demonstrate Jagged Capacities ---
Allocated CAR-101 -> Floor 0, Slot #0
Allocated CAR-111 -> Floor 1, Slot #0
Allocated CAR-115 -> Floor 1, Slot #4

--------------------------------------------------
  5-FLOOR JAGGED ARRAY FACILITY OCCUPANCY MAP     
--------------------------------------------------
Floor 0 (10 slots max): [ CAR-101 ] [ CAR-102 ] [ CAR-103 ] [ CAR-104 ] [ CAR-105 ] [ CAR-106 ] [ CAR-107 ] [ CAR-108 ] [ CAR-109 ] [ CAR-110 ]  -> (10/10 occupied)
Floor 1 ( 8 slots max): [ CAR-111 ] [ CAR-112 ] [ CAR-113 ] [ CAR-114 ] [ CAR-115 ] [ . ] [ . ] [ . ]  -> (5/8 occupied)
Floor 2 ( 6 slots max): [ . ] [ . ] [ . ] [ . ] [ . ] [ . ]  -> (0/6 occupied)
Floor 3 ( 5 slots max): [ . ] [ . ] [ . ] [ . ] [ . ]  -> (0/5 occupied)
Floor 4 ( 4 slots max): [ . ] [ . ] [ . ] [ . ]  -> (0/4 occupied)
Total Facility Capacity : 33 slots
Total Currently Parked  : 15 slots
Available Slots         : 18 slots
--------------------------------------------------


==========================================
   TASK 12: DAILY REVENUE AUDIT REPORT    
==========================================
  * E-Bike EB-901 (Parked 7 hrs) -> Flat Fee: Rs 20.0
  * Delivery Van DL01COMM12 (10 AM to 2 PM, 4 peak hrs) -> Rs 240.0
  * Visitor Pass PASS-2024-001 (DL03VIP007) -> Rs 150.0
------------------------------------------
TOTAL REVENUE COLLECTED : Rs 410.0
==========================================

6. HOW TO CAPTURE SCREENSHOT FOR SUBMISSION:
1. Open VS Code terminal (`Ctrl + ~`).
2. Run `cd "TASK 12"`, `javac *.java`, and `java Main`.
3. Capture with `Win + Shift + S`.
4. Paste under the Task 12 section in your report.
